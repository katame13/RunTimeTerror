import React, {useState, useEffect} from "react";
import {Switch, Route, Link, Redirect} from "react-router-dom";

import SitesIndex from "./SitesIndex";
import SiteShow from "./SiteShow";
import AddNewSiteForm from "./AddNewSiteForm";
import CategoryShow from "./CategoryShow";
import EditSiteForm from "./EditSiteForm";

const NavBar = props => {
  const [categories, setCategories] = useState([])

  const fetchCategories = async () => {
    try {
      const response = await fetch("/api/v1/categories")
      if (!response.ok) {
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

  useEffect(() => {
    fetchCategories()
  }, [])

  const categoryLinks = categories.map(category => {
    return (

        <Link key={category.id} to={`/categories/${category.id}`} className="category">{category.name}</Link>
    )
  })

  categoryLinks.unshift(
      <Link key={0} to={`/sites`}>Home</Link>
  )

  return (
    <div className="">
      <div className="header">
        <div>
          <Link to={`/sites`}>
            <img className="logo" src={"https://i.imgur.com/JhJL5g1.png"}></img>
          </Link>
        </div>

      </div>
      <div className="categories">
          {categoryLinks}
      </div>


      <Switch>
        <Route exact path="/">
          <Redirect to="/sites"/>
        </Route>
        <Route exact path="/sites" component={SitesIndex}/>
        <Route exact path="/sites/new" component={AddNewSiteForm}/>
        <Route exact path="/sites/:id" component={SiteShow}/>
        <Route exact path="/categories/:id" component={CategoryShow}/>
        <Route exact path="/sites/edit/:id" component={EditSiteForm}/>
      </Switch>
    </div>
  )

}

export default NavBar