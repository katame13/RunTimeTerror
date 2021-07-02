import React from 'react';

const ReviewTile = (props) => {
  const { userName, review, longestRelationship, rating } = props.review;
  return (
    <div>
    <div className="review-tile">
      <p>Rating: {rating}</p>
      <p>Longest Relationship: {longestRelationship} weeks</p>
      <p>"{review}"</p>
      <p>~{userName}</p>
    </div>
    </div>
  )
}

export default ReviewTile;