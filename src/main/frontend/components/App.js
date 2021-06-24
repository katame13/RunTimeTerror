import React, {useEffect} from "react";
import {hot} from "react-hot-loader/root";
import "foundation-sites";
import $ from "jquery";
import {Route, BrowserRouter, Switch, Redirect} from "react-router-dom"

import SitesIndex from "./SitesIndex";
import SiteShow from "./SiteShow";
import AddNewSiteForm from "./AddNewSiteForm";

const App = (props) => {
  useEffect(() => {
    $(document).foundation();
  }, []);

  return (
      <BrowserRouter>
        <Switch>
          <Route exact path="/" >
            <Redirect to="/sites" />
          </Route>
          <Route exact path="/sites" component={SitesIndex} />
          <Route exact path ="/sites/new" component={AddNewSiteForm}/>
          <Route exact path="/sites/:id" component={SiteShow} /> 
        </Switch>
      </BrowserRouter>
  );
};

export default hot(App);
