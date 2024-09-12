
import React from "react";

function Footer() {
    
    const year= new Date().getFullYear()
        return (
            <div>
                <footer>
                    <nav>
                    <div><a href="/">Copyright &copy;  {year}</a></div>
                    </nav>
                </footer>
            </div>
        )
}

export default Footer