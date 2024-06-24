import React from 'react'
import image from '../assets/images/100.jpg'
import logo from '../assets/images/logo.png'
import { NavLink } from 'react-router-dom'
const ViewCardL = () => {
    return (
        <div className="vh-100 w-50 bg-dark">
            <div className='text-center'>
                <img className='w-25 h-25 mt-5' src={logo} />
            </div >
            <div className='text-center'>
                <NavLink to="/" className='btn text-info mt-3 mb-2 mx-1'>HOME</NavLink>
                <NavLink to="/login" className='btn text-info mt-3 mb-2 mx-1'>LOG IN</NavLink>
                <NavLink to="/forgot-password" className='btn text-info mt-3 mb-2 mx-1'>FORGOT PASSWORD</NavLink>
            </div>
            <div className='text-center'>
                <h1 className='text-danger mt-3 mb-2'>Quotation of the day</h1>
            </div>
            <div className='text-center'>
                <img className='w-75 mt-3 rounded-5' src={image} />
            </div>
        </div>
    )
}

export default ViewCardL
