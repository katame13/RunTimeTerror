import React, {useEffect, useState} from "react";
import ReviewTile from "./ReviewTile";

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

const deleteSite = async () => {
try{
 let response = await fetch(`/api/v1/sites/${siteId}/delete`, {
 method: "DELETE",
 });
}catch(err){
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
        <a href={url}><p>Visit the Site</p></a>
      <p><strong>Description:</strong> {description}</p>
      {reviewTiles}
    </div>
  )
}

export default SiteShow;