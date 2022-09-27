
import './App.css';
import HomePage from './components/HomePage';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Signup from './components/Signup/Signup';
import Login from './components/Login/Login';
import HomepagePackage from './components/StaticPackages/StaticPackage';
import AgencyDashboard from './components/Agency/AgencyDashboard';
import CustomerDashboard from './components/Customer/CustomerDashboard';

function App() {
  return (
    <Router>
      <Routes>
        <Route exact path='/' element={<HomePage />}></Route>
        <Route exact path='/homepage' element={<HomePage />}></Route>
        <Route exact path='/signup' element={<Signup />}></Route>
        <Route exact path='/login' element={<Login />}></Route>
        <Route exact path='/packages' element={<HomepagePackage />}></Route>
        <Route exact path='/agency/dashboard' element={<AgencyDashboard />}></Route>
        <Route exact path='/customer/dashboard' element={<CustomerDashboard />}></Route>
      </Routes>
    </Router>
  );
}

export default App;
