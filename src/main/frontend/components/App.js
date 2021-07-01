import React, {useEffect} from "react";
import {hot} from "react-hot-loader/root";
import "foundation-sites";
import $ from "jquery";
import {Route, BrowserRouter} from "react-router-dom"
import NavBar from "./NavBar";
import "../static/styling/main.scss"

const App = (props) => {
  useEffect(() => {
    $(document).foundation();
  }, []);

  return (
      <BrowserRouter>
        <Route path="/" component={NavBar} />
      </BrowserRouter>
  );
};

export default hot(App);
