import React from 'react';
import Header from '../components/layouts/Header';
import LeftSideBar from '../components/layouts/LeftSideBar';

const Admin = () => {
  const user = JSON.parse(localStorage.getItem("loggedInUser"));
  console.log(user)
  return (
    <div>
      <Header />
      <div className='d-flex bg-light'>
        <LeftSideBar />
        <div className='mx-auto text-center'>
          <div><h1 className='m-4 text-center'>Welcome to Admin Dashboard</h1></div>
          <div className="card text-center">
            <div className="card-header">
              PROFILE DETAILS
            </div>
            <div className="card-body">
              <table className='table'>
                <tbody>
                  <tr>
                    <td>First Name : </td>
                    <td>{user.firstName}</td>
                  </tr>
                  <tr>
                    <td> Last Name : </td>
                    <td>{user.lastName}</td>
                  </tr>
                  <tr>
                    <td> Email : </td>
                    <td>{user.email}</td>
                  </tr>
                  <tr>
                    <td> Designation : </td>
                    <td>{user.designation}</td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div className="card-footer text-muted">
              ZettaMine Labs Private Limited
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Admin;
