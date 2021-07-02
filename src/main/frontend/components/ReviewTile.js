import React from 'react';
import StarRatingComponent from "react-star-rating-component";


const ReviewTile = (props) => {
  const { userName, review, longestRelationship, rating } = props.review;
  return (
    <div>
      <h4>Reviews</h4>
      <p>User Name: {userName}</p>
      <div>Rating:
      <StarRatingComponent
        name="rate2"
        editing={false}
        starCount={5}
        value={rating}
      /></div>
      <p>Longest Relationship: {longestRelationship}</p>
      <p>Review: {review}</p>
    </div>
  )
}

export default ReviewTile;