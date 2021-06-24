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

 const postReviewForm = async (formPayLoad) => {
   try {
     const response = await fetch(`/api/v1/reviews`)
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
        siteId = {site.id}
        />
        {reviewTiles}
      </div>
  )
}

export default SiteShow;