import React from 'react'
import {Link} from "react-router-dom";

const SiteTile = (props) => {
  const {id, name, url, imgUrl, category, description, reviews} = props.site

  let reviewsLength = reviews.length
  let sumRating = 0
  let sumRelationship = 0
  let aveRating = 0
  let aveRelationship = 0

  reviews.forEach(review => {
    sumRating += review.rating;
    sumRelationship += review.longestRelationship
  })
  aveRating = sumRating / reviewsLength
  aveRelationship = sumRelationship / reviewsLength

  return (
    <div>
      <div>
        <Link to={`/sites/${id}`}>
          <img src={imgUrl}></img>
          <h3>{name}</h3>
        </Link>
        <h3>Average Rating: {aveRating.toPrecision(3)}</h3>
        <h3>Average Length of Relationship: {aveRelationship.toPrecision(
          3)}</h3>
        <p>{description}</p>
      </div>
    </div>
  )
}

export default SiteTile