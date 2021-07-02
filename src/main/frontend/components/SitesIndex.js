import React, {useState, useEffect} from 'react';

import SiteTile from "./SiteTile"

const SitesIndex = props => {
  const [sites, setSites] = useState([])

  const fetchSites = async () => {
    try {
      const response = await fetch("api/v1/sites")
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw (error)
      }
      const sitesData = await response.json()
      setSites(sitesData.sites)
    } catch (error) {
      console.error(`Error in fetch: ${error.message}`)
    }
  }

  useEffect(() => {
    fetchSites()
  }, [])

  const siteTiles = sites.map(site => {
    return (
      <SiteTile
        key={site.id}
        site={site}
      />
    )
  })

  return (
  <div>
      <div className="site-tile-container">
      {/* <Link to={`/sites/new`}>
        <button type="button">
        Add Site
        </button>
        </Link> */}
      {siteTiles}
      </div>
    </div>
  )
}

export default SitesIndex