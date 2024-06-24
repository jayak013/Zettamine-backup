import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import Header from './layouts/Header';
import LeftSideBar from './layouts/LeftSideBar';

const Register = () => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        email: '',
        designation: '',
        roleId: 1
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prevData => ({
            ...prevData,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/user/save', formData);
            console.log('Registration successful:', response.data);
            document.getElementById('success').innerText = 'Employee is successfully saved';
            clearForm();
        } catch (error) {
            console.error('Error during registration:', error);
        }
    };

    const clearForm = () => {
        setFormData({
            firstName: '',
            lastName: '',
            email: '',
            designation: '',
            roleId: 1
        });
    };

    return (
        <div>
            <Header />
            <div className='d-flex'>
                <LeftSideBar />
                <div className="bg-light p-2 w-75 vh-100">
                    <div className="card w-75 mx-auto">
                        <div className="card-header">
                            Registration Form
                        </div>
                        <div className="card-body">
                            <form onSubmit={handleSubmit}>
                                <div className="mb-1">
                                    <label htmlFor="firstName" className="form-label">First Name</label>
                                    <input type="text" className="form-control" id="firstName" name="firstName" value={formData.firstName} onChange={handleChange} required />
                                </div>
                                <div className="mb-1">
                                    <label htmlFor="lastName" className="form-label">Last Name</label>
                                    <input type="text" className="form-control" id="lastName" name="lastName" value={formData.lastName} onChange={handleChange} required />
                                </div>
                                <div className="mb-1">
                                    <label htmlFor="email" className="form-label">Email</label>
                                    <input type="email" className="form-control" id="email" name="email" value={formData.email} onChange={handleChange} required />
                                </div>
                                <div className="mb-1">
                                    <label htmlFor="designation" className="form-label">Designation</label>
                                    <input type="text" className="form-control" id="designation" name="designation" value={formData.designation} onChange={handleChange} required />
                                </div>
                                <div className="mb-1">
                                    <label htmlFor="roleId" className="form-label">Role</label>
                                    <select className="form-select" id="roleId" name="roleId" value={formData.roleId} onChange={handleChange} required>
                                        <option value="1">Admin</option>
                                        <option value="2">HR</option>
                                        <option value="3">Internal Employee</option>
                                        <option value="4">External Employee</option>
                                    </select>
                                </div>
                                <button type="submit" className="btn btn-primary me-3 mt-1">REGISTER</button>
                                <button type="button" className="btn btn-secondary mt-1" onClick={clearForm}>Clear Form</button>
                                <span id="success" className='text-success fs-5 mx-2'></span>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Register;
