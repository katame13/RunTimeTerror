import React from 'react'

const SiteTile = (props) => {
  const {id, name, url, imgUrl, category, description} = props.site

  return (
    <div>
      <div>
        <a href={`/sites/${id}`}>
          <img src={imgUrl}></img>
          <h3>{name}</h3>
        </a>
        <a href={url}>Visit the Site</a>
        <p>{category.name}</p>
        <p>{description}</p>
      </div>
    </div>
  )
}

export default SiteTile