import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Redirect } from "react-router-dom";

import NewReviewForm from "./NewReviewForm";
import ReviewTile from "./ReviewTile";

const SiteShow = (props) => {
  const [site, setSite] = useState({ reviews: [] });
  const [shouldRedirect, setShouldRedirect] = useState(false);
  const [formErrors, setFormErrors] = useState({});
  const [showForm, setShowForm] = useState(false);
  const [
    successfulApplicationStatus,
    setSuccessfulApplicationStatus,
  ] = useState(false);
  const siteId = props.match.params.id;

  const fetchSite = async () => {
    try {
      const response = await fetch(`/api/v1/sites/${siteId}`);
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw (error)
      }
      const siteData = await response.json();
      setSite(siteData.site);
    } catch (error) {
      console.error(`Error in fetch: ${error.message}`);
      setSite(null);
    }
  };

  const deleteSite = async () => {
    try {
      let response = await fetch(`/api/v1/sites/${siteId}`, {
        method: "DELETE",
        headers: new Headers({
          "Content-Type": "application/json",
        }),
      });
      if (!response.ok) {
        if (response.status === 422) {
          const body = await response.json();
          return setErrors(body.errors);
        } else {
          const errorMessage = `${response.status} (${response.statusText})`;
          const error = new Error(errorMessage);
          throw error;
        }
      }
      setShouldRedirect(true);
    } catch (error) {
      console.error(`Error in fetch: ${error.message}`);
    }
  };

  useEffect(() => {
    fetchSite();
  }, []);

  if (!site) {
    return (
      <div className="site-tile-container-header">
        <h1>Sorry this App/Dating Site can not be found</h1>
        <img
          src={"https://error404.fun/img/full-preview/1x/9.png"}
          height="100%"
          alt="Page Not Found"
        />
      </div>
    );
  }

  const postReviewForm = async (formPayload) => {
    try {
      const response = await fetch(`/api/v1/sites/${siteId}/reviews`, {
        method: "POST",
        headers: new Headers({
          "Content-Type": "application/json",
        }),
        body: JSON.stringify(formPayload),
      });
      if (!response.ok) {
        if (response.status === 422) {
          const body = await response.json();
          return setFormErrors(body.errors);
        } else {
          const errorMessage = `${response.status} (${response.statusText})`;
          const error = new Error(errorMessage);
          throw error;
        }
      }
      setSuccessfulApplicationStatus(true)
      setShowForm(false)
    } catch (error) {
      console.error(`Error in fetch: ${error.message}`)
    }
  };

  const reviewTiles = site.reviews.map((review) => {
    return <ReviewTile key={review.id} review={review} />;
  });

  const handleDeleteClick = (event) => {
    event.preventDefault();
    deleteSite();
  };

  const { id, name, description, imgUrl, url, category } = site;
  const handleFormButtonClick = (event) => {
    event.preventDefault();
    setShowForm(true);
  };

  let successMessageTag;
  if (successfulApplicationStatus) {
    successMessageTag = (
      <p>
        <strong>Your request is in process.</strong>
      </p>
    );
  }

  let newReviewForm;
  if (showForm) {
    newReviewForm = (
      <NewReviewForm
        key={id}
        siteId={id}
        postReviewForm={postReviewForm}
        errors={formErrors}
      />
    );
  }

  if (shouldRedirect) {
    return <Redirect push to= "/sites" />;
  }

  return (
    <div>
    <div className ="show-container">

      <div className="show-image">
      <img src={imgUrl} />
      </div>

      <div className="site-info">
      <a href={url}>
        <h1>{name}</h1>
      </a>
      <div className="site-story">
      <p>
        <strong>Description:</strong> {description}
      </p>
        <button type="button" className="button" onClick={handleFormButtonClick}>
        Add Review
        </button>
        <button>
        <a href={url} target="_blank">
        Visit Site
        </a>
        </button>
        <Link to={`/sites/edit/${siteId}`}>
        <button type="button">
        Edit Site
        </button>
        </Link>
        <button type="button" onClick={handleDeleteClick}>
        Delete Site{" "}
        </button>
        {successMessageTag}
        {newReviewForm}
      </div>
      </div>
      </div>
      <div>
        <h4 className="review-header">Reviews</h4>
        <div className="review-container">
        {reviewTiles}
        </div>
      </div>
    </div>
  );
};

export default SiteShow;
