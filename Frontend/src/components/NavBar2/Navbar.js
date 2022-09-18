import React, { useState } from "react";
import "./NavBar.css";
import {
  FaFacebookSquare,
  FaInstagramSquare,
  FaTwitter,
} from "react-icons/fa";
import { GiHamburgerMenu } from "react-icons/gi";

// import { NavLink } from "react-router-dom";

const Navbar = () => {
  const [showMediaIcons, setShowMediaIcons] = useState(false);
  return (
    <>
      <nav className="main-nav">
        <div className="logo">
          <h2>
            WANDERER
          </h2>
        </div>

        <div
          className={
            showMediaIcons ? "menu-link mobile-menu-link" : "menu-link"
          }>
          <ul>
            <li>
              {/* <NavLink to="/">Home</NavLink> */}
              Packages
            </li>
            <li>
              {/* <NavLink to="/about">about</NavLink> */}
              Contact
            </li>
            <li>
              {/* <NavLink to="/service">services</NavLink> */}
              Signup
            </li>
            <li>
              {/* <NavLink to="/contact">contact</NavLink> */}
              Login
            </li>
          </ul>
        </div>

        {/* 3rd social media links */}
        <div className="social-media">
          <ul className="social-media-desktop">
            <li>
              <a
                href="#">
                <FaFacebookSquare className="facebook" />
              </a>
            </li>
            <li>
              <a
                href="#">
                <FaInstagramSquare className="instagram" />
              </a>
            </li>
            <li>
              <a
                href="@">
                <FaTwitter className="youtube" />
              </a>
            </li>
          </ul>

          {/* hamburget menu start  */}
          <div className="hamburger-menu">
            <a href="#" onClick={() => setShowMediaIcons(!showMediaIcons)}>
              <GiHamburgerMenu />
            </a>
          </div>
        </div>
      </nav>
    </>
  );
};

export default Navbar;