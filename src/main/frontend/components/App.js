import React, { useEffect } from "react";
import { hot } from "react-hot-loader/root";
import "foundation-sites";
import $ from "jquery";
import { Route, BrowserRouter } from "react-router-dom"

import SitesIndex from "./SitesIndex";

const App = (props) => {
  useEffect(() => {
    $(document).foundation();
  }, []);

  return (
      <BrowserRouter>
          <Route exact path="/sites" component={SitesIndex} />
      </BrowserRouter>

  );
};

export default hot(App);
