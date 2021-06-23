import React, { useEffect } from "react";
import { hot } from "react-hot-loader/root";
import "foundation-sites";
import $ from "jquery";
import { Route, BrowserRouter } from "react-router-dom"

import SitesIndex from "./SitesIndex";
import SiteShow from "./SiteShow"

const App = (props) => {
  useEffect(() => {
    $(document).foundation();
  }, []);

  return (
    <div>
      <BrowserRouter>
        <Switch>
          <Route exact path="/" component={SitesIndex} />
          <Route exact path="/:id" component={SiteShow} />
        </Switch>
      </BrowserRouter>
    </div>
  );
};

export default hot(App);
