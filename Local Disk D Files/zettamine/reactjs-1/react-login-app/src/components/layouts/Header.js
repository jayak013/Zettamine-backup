import React from 'react'
import logo from '../../assets/images/logo.png'
import { NavLink,Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'
const Header = () => {
  const navigate = useNavigate();
  const user = JSON.parse(localStorage.getItem('loggedInUser'));
  return (
    <header className='sticky-top bg-light border-bottom d-flex justify-content-between p-2 '>
      <nav className="w-25 mx-5">
        <NavLink to="/admin"><img className="w-50" src={logo} /></NavLink>
      </nav>
      <nav className="p-2 mx-5">
        <h4 className="text-decoration-none  mx-1">{user.firstName} {user.lastName} - {user.designation}</h4>
      </nav>
      <nav className="p-2 mx-5">
        <NavLink className="text-decoration-none btn mx-1" to="/login">LOG OUT</NavLink>
      </nav>
    </header>
  )
}

export default Header

