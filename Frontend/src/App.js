
import './App.css';
import Footer from './components/Footer/Footer';
import HeaderText from './components/HeaderText/HeaderText';
// import Destination from './components/Destinations/Destination';
import Navbar from './components/NavBar2/Navbar';
import ImageSlider from './components/Slider/ImageSlider';
import { SliderData } from './components/Slider/SliderData';
import Card from './components/StaticCards/StaticCard';
import HomepagePackage from './components/StaticPackages/StaticPackage';

function App() {
  return (
    <div>
      <Navbar/>
      <HeaderText/>
      <ImageSlider slides={SliderData}/>
      <Card/>
      <HomepagePackage/>
      <Footer/>
    </div>
  );
}

export default App;
