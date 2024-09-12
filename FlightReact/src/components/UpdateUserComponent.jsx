import React, { Component } from "react";
import UserService from "../services/UserService";
import { Link } from "react-router-dom";
import { withRouter } from "react-router-dom";

class Update extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.match.params.id,
      userName: "",
      firstName: "",
      lastName: "",
      email: "",
      password: "",
      addressLine: "",
      zipCode: "",
      city: "",
      state1: "",
      country: "",
      mobileNo: "",
    };
    this.changeHandler = this.changeHandler.bind(this);
    this.updateUser = this.updateUser.bind(this);
  }

  componentDidMount() {
    UserService.getUserById(this.state.id).then((res) => {
      let user = res.data;
      this.setState({
        userName: user.userName,
        email: user.email,
        firstName: user.firstName,
        lastName: user.lastName,
        password: user.password,

          addressLine: user.contact.addressLine,
          zipCode: user.contact.zipCode,
          city: user.contact.city,
          state1: user.contact.state,
          country: user.contact.country,
          mobileNo: user.contact.mobileNo,
      });
    });
  }

  updateUser = (e) => {
    e.preventDefault();
    let user = {
      userName: this.state.userName,
      email: this.state.email,
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      password: this.state.password,
      contact: {
        addressLine: this.state.addressLine,
        zipCode: this.state.zipCode,
        city: this.state.city,
        state: this.state.state1,
        country: this.state.country,
        mobileNo: this.state.mobileNo,
      },
    };
    console.log("user => " + JSON.stringify(user));

    UserService.updateUser(user, this.state.id).then((res) => {
      this.props.history.push("/users");
    });
  };

  changeHandler = (event) => {
    const { name, value } = event.target;
    this.setState({ [name]: value });
  };

  render() {
    return (
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset md-3 offset-md-3">
            <h3 className="text-center">
              <div className="card-body">
                <form action="">
                  
                  <div className="form-group">
                    <label htmlFor="">User Name</label>
                    <input
                      placeholder="User Name"
                      name="userName"
                      className="form-control"
                      value={this.state.userName}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label> Email Id: </label>
                    <input
                      type="email"
                      placeholder="Email Address"
                      name="email"
                      className="form-control"
                      value={this.state.email}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="">First Name</label>
                    <input
                      placeholder="First Name"
                      name="firstName"
                      className="form-control"
                      value={this.state.firstName}
                      onChange={this.changeHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Last Name: </label>
                    <input
                      placeholder="Last Name"
                      name="lastName"
                      className="form-control"
                      value={this.state.lastName}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label> Password: </label>
                    <input
                      type="password"
                      placeholder="Password"
                      name="password"
                      className="form-control"
                      value={this.state.password}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label> Address Line: </label>
                    <input
                      placeholder="Address Line"
                      name="addressLine"
                      className="form-control"
                      value={this.state.addressLine}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label> Zip Code: </label>
                    <input
                      type="number"
                      placeholder="Zip Code"
                      name="zipCode"
                      className="form-control"
                      value={this.state.zipCode}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label> City: </label>
                    <input
                      placeholder="City"
                      name="city"
                      className="form-control"
                      value={this.state.city}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label> State: </label>
                    <input
                      placeholder="State"
                      name="state1"
                      className="form-control"
                      value={this.state.state1}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label> Country: </label>
                    <input
                      placeholder="Country"
                      name="country"
                      className="form-control"
                      value={this.state.country}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label> Mobile Number: </label>
                    <input
                      type="number"
                      placeholder="Mobile Number"
                      name="mobileNo"
                      className="form-control"
                      value={this.state.mobileNo}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <br />

                  <button className="btn btn-success" onClick={this.updateUser}>
                    Update
                  </button>

                  <Link to="/users">
                    <button
                      className="btn btn-danger"
                      style={{ marginLeft: "10px" }}
                    >
                      Cancel
                    </button>
                  </Link>

                  <Link to="/login">
                    <button
                      className="btn btn-info"
                      style={{ marginLeft: "10px" }}
                    >
                      Sign in
                    </button>
                  </Link>
                </form>
              </div>
            </h3>
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(Update);
