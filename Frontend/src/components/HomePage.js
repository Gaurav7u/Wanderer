import React from 'react'
import Footer from './Footer/Footer';
import HeaderText from './HeaderText/HeaderText';
import Navbar from './NavBar2/Navbar';
import ImageSlider from './Slider/ImageSlider';
import { SliderData } from './Slider/SliderData';
import Card from './StaticCards/StaticCard';
import HomepagePackage from './StaticPackages/StaticPackage';


function HomePage() {
    return (
        <div>
            <Navbar />
            <HeaderText />
            <ImageSlider slides={SliderData} />
            <Card />
            <HomepagePackage />
            <Footer />
        </div>
    )
}

export default HomePage