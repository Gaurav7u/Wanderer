import React from "react";
import "./FooterStyle.css";

function Footer() {
  return (
    <div name="scrollToContact" className="main-footer">
      <div className="container">
        <div className="row">
          {/* Column1 */}
          <div className="col">
            <h4>WANDERER PRIVATE LIMITED</h4>
            <h1 className="list-unstyled">
              <li>9931496286 | 7384672023</li>
              <li>INDIA</li>
              {/* <li>123 Streeet South North</li> */}
            </h1>
          </div>
        </div>
        <hr />
        <div className="row">
          <p className="col-sm">
            &copy;{new Date().getFullYear()} WANDERER | All rights reserved |
            Terms Of Service | Privacy
          </p>
        </div>
      </div>
    </div>
  );
}

export default Footer;