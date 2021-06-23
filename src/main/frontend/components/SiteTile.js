import React from 'react'

const SiteTile = (props) => {
  const { id, name, url, imgUrl, category, description } = props.site

  return (
    <div>
      <div>
        <img src={imgUrl}></img>
      </div>
      <div>
        <h3>{name}</h3>
        <a href={url}>Visit the Site</a>
        <p>{category.name}</p>
        <p>{description}</p>
      </div>
    </div>
  )
}

export default SiteTile