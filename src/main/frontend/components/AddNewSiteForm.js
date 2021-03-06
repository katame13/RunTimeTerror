import React, { useState } from "react"
import { Redirect } from "react-router"
import _ from 'lodash'

import CategoryField from "./CategoryField"
import ErrorList from "./ErrorList"

const AddNewSiteForm = (props) => {
  const [formPayload, setFormPayLoad] = useState({
    name: "",
    url: "",
    imgUrl: "",
    description: "",
    categoryId: ""
  })

  const [errors, setErrors] = useState({})
  const [siteId, setSiteId] = useState(null)
  const [shouldRedirect, setShouldRedirect] = useState(false)

  const validForSubmission = () => {
    const errors = {}
    const requiredFields = ["name", "url", "imgUrl", "description", "categoryId"]
    requiredFields.forEach(field => {
      if (formPayload[field].trim() === "") {
        errors[field] = "is blank"
      }
    })
    setErrors(errors)
    return _.isEmpty(errors)
  }

  const addSite = async () => {
    try {
      const response = await fetch(`/api/v1/sites`, {
        method: 'POST',
        headers: new Headers({
          'Content-Type': 'application/json'
        }),
        body: JSON.stringify(formPayload)
      })
      if (!response.ok) {
        if (response.status === 422) {
          const body = await response.json()
          return setErrors(body.errors)
        } else {
          const errorMessage = `${response.status} (${response.statusText})`
          const error = new Error(errorMessage)
          throw (error)
        }
      }
      const body = await response.json()
      setSiteId(body.site.id)
      setShouldRedirect(true)
    } catch (err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  const handleSubmit = (event) => {
    event.preventDefault()
    if (validForSubmission()) {
      addSite()
    }
  }

  const handleInputChange = event => {
    setFormPayLoad({
      ...formPayload,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  if (shouldRedirect) {
    return <Redirect push to={`/sites/${siteId}`} />
  }

  return (
    <form onSubmit={handleSubmit}>
      <ErrorList errors={errors} />

      <div className="formDiv">
        <label className="formLabel" htmlFor="name">Name: </label>
        <input
        className="formField"
          name="name"
          id="name"
          type="text"
          value={formPayload.name}
          onChange={handleInputChange}
        />
      </div>

      <div className="formDiv">
        <label className="formLabel" htmlFor="url">URL: </label>
        <input
        className="formField"
          name="url"
          id="url"
          type="text"
          value={formPayload.url}
          onChange={handleInputChange}
        />
      </div>

      <div className="formDiv">
        <label className="formLabel" htmlFor="imgUrl">Image URL: </label>
        <input
          className="formField"
          name="imgUrl"
          id="imgUrl"
          type="text"
          value={formPayload.imgUrl}
          onChange={handleInputChange}
        />
      </div>

      <div className="formDiv">
        <label className="formLabel" htmlFor="description">Description: </label>
        <input
          className="formField"
          name="description"
          id="description"
          type="text"
          value={formPayload.description}
          onChange={handleInputChange}
        />
      </div>

      <div className="formDiv">
        <CategoryField handleInputChange={handleInputChange}
          categoryId={formPayload.categoryId} />
      </div>

      <div className="formDiv">
        <input className="button" type="submit" value="Add New Site" />
      </div>

    </form>
  )
}

export default AddNewSiteForm