import CreateUserComponent from './components/CreateUserComponent'
import ListUserComponent from './components/ListUserComponent';
import UpdateUserComponent from './components/UpdateUserComponent';
import UpdateFlightComponent from './components/UpdateFlightComponent';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Footer from './components/Footer';
import Header from './components/Header';
import LoginUserComponent from './components/LoginUserComponent';
import LoginAdminComponent from './components/LoginAdminComponent'
import FlightBooking from './components/FlightBooking';
import LoggedUserComponent from './components/LoggedUserComponent';
import LoggedAdminComponent from './components/LoggedAdminComponent';



function App() {
  return (
    <div>
        <Router>
              <Header />
                <div className="container">
                    <Switch> 
                          <Route path = "/" exact component = {ListUserComponent}></Route>
                          <Route path = "/users" component = {ListUserComponent}></Route>
                          <Route path = "/add-user" component = {CreateUserComponent}></Route>
                          <Route path = "/update-user/:id" component = {UpdateUserComponent}></Route>
                          <Route path = "/update-flight/:id" component = {UpdateFlightComponent}></Route>
                          <Route path = "/login" component = {LoginUserComponent}></Route>
                          <Route path ='/admin' component={LoginAdminComponent}></Route>
                          <Route path ='/user-dashboard' component={LoggedUserComponent}></Route>
                          <Route path ='/admin-dashboard' component={LoggedAdminComponent}></Route>
                          <Route path ='/flight-booking/:id' component={FlightBooking}></Route>
                    </Switch>
                </div>
              <Footer />
        </Router>
    </div> 
  );
}

export default App
