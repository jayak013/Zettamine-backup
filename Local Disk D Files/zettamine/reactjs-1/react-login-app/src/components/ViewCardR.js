import React from 'react';
import './ViewCard.css';
import logo from '../assets/images/logo.png'

const ViewCardR = () => {
  return (
    <div className='vh-100 w-50'>
      <div className=" bg-info view-card-right d-flex justify-content-center align-center p-5">
        <div className="text-center bg-primary p-5 rounded-5 animated-text">
          <h1 className="animated-text fs-3 m-3 fw-bold text-uppercase text-white">
            Zettamine Labs Private Limited
          </h1>
          <h2 className="animated-text fs-4 m-3 text-white">
            A Demo Application
          </h2>
          <p className="animated-text fs-5 m-3 text-white">
            Based On React with Spring Boot
          </p>
        </div>
      </div>
      <div className='text-center animated-text bg-secondary'>
        <img className='w-50 my-4 p-3' src={logo} />
      </div >
    </div>


  );
};

export default ViewCardR;
