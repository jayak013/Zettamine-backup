import React from 'react'
import { Route,Routes } from 'react-router-dom'
import Admin from '../dashboards/Admin'
import Home from '../components/Home'
import Hr from '../dashboards/Hr'
import Register from '../components/Register'
import LoginCard from '../components/LoginCard'
import ForgotPass from '../components/ForgotPass'
import AllUsers from '../components/AllUsers'
import ResetPass from '../components/ResetPass'


const AllRoutes = () => {
  return (
    <>
        <Routes>
            <Route path='/' element={<Home/>} />
            <Route path='/login' element={<LoginCard/>}/>
            <Route path='/admin/register' element={<Register />}/>
            <Route path='/admin' element={<Admin/>}/>
            <Route path='/hr' element={<Hr/>}/>
            <Route path='/forgot-password' element={<ForgotPass/>}/>
            <Route path='/reset-password' element={<ResetPass/>}/>
            <Route path='/admin/users' element={<AllUsers/>}/>
        </Routes>
    </>
  )
}

export default AllRoutes
