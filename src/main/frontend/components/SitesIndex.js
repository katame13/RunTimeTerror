import React, { useState } from 'react';

import SiteTile from "./SiteTile"

const SitesIndex = props =>{
  const [sites, setSites] = useState([])

  const fetchSites = async () =>{
    try{
      const response = await fetch("api/v1/sites")
      if(!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw(error)
      }

      const sitesData = await response.json()
      setSites(sitesData.sites)
    }catch(err){}
    console.error(`Error in fetch: ${err.message}`)
  }
}