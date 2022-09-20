import React from "react";
import Gangtok from '../../assets/Gangtok.jpg';
import Kerela from '../../assets/Kerela.jpg';
import Kolkata from '../../assets/Kolkata.jpg';
import Manali from '../../assets/Manali.jpg';
import Mumbai from '../../assets/Mumbai.jpg';
import Ladakh from '../../assets/Ladakh.jpg';
import './StaticPackageStyle.css';

const HomepagePackage = props => {
    return (
        <div className="Package-div">
            <div>
                <h2> Our Best Selling Packages</h2>
            </div>
            <div className='item-container2'>
                <div className="card">
                    <img src={Gangtok} alt="" />
                    <h5>Gangtok Tourism</h5>
                    <h6>Starting at Rs.39999</h6>
                    <h6>6N/7D</h6>
                    <p>Gangtok is the capital of the mountainous northern Indian state of Sikkim</p>
                </div>
                <div className="card">
                    <img src={Kerela} alt="" />
                    <h5>Kerela Tourism</h5>
                    <h6>Starting at Rs.49999</h6>
                    <h6>6N/7D</h6>
                    <p>Kerela is known for its palm-lined beaches and backwaters, a network of canals</p>
                </div>
                <div className="card">
                    <img src={Kolkata} alt="" />
                    <h5>Kolkata Tourism</h5>
                    <h6>Starting at Rs.29999</h6>
                    <h6>3N/4D</h6>
                    <p>Kolkata is known for its grand colonial architecture, art galleries and cultural festivals</p>
                </div>
                <div className="card">
                    <img src={Manali} alt="" />
                    <h5>Manali Tourism</h5>
                    <h6>Starting at Rs.45999</h6>
                    <h6>5N/6D</h6>
                    <p>Set on the Beas River, it’s a gateway for skiing in the Solang Valley and trekking in Parvati Valley and much more</p>
                </div>
                <div className="card">
                    <img src={Mumbai} alt="" />
                    <h5>Mumbai Tourism</h5>
                    <h6>Starting at Rs.35999</h6>
                    <h6>5N/6D</h6>
                    <p>A financial center, it's India's largest city. On the Mumbai Harbour waterfront stands the iconic Gateway of India</p>
                </div>
                <div className="card">
                    <img src={Ladakh} alt="" />
                    <h5>Ladakh Tourism</h5>
                    <h6>Starting at Rs.75999</h6>
                    <h6>6N/7D</h6>
                    <p>Famous for breathtaking landscapes, the crystal clear skies, the highest mountain passes, thrilling adventure activities, Buddhist Monasteries and festivals</p>
                </div>
            </div>
        </div>
    );
}

export default HomepagePackage;