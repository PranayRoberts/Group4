import React from "react";
import FlightBooking from "./FlightBooking";
import { withRouter } from 'react-router-dom'
import { Link } from 'react-router-dom'

function ListFlightsComponent({ data }) {
  return (
    <div>
      <div >
        <table className="table table-striped table-bordered">
          <tbody>
            <tr key={data.id}>
              <td style={{width : "15%"}}> {data.arrivalLocation}</td>
              <td style={{width : "15%"}}> {data.departureLocation}</td>
              <td style={{width : "15%"}}> {data.remainingEconomySeats}</td>
              <td style={{width : "15%"}}> {data.remainingPremiumSeats}</td>
              <td style={{width : "15%"}}> {data.remainingBusinessSeats} </td>

              <td style={{width : "15%"}} >   

              <Link to={`/flight-booking/${data.id}`}>

                <button className="btn btn-info"> Book </button>
              
                </Link>
              </td> 
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default withRouter(ListFlightsComponent)