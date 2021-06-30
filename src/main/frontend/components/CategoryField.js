import React, { useEffect, useState } from 'react'

const CategoryField = props =>{
  const[category, setCategory] = useState([])

  const fetchCategory = async () =>{
    try{
      const response = await fetch("/api/v1/categories")
      if(!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw(error)
      }
      const categoryData = await response.json()
      setCategory(categoryData.categories)
    }catch(err){
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  useEffect(() =>{
    fetchCategory()
  }, [])

  const categoryOptions = category.map(type =>{
    return (
      <option key={type.id} value={type.id}>
        {type.name}
      </option>
    )
  })

  return(
    <div>
      <label htmlFor="categoryId">Category:</label>
      <select name ="categoryId" id = "categoryId" onChange={props.handleInputChange}
      value = {props.categoryId}>
        <option value=''></option>
        {categoryOptions}
      </select>
    </div>
  )
}

export default CategoryField