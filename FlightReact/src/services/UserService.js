import axios from 'axios';

const GET_URL = "http://localhost:8080/api/get_user/";
const GET_FLIGHT_URL = "http://localhost:8080/admin/get_Flight/";
const REGISTER_URL = "http://localhost:8080/api/register/";
const PUT_URL = 'http://localhost:8080/api/update_user/';
const PUT_FLIGHT_URL = 'http://localhost:8080/admin/update_flight/';
const GET_FLIGHTS_URL = 'http://localhost:8080/admin/get_Flights/';
const POST_BOOKING_URL = 'http://localhost:8080/booking/book/';

class UserService{
    
    // Get : http://localhost:8080/api/get_user/
    getUsers(){
        return axios.get(GET_URL);
    }

    
    getUserById(userId){
        return axios.get(GET_URL + userId);
    }

    getFlightById(flightId){
        return axios.get(GET_FLIGHT_URL + flightId);
    }


    // Put : http://localhost:8080/api/update_user/?id=
    updateUser(user,userId){
        return axios.put(PUT_URL +'?id='+ userId, user);
    }
    // Post : http://localhost:8080/api/login/?userValue=userName
    // loginUser(userName){
    //     return axios.put(LOGIN_URL, + '?userValue=',userName)
    // }

    updateFlight(flight,flightId){
        return axios.put(PUT_FLIGHT_URL +'?id='+ flightId, flight);
    }

    getFlight(){
        return axios.get(GET_FLIGHTS_URL)
    }
    
    createUsers(user){
        return axios.post(REGISTER_URL,user);
    }



    // Post :  http://localhost:8080/api/register/
    createBooking(booking){
        return axios.post(POST_BOOKING_URL, booking)
    }


}

export default new UserService()