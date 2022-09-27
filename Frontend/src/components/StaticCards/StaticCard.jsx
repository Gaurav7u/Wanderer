import React from "react";
import Hotel from '../../assets/Hotel.jpg';
import Tickets from '../../assets/Tickets.jpg';
import Transportation from '../../assets/Transportation.jpg';
import Packages from '../../assets/TravelPackages.jpg';
import './Card.css'

const Card = props => {
    return (
        <div>
            <div>
                <h2>What We Offer?</h2>
            </div>
            <div className='item-container'>
                <div className="card">
                    <img src={Packages} alt="" />
                    <h4>Packages</h4>
                    <p>We offer a wide range of packages just to match your needs.</p>
                </div>
                <div className="card">
                    <img src={Hotel} alt="" />
                    <h4>Hotel Booking</h4>
                    <p>Your peace is our priority. With the package you select, we offer a wide range of hotels.</p>
                </div>
                <div className="card">
                    <img src={Transportation} alt="" />
                    <h4>Transportation</h4>
                    <p>From pickup and drop to markets and scenery, we have you covered</p>
                </div>
                <div className="card">
                    <img src={Tickets} alt="" />
                    <h4>Ticket Booking</h4>
                    <p>After all journey plays a very important part in a trip, tickets just according to your needs.</p>
                </div>
            </div>
        </div>
    );
}

export default Card;