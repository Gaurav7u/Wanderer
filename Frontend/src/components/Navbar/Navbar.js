import React, { useState } from 'react'
import { BiSearch } from 'react-icons/bi'
import { BsPersonFill } from 'react-icons/bs'
import { FaFacebook, FaInstagram, FaPinterest, FaTwitter, FaYoutube } from 'react-icons/fa'
import { HiOutlineMenuAlt4 } from 'react-icons/hi'

import './NavbarStyle.css';

function Navbar() {

    const [nav, setNav] = useState(false)
    const handleNav = () => setNav(!nav)

    return (
        <div className={nav ? 'navbar navbar-bg' : 'navbar'}>
            <div className='logo'>
                <h2>WANDERER</h2>
            </div>
            <ul className="nav-menu">
                <li>Destinations</li>
                <li>Packages</li>
                <li>About Us</li>
                <li>Signup</li>
            </ul>
            <div className="nav-icons">
                <BiSearch className='icon' style={{ marginRight: '1rem' }} />
                <BsPersonFill className='icon' />
            </div>
            <div className="hamburger" onClick={handleNav}>
                <HiOutlineMenuAlt4 className='icon' />
            </div>

            <div className={nav ? 'mobile-menu active' : 'mobile-menu'}>
                <ul className="mobile-nav">
                    <li>Destinations</li>
                    <li>Packages</li>
                    <li>About Us</li>
                    <li>Signup</li>
                </ul>
                <div className="mobile-menu-bottom">
                    <div className="menu-icons">
                        <button>Search</button>
                        <button>Login</button>
                    </div>
                    <div className="social-icons">
                        <FaFacebook className='icon' />
                        <FaInstagram className='icon' />
                        <FaTwitter className='icon' />
                        <FaPinterest className='icon' />
                        <FaYoutube className='icon' />
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Navbar