import React from 'react';

const ReviewTile = (props) => {
  const {userName, review, longestRelationship, rating} = props.review;
  return (
      <div>
        <h4>Reviews</h4>
        <p>User Name: {userName}</p>
        <p>Rating: {rating}</p>
        <p>Longest Relationship: {longestRelationship}</p>
        <p>Review: {review}</p>
      </div>
  )
}

export default ReviewTile;