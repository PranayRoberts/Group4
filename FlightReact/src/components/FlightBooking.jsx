import React, { Component } from 'react'
import { withRouter } from 'react-router-dom'
import UserService from '../services/UserService';
import { Link } from 'react-router-dom'



class FlightBooking extends Component {
  constructor(props){
      super(props)
      this.state = {
    bookingNumber:"",
    bookingDate: "",
    travelDate: "",
    totalCost : "",
    
        firstName:"",
        lastName:"",
        age: "",
        gender: "",
        psssportNo : "",
        mealPref : ""
        };  
      this.changeHandler = this.changeHandler.bind(this);
      this.registerBooking = this.registerBooking.bind(this);
  }
  
  buttonClikc(){
    console.log('click')
  }

  registerBooking = (e) => {
      
      e.preventDefault();
      
      let booking = {
        bookingNumber:this.state.bookingNumber,
        bookingDate: this.state.bookingDate,
        travelDate: this.state.travelDate,
        totalCost : this.state.totalCost,
        passenger :{
            firstName:this.state.firstName,
            lastName:this.state.lastName,
            age: this.state.age,
            gender: this.state.gender,
            psssportNo : this.state.psssportNo,
            mealPref : this.state.mealPref
      }
    }; 

      console.log('bookings => ' + JSON.stringify(booking));

          UserService.createBooking(booking).then((res) => { 
          alert("Flight Booked Successfully")           
            this.props.history.push('/user-dashboard')
        });
  
  }

  changeHandler= (event) => {
      const {name , value} = event.target;
      this.setState({ [name] : value})
  }

  render() {
      return (
        <div className="container">
        <div className="row">
            <div className="card col-md-6 offset md-3 offset-md-3">
                <h3 className="text-center">
                    <div className="card-body">
                        <form action="" autoComplete="on">                     

                        <div className="form-group">
                                <label htmlFor="">Booking Number</label>
                                <input placeholder="Booking Number" name="bookingNumber" className="form-control" 
                                    value={this.state.bookingNumber} onChange={this.changeHandler}/>
                            </div>
                            
                            <div className = "form-group">
                                    <label> Booking Date</label>
                                    <input placeholder="Booking Date" name="bookingDate" className="form-control" 
                                        value={this.state.bookingDate} onChange={this.changeHandler}/>
                                </div>

                            <div className="form-group">
                                <label htmlFor="">Travel Date</label>
                                <input placeholder="Travel Date" name="travelDate" className="form-control" 
                                        value={this.state.travelDate} onChange={this.changeHandler} />
                            </div>
                            <div className = "form-group">
                                    <label> Total Cost </label>
                                    <input placeholder="Total Cost" name="totalCost" className="form-control" 
                                        value={this.state.totalCost} onChange={this.changeHandler}/>
                                </div>

                                <div className = "form-group">
                                    <label>First Name </label>
                                    <input placeholder="First Name" name="firstName" className="form-control" 
                                        value={this.state.firstName} onChange={this.changeHandler}/>
                                </div>

                                <div className = "form-group">
                                    <label>Last Name </label>
                                    <input placeholder="Last Name" name="lastName" className="form-control" 
                                        value={this.state.lastName} onChange={this.changeHandler}/>
                                </div>

                                <div className = "form-group">
                                    <label> Age </label>
                                    <input placeholder="Age" name="age" className="form-control" 
                                        value={this.state.age} onChange={this.changeHandler}/>
                                </div>

                                <div className = "form-group">
                                    <label> Gender </label>
                                    <input placeholder="Gender" name="gender" className="form-control" 
                                        value={this.state.gender} onChange={this.changeHandler}/>
                                </div>

                                <div className = "form-group">
                                    <label> Passport Number </label>
                                    <input placeholder="Passport Number" name="psssportNo" className="form-control" 
                                        value={this.state.psssportNo} onChange={this.changeHandler}/>
                                </div>

                                <div className = "form-group">
                                    <label> Meal Preference </label>
                                    <input placeholder="Meal Preference" name="mealPref" className="form-control" 
                                        value={this.state.mealPref} onChange={this.changeHandler}/>
                                </div>
              
                                <button className="btn btn-success" onClick={this.registerBooking}>BOOK!</button>

                                <Link to="/user-dashboard">
                                <button className="btn btn-danger"  style={{marginLeft: "10px"}}>Back to Search</button>
                                </Link>
               
                               
                        </form>
                    </div>
                </h3>
            </div>
        </div>
          </div>
      )
  }
}


export default withRouter(FlightBooking)