import React from 'react';
import '../App.css';
import './NavigationBar.css';
import profilePicture from '../assets/Default-Profile-Picture-Download-PNG-Image.png';
import { FaHouse } from "react-icons/fa6";
import { FaMoneyCheckAlt } from "react-icons/fa";
import { TbReportAnalytics } from "react-icons/tb";
import { IoSettingsSharp } from "react-icons/io5";
import { CgProfile } from "react-icons/cg";
import { Link } from 'react-router-dom';

const NavigationBar = () => {
  return (
    <div className="sidebar">
      <div className="sidebar-content">
        <img style={{ height:'50%', width:'50%' }} src={profilePicture} alt='Profile'/>
        <h2> <strong>Khushi Khan</strong></h2>
        <ul>
          <li><FaHouse /><Link to="/">Home</Link></li>
          <li><CgProfile /><Link to="/myprofile">My Profile</Link></li>
          <li><FaMoneyCheckAlt /><Link to="/mytransactions">My Transactions</Link></li>
          <li><TbReportAnalytics />My Investment Plan</li>
          <li><IoSettingsSharp />Settings</li>
        </ul>
      </div>
    </div>
  );
};

export default NavigationBar;