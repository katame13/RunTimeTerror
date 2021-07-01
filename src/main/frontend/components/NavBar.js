import React, { useState, useEffect } from "react"
import { Switch, Route, Link, Redirect } from "react-router-dom"

import SitesIndex from "./SitesIndex";
import SiteShow from "./SiteShow";
import AddNewSiteForm from "./AddNewSiteForm"
import CategoryShow from "./CategoryShow"
import logo from "../static/images/loveReviewsLogo.png"

const NavBar = props => {
  const [categories, setCategories] = useState([])

  const fetchCategories = async() =>{
    try {
      const response = await fetch("/api/v1/categories")
      if(!response.ok){
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw(error);
      }
      const categoryData = await response.json();
      setCategories(categoryData.categories)
    } catch (error) {
      console.error(`Error in fetch: ${error.message}`)
    }
  }

  useEffect(() =>{
    fetchCategories()
  },[])

  const categoryLinks = categories.map(category =>{
    return(
      <li key={category.id} >
        <Link to={`/categories/${category.id}`}>{category.name}</Link>
      </li>
    )
  })

  categoryLinks.unshift(
    <li key={0}>
      <Link to={`/sites`} >Home</Link>
    </li>
  )

  return(
    <div>
      <div>
        <img src= {logo} ></img>
      </div>

      <div>
        <ul className="nav-link">
          {categoryLinks}
        </ul>
      </div>

      <Switch>
        <Route exact path="/" >
          <Redirect to="/sites" />
        </Route>
        <Route exact path="/sites" component={SitesIndex} />
        <Route exact path ="/sites/new" component={AddNewSiteForm} />
        <Route exact path="/sites/:id" component={SiteShow} />
        <Route exact path="/categories/:id" component={CategoryShow} />
      </Switch>
    </div>
  )

}

export default NavBar