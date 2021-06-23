import React, {useState } from "react"
import _ from 'lodash'
const NewReviewForm = (props) => {
  const[formPayLoad, setFormPayLoad] = useState({
    name: "",
    rating: "",
    review: "",
    longestRelationship: ""
  })
  const[errors, setErrors] = useState({})
  const validForSubmission = () => {
    const errors = {}
    for(const field in formPayload) {
      if(formPayload[field].trim() === "") {
        errors[field] = "is blank"
      }
    }
    setErrors(errors)
    return _.isEmpty(errors)
  }
  const clearForm = () =>{
    setFormPayLoad({
      name: "",
      rating:"",
      review: "",
      longestRelationship: ""
    })
    setErrors({})
  }
  const handleSubmit = (event) =>{
    event.preventDefault()
    if(validForSubmission()){
      props.postReviewForm(formPayLoad)
      clearForm()
    }
  }
  const handleInputChange = event => {
    setFormPayload({
      ...formPayload,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }
  return(
      <form className="review" onSubmit={handleSubmit}>
        <ErrorList errors={{...errors, ...props.errors}} />
        <div>
          <label htmlFor="name">Name: </label>
          <input
              name="name"
              id="name"
              type="text"
              value={formPayload.name}
              onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="rating">Rating: </label>
          <input
              name="rating"
              id="rating"
              type="number"
              value={formPayload.rating}
              onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="review">Review: </label>
          <input
              name="review"
              id="review"
              type="text"
              value={formPayload.review}
              onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="longestRelationship">Longest Relationship: </label>
          <input
              name="longestRelationship"
              id="longestRelationship"
              type="number"
              value={formPayload.longestRelationship}
              onChange={handleInputChange}
          />
        </div>
        <input className="button" type="submit" value="Submit" />
      </form>
  )
}
export default NewReviewForm