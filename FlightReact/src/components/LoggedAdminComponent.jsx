import React, { Component } from "react";
import UserService from "../services/UserService";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import { withRouter } from "react-router-dom";


class LoggedAdminComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      flights: [],
    };
  }
  componentDidMount() {
    UserService.getFlight().then((res) => {
      this.setState({ flights: res.data });
    });
  }

  editFlight(id) {
    this.props.history.push(`/update-flight/${id}`);
  }

  render() {
    return (
      <div>
        <br />

        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th>Flight Model</th>
                <th>Business Seats</th>
                <th>Economy Seats</th>
                <th>Business Seats</th>
                <th>Economy Fare</th>
                <th>Premium Fare</th>
                <th>Business Fare</th>
                <th>Update</th>
              </tr>
            </thead>

            <tbody>
              {this.state.flights.map((flight) => (
                <tr key={flight.id}>
                  <td> {flight.fleet.model}</td>
                  <td> {flight.fleet.totalBusinessSeats}</td>
                  <td> {flight.fleet.totalEconomySeats}</td>
                  <td> {flight.fleet.totalPremiumSeats}</td>
                  <td> {flight.fare.economyFare}</td>
                  <td> {flight.fare.premiumFare}</td>
                  <td> {flight.fare.businessFare}</td>
                  <td>
                    <button
                      onClick={() => {
                        this.editFlight(flight.id);
                      }}
                      className="btn btn-info"
                    >
                      Update
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      

      </div>
    );
  }
}

export default withRouter(LoggedAdminComponent);
