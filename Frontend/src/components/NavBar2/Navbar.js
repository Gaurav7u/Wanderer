import React, { useState } from "react";
import "./NavBar.css";
import {
  FaFacebookSquare,
  FaInstagramSquare,
  FaTwitter,
  FaLinkedinIn,
  FaGithub
} from "react-icons/fa";
import { GiHamburgerMenu } from "react-icons/gi";

import { NavLink } from "react-router-dom";
import {Link} from "react-scroll";

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
            {/* <li>
              <NavLink to="/packages">Packages</NavLink>
            </li> */}
            <Link to="scrollToPackage" smooth={true} duration={500}><li>Packages</li></Link>
            <li>
            <Link to="scrollToContact" smooth={true} duration={500}><li>Contact</li></Link>
            </li>
            <li>
              <NavLink to="/signup">Signup</NavLink>
            </li>
            <li>
              <NavLink to="/login">Login</NavLink>
            </li>
          </ul>
        </div>

        {/* 3rd social media links */}
        <div className="social-media">
          <ul className="social-media-desktop">
            <li>
              <a
                href="https://www.linkedin.com/in/amandeep-saluja-27bb73192/">
                {/* <FaFacebookSquare className="facebook" /> */}
                <FaLinkedinIn className="Linkedin1" />
              </a>
            </li>
            <li>
              <a
                href="https://www.linkedin.com/in/gaurav-kumar-singh-86481b19a/">
                {/* <FaInstagramSquare className="instagram" /> */}
                <FaLinkedinIn className="Linkedin2" />
              </a>
            </li>
            <li>
              <a
                href="#">
                {/* <FaTwitter className="Twitter" /> */}
                <FaGithub className="Github" />
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