import React, { useState } from "react";
import { Link } from "react-router-dom";
import { withRouter } from 'react-router-dom'

function LoginAdminComponent(props) {
    const [userName, setuserName] = useState("");
    const [password, setPassword] = useState("");
    
    async function login(){
        console.log(userName, password)
        

        const n=document.getElementById("userName").value
        const p= document.getElementById("password").value
        if( n==="" || p===""){
            alert("Please enter some values")
            return false;
        } else if ( n!==userName){
            alert("Incorrect username")
        } else if ( p!== password) {
            alert("Incorrect password")
        }
        // let item = { userName , password }
        let result= await fetch(`http://localhost:8080/admin/login_admin/?userValue=${userName}`, {
            method: 'POST',
            headers: {
                "Content-type": "application/json",
                "Accept" : 'application/json'
            },
            body: password
        })
        console.log(result)

        if (result.status===200){
            props.history.push('/admin-dashboard')
        } else {
            alert("Wrong credentials")
        }
        result = await result.json()
        console.warn(JSON.stringify(result))
        // localStorage.setItem("user-info", JSON.stringify(result))
      
    }

    return (
       <div className="font">
           <h1 style={{fontWeight: 'bold' ,textAlign: 'center' ,margin: "20px"}}>Admin Login</h1>

           <div className="col-sm-6 offset-sm-3">
           <input type="text" placeholder="Admin Name" id="userName" value={userName} onChange={(event)=>setuserName(event.target.value)} className="form-control" />
           <br />
           <input type="password" placeholder="Password" id="password" value={password} onChange={(event)=> setPassword(event.target.value)} className="form-control" />
            <br />
            <button onClick={login} className="btn btn-primary">Login</button>
            <Link to="/users">
            <button className="btn btn-danger"  style={{marginLeft: "10px"}}>Cancel</button>
            </Link>
           </div>
       
       </div>
    )
}

export default withRouter(LoginAdminComponent)