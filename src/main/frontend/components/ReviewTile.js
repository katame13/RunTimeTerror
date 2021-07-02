import React from 'react';
import StarRatingComponent from "react-star-rating-component";


const ReviewTile = (props) => {
  const { userName, review, longestRelationship, rating } = props.review;
  return (
    <div>
      <div className="review-tile">
        <div>Rating:
          <StarRatingComponent
            name="rate2"
            editing={false}
            starCount={5}
            value={rating}
          />
        </div>
        <p>Longest Relationship: {longestRelationship} weeks</p>
        <p>"{review}"</p>
        <p>~{userName}</p>
      </div>
    </div>
  )
}

export default ReviewTile;