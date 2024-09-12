import React from "react";

function InputComponent(props){
    return (
    <div className="form-group">
        
        <label htmlFor="">{props.lbl}</label>
        
        <input placeholder={props.lbl} name={props.n} className="form-control" 
        value={props.v} onChange={() => {
            props.oc();
        }}/>
    </div>
    )
}

export default InputComponent