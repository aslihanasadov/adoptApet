import React from "react";
import { Route, Link, Switch, BrowserRouter } from "react-router-dom";
import PetTypesContainer from "./PetTypesContainer";
import PetShowContainer from "./PetShowContainer";
import AddAPetContainer from "./AddAPetContainer"
import ListPets from "./ListPets";
import NotFound from "./NotFound";
const NavBar = props => {
  return (
      <BrowserRouter>
        <div className="wrapper-topbar">
          <div className="title-bar" data-responsive-toggle="responsive-menu" data-hide-for="large">
            <button className="menu-icon" type="button" data-toggle="responsive-menu"></button>
            <div className="title-bar-title">Menu</div>
          </div>
          <div className="top-bar">
            <div className="row">
              <div className="small-12 columns">
                <div className="top-bar-left">
                  <Link to="/pets"><img src="images/fluffy-logo.png" alt="Fluffy Meets Cuddles Logo"/></Link>
                </div>
                <div className="top-bar-right" id="responsive-menu">
                  <ul className="dropdown menu" data-dropdown-menu>
                    <li><Link to="/pets">Home</Link></li>
                    <li><Link to="/pets/dog">Dogs</Link></li>
                    <li><Link to="/pets/cat">Cats</Link></li>
                    <li><Link to="/adoptions/new">Surrender Application</Link></li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
        <Switch>
          <Route exact path="/pets" component={ListPets} />
          <Route exact path="/pets/:type" component={PetTypesContainer} />
          <Route exact path="/pets/:animalType/:id" component={PetShowContainer}/>
          <Route exact path="/adoptions/new" component={AddAPetContainer} />
          <Route path="*" component={NotFound} />
        </Switch>
      </BrowserRouter>
  );
};
export default NavBar;