import React, { useState } from "react"
import { Redirect } from "react-router"
import _ from 'lodash'

import CategoryField from "./CategoryField"
import ErrorList from "./ErrorList"

const EditSiteForm = (props) => {
  console.log(props)
  console.log("This is props")
  console.log(props.site)
  const siteId = props.match.params.id;
  const [formPayload, setFormPayLoad] = useState({
  //pass id from site show page
//    id: {props.site.id},
    name: "",
    url: "",
    imgUrl: "",
    description: "",
    categoryId: ""
  })

  const [errors, setErrors] = useState({})
//  const [siteId, setSiteId] = useState(null)
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

  const editSite = async () => {
    try {
      const response = await fetch(`/api/v1/sites/${id}/edit`, {
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
      editSite()
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
        <label htmlFor="url">URL: </label>
        <input
          name="url"
          id="url"
          type="text"
          value={formPayload.url}
          onChange={handleInputChange}
        />
      </div>

      <div>
        <label htmlFor="imgUrl">imgUrl: </label>
        <input
          name="imgUrl"
          id="imgUrl"
          type="text"
          value={formPayload.imgUrl}
          onChange={handleInputChange}
        />
      </div>

      <div>
        <label htmlFor="description">description: </label>
        <input
          name="description"
          id="description"
          type="text"
          value={formPayload.description}
          onChange={handleInputChange}
        />
      </div>

      <CategoryField handleInputChange={handleInputChange}
        categoryId={formPayload.categoryId} />
      <input type="submit" value="Edit Site" />

    </form>
  )
}

export default EditSiteForm