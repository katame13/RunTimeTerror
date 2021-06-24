import React, {useEffect, useState}from "react";

const SiteShow = (props) => {
  const [site, setSite] = useState({});
  const siteId = props.match.params.id;

  const fetchSite = async() =>{
    try {
     const response = await fetch(`/api/v1/sites/${id}`)
     if(!response.ok) {
      const errorMessage = `${response.status} (${response.statusText})`
      const error = new Error(errorMessage)
      throw(error)
    }
    const siteData = await response.json()
    setSite(siteData.site)

    } catch (error) {
      console.error(`Error in fetch: ${error.message}`)
      setSite(null)
    }
  }

  useEffect(() =>{
    fetchSite()
  }, [])

  if(!site){
    return(
      <div>
        <h1>Sorry this App/Dating Site can not be found</h1>
        <img src={"https://error404.fun/img/full-preview/1x/9.png"} height="100%" alt="Page Not Found" />
      </div>
    ) 
  }

  const { id, name, description, imgUrl, url, category} = site

  return(
    <div>
      <a href={url}> <h3>{name}</h3> </a>
      <p>{imgUrl}</p>
      <p>Category: {category} Description: {description}</p>
    </div>
  )
}

export default SiteShow;