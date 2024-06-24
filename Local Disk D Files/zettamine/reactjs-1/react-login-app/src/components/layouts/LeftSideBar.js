import React from 'react';
import { NavLink,Link } from 'react-router-dom';

const LeftSideBar = () => {
  return (
    <div className='w-25 bg-light vh-100 ' style={{borderRight:'1px solid black'}}>
      <ul className='mt-5 px-2'>
        <NavLink className='d-block my-3 text-center btn btn-outline-primary rounded-5 fs-5' to="/admin/register" activeClassName="active-link">NEW EMPLOYEE</NavLink>
        <NavLink className='d-block my-3 text-center btn btn-outline-primary rounded-5 fs-5' to="/admin/users" activeClassName="active-link">EMPLOYEES</NavLink>
        {/* <NavLink className='d-block my-3 text-center btn btn-outline-primary rounded-5 fs-5' to="/path-three" activeClassName="active-link">Test three</NavLink> */}
        <NavLink className='d-block my-3 text-center btn btn-outline-primary rounded-5 fs-5' to="/admin" activeClassName="active-link" end>PROFILE</NavLink>
        <NavLink className='d-block my-3 text-center btn btn-outline-primary rounded-5 fs-5' to="/reset-password" activeClassName="active-link">RESET PASSWORD</NavLink>
        <NavLink className='d-block my-3 text-center btn btn-outline-primary rounded-5 fs-5' to="/login" activeClassName="active-link">LOG OUT</NavLink>
      </ul>
    </div>
  );
};

export default LeftSideBar;
