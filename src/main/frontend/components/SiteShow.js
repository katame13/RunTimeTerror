import React, {useEffect, useState} from "react";
import ReviewTile from "./ReviewTile";
import NewReviewForm from "./NewReviewForm";

const SiteShow = (props) => {
  const [site, setSite] = useState({reviews: []});
  const siteId = props.match.params.id;

  const fetchSite = async () => {
    try {
      const response = await fetch(`/api/v1/sites/${siteId}`)
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw(error)
      }
      const siteData = await response.json()
      setSite(siteData.site)

    } catch (error) {
      console.error(`Error in fetch: ${error.message}`)
      setSite(null)
    }
  }

  useEffect(() => {
    fetchSite()
  }, [])

  if (!site) {
    return (
      <div>
        <h1>Sorry this App/Dating Site can not be found</h1>
        <img src={"https://error404.fun/img/full-preview/1x/9.png"}
             height="100%" alt="Page Not Found"/>
      </div>
    )
  }

  const postReviewForm = async (formPayload) => {
    try {
      const response = await fetch(
        `/api/v1/reviews/${siteId}/addreview`, {
          method: 'POST',
          headers: new Headers({
            'Content-Type': 'application/json'
          }),
          body: JSON.stringify(formPayload)
        })
      if (!response.ok) {
        if (response.status === 422) {
          const body = await response.json()
          debugger
          console.log(body.errors)
          return setFormErrors(body.errors)
        } else {
          const errorMessage = `${response.status} (${response.statusText})`
          const error = new Error(errorMessage)
          throw(error)
        }
      }
    } catch (err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  const reviewTiles = site.reviews.map(review => {
    return (
      <ReviewTile
        key={review.id}
        review={review}

      />
    )
  })

  const {id, name, description, imgUrl, url, category} = site

  return (
    <div>
      <a href={url}><h1>{name}</h1></a>
      <img src={imgUrl}/>
      <p><strong>Description:</strong> {description}</p>
      <NewReviewForm
        key={id}
        siteId={id}
        postReviewForm={postReviewForm}
      />
      {reviewTiles}
    </div>
  )
}

export default SiteShow;