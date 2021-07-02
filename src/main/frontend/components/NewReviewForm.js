import React, {useState} from "react"
import _ from 'lodash'
import ErrorList from "./ErrorList";

const NewReviewForm = (props) => {
  const [formPayload, setFormPayload] = useState({
    userName: "",
    rating: "",
    review: "",
    longestRelationship: ""
  })
  const [errors, setErrors] = useState({})
  const validForSubmission = () => {
    const errors = {}

    const requiredFields = ["rating"]
    requiredFields.forEach(field => {
      if (formPayload[field].trim() === "") {
        errors[field] = "is blank"
      }
    })
    setErrors(errors)
    return _.isEmpty(errors)
  }

  const clearForm = () => {
    setFormPayload({
      userName: "",
      rating: "",
      review: "",
      longestRelationship: ""
    })
    setErrors({})
  }

  const handleSubmit = (event) => {
    event.preventDefault()
    if (validForSubmission()) {
      props.postReviewForm(formPayload)
      clearForm()
    }
  }

  const handleInputChange = event => {
    setFormPayload({
      ...formPayload,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  return (
    <form className="review-tile" onSubmit={handleSubmit}>
      <ErrorList errors={{...errors, ...props.errors}}/>
      <div className="formDiv">
        <label className="formLabel" htmlFor="userName">Name: </label>
        <input
          className="formField"
          name="userName"
          id="userName"
          type="text"
          value={formPayload.userName}
          onChange={handleInputChange}
        />
      </div>
      <div className="formDiv">
        <label className="formLabel" htmlFor="rating">Rating: </label>
        <input
          className="formField"
          name="rating"
          id="rating"
          type="number" min="1" max="5"
          value={formPayload.rating}
          onChange={handleInputChange}
        />
      </div>
      <div className="formDiv">
        <label className="formLabel" htmlFor="review">Review: </label>
        <textarea
          className="formField"
          name="review"
          id="review"
          type="text"
          value={formPayload.review}
          onChange={handleInputChange}
        />
      </div>
      <div className="formDiv">
        <label className="formLabel" htmlFor="longestRelationship"></label>
        <span>
        <span className="question">What was your longest relationship you had with someone you met on the site? Please enter in weeks.</span>
        <input
          className="formField"
          name="longestRelationship"
          id="longestRelationship"
          type="number"
          value={formPayload.longestRelationship}
          onChange={handleInputChange}
        />

        </span>
      </div>
      <input className="button" type="submit" value="Submit"/>
    </form>
  )
}
export default NewReviewForm