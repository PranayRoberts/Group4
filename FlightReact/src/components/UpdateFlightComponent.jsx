import React, { Component } from "react";
import UserService from "../services/UserService";
import { Link } from "react-router-dom";
import { withRouter } from "react-router-dom";

class UpdateFlights extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.match.params.id,
      departureLocation:"",
      arrivalLocation:"",		
      code:"",
      model:"",
      totalBusinessSeats: "",
      totalEconomySeats: "",
      totalPremiumSeats: "",
      remainingEconomySeats: "",
      remainingPremiumSeats: "",
      remainingBusinessSeats: "",
      departureTime: "",
      arrivalTime: "",
        economyFare: "",
        premiumFare: "",
        businessFare: "",
    };
    this.changeHandler = this.changeHandler.bind(this);
    this.updateFlight = this.updateFlight.bind(this);
  }

  componentDidMount() {
    UserService.getFlightById(this.state.id).then((res) => {
      let flight = res.data;
      this.setState({
        departureLocation: flight.departureLocation,
      arrivalLocation: flight.arrivalLocation,		
      code: flight.fleet.code,
      model: flight.fleet.model,
      totalBusinessSeats: flight.fleet.totalBusinessSeats,
      totalEconomySeats: flight.fleet.totalEconomySeats,
      totalPremiumSeats: flight.fleet.totalPremiumSeats,
      remainingEconomySeats: flight.status.remainingEconomySeats,
      remainingPremiumSeats: flight.status.remainingPremiumSeats,
      remainingBusinessSeats: flight.status.remainingBusinessSeats,
      departureTime: flight.departureTime,
      arrivalTime: flight.arrivalTime,
        economyFare: flight.fare.economyFare,
        premiumFare: flight.fare.premiumFare,
        businessFare: flight.fare.businessFare,
      });
    });
  }

  updateFlight = (e) => {
    e.preventDefault();
    let flight = {
      departureLocation: this.state.departureLocation,
      arrivalLocation:this.state.arrivalLocation,
      fleet: {
        code: this.state.code,
        model: this.state.model,
        totalBusinessSeats: this.state.totalBusinessSeats,
        totalEconomySeats: this.state.totalEconomySeats,
        totalPremiumSeats: this.state.totalPremiumSeats,
    },    
    status: {
      remainingEconomySeats: this.state.remainingEconomySeats,
      remainingPremiumSeats: this.state.remainingPremiumSeats,
      remainingBusinessSeats: this.state.remainingBusinessSeats,
    },
    departureTime: this.state.departureTime,
    arrivalTime: this.state.arrivalTime,
    fare: {
      economyFare: this.state.economyFare,
      premiumFare: this.state.premiumFare,
      businessFare: this.state.businessFare,
  }
  };
    console.log("flight => " + JSON.stringify(flight));

    UserService.updateFlight(flight, this.state.id).then((res) => {
      this.props.history.push("/admin-dashboard");
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
                    <label htmlFor="">Departure Location</label>
                    <input
                      placeholder="Departure Location"
                      name="departureLocation"
                      className="form-control"
                      value={this.state.departureLocation}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="">Arrival Location</label>
                    <input
                      placeholder="Arrival Location"
                      name="arrivalLocation"
                      className="form-control"
                      value={this.state.arrivalLocation}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="">Code</label>
                    <input
                      placeholder="Code"
                      name="code"
                      className="form-control"
                      value={this.state.code}
                      onChange={this.changeHandler}
                    />
                  </div>
                  
                  <div className="form-group">
                    <label htmlFor="">Model</label>
                    <input
                      placeholder="Model"
                      name="model"
                      className="form-control"
                      value={this.state.model}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="">Total Business Seats</label>
                    <input
                      placeholder="Total Business Seats"
                      name="totalBusinessSeats"
                      className="form-control"
                      value={this.state.totalBusinessSeats}
                      onChange={this.changeHandler}
                    />
                  </div>


                  <div className="form-group">
                    <label htmlFor="">Total Economy Seats</label>
                    <input
                      placeholder="Total Economy Seats"
                      name="totalEconomySeats"
                      className="form-control"
                      value={this.state.totalEconomySeats}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="">Total Premium Seats</label>
                    <input
                      placeholder="Total Premium Seats"
                      name="totalPremiumSeats"
                      className="form-control"
                      value={this.state.totalPremiumSeats}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="">Departure Time</label>
                    <input
                      placeholder="Departure Time"
                      name="departureTime"
                      className="form-control"
                      value={this.state.departureTime}
                      onChange={this.changeHandler}
                    />
                  </div>


                  <div className="form-group">
                    <label htmlFor="">Arrival Time</label>
                    <input
                      placeholder="Arrival Time"
                      name="arrivalTime"
                      className="form-control"
                      value={this.state.arrivalTime}
                      onChange={this.changeHandler}
                    />
                  </div>


                  <div className="form-group">
                    <label htmlFor="">Economy Fare</label>
                    <input
                      placeholder="Economy Fare"
                      name="economyFare"
                      className="form-control"
                      value={this.state.economyFare}
                      onChange={this.changeHandler}
                    />
                  </div>
                  
                  <div className="form-group">
                    <label htmlFor="">Premium Fare</label>
                    <input
                      placeholder="Premium Fare"
                      name="premiumFare"
                      className="form-control"
                      value={this.state.premiumFare}
                      onChange={this.changeHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="">Business Fare</label>
                    <input
                      placeholder="Business Fare"
                      name="businessFare"
                      className="form-control"
                      value={this.state.businessFare}
                      onChange={this.changeHandler}
                    />
                  </div>
                  <br />

                  <button className="btn btn-success" onClick={this.updateFlight}>
                    Update
                  </button>

                  <Link to="/admin-dashboard">
                    <button
                      className="btn btn-danger"
                      style={{ marginLeft: "10px" }}
                    >
                      Cancel
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

export default withRouter(UpdateFlights);
