import React,{useEffect, useState} from "react"
import { useLocation } from "react-router-dom"
import SiteTile from "./SiteTile"

const CategoryShow = (props) =>{
  let location = useLocation();
  const [category, setCategory] = useState( {sites: []})

  const fetchCategory = async() => {
    try {
      const categoryId = props.match.params.id
      const response = await fetch(`/api/v1/categories/${categoryId}`)
      if(!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw(err)
      }
      const categoryData = await response.json()
      setCategory(categoryData.category)
    } catch (err) {
      console.error(`Error in fetch: ${err.message}`)
      setCategory(null)
    }
  }

  useEffect(() =>{
    fetchCategory()
  },[location.pathname])



  if(!category) {
    return(
    <div className="site-tile-container-header">
      <h1>That category could not be found!</h1>
      <img src={"https://error404.fun/img/full-preview/1x/9.png"} height="100%" alt="Page Not Found" />
    </div>
    )
  }

  const siteTiles = category.sites.map(site =>{
    return(
      <SiteTile
      key = {site.id}
      site = {site}
      />
    )
  })

  return(
    <div >
      <div className="site-tile-container-header">
      <h1>{category.name}</h1>
      </div>
      <div className="site-tile-container">
      {siteTiles}
      </div>
    </div>
  )
}

export default CategoryShow