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
    <div>
      <BrowserRouter>
        <Route exact path="/" component={SitesIndex} />
      </BrowserRouter>
    </div>
  );
};

export default hot(App);
