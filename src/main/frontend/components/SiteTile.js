import React from 'react'
import {Link} from "react-router-dom";
import StarRatingComponent from 'react-star-rating-component';

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
    <div className="site-tile">
        <Link to={`/sites/${id}`}>
          <img src={imgUrl}></img>
          <h2>{name}</h2>
        </Link>
        {/*<h4>Average Rating: {aveRating.toPrecision(3)}</h4>*/}
        <h4>Average Rating:
      <StarRatingComponent
        name="rate2"
        editing={false}
        starCount={5}
        value={aveRating}
      /></h4>
        <h5>Average Relationship Length: {aveRelationship.toPrecision(
          3)} weeks</h5>
    </div>
  )
}

export default SiteTile