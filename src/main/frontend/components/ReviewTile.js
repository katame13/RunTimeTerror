import React from 'react';

const ReviewTile = (props) =>{
  const{user, review, rating} = props.review;

  return(
    <div>
      <p>{user} {rating}</p>
      <p>{review}</p>
    </div>
  )
}

export default ReviewTile;