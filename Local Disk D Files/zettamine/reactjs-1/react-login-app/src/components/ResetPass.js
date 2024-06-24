import React, { useState } from 'react';
import { Card, Form, Button } from 'react-bootstrap';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import LeftSideBar from './layouts/LeftSideBar';
import Header from './layouts/Header';

const ResetPass = () => {
    const [currentPassword, setCurrentPassword] = useState('');
    const [newPassword, setNewPassword] = useState('');
    const [confirmNewPassword, setConfirmNewPassword] = useState('');
    const [error, setError] = useState('');
    const user = JSON.parse(localStorage.getItem('loggedInUser'))
    const navigate = useNavigate();

    const handleResetPassword = async () => {
        if (!currentPassword || !newPassword || !confirmNewPassword) {
            setError('Please fill in all fields.');
            return;
        }

        if (newPassword !== confirmNewPassword) {
            setError('New password and confirm new password do not match.');
            return;
        }

        try {
            const response = await axios.put('http://localhost:8080/api/user/reset-password', {
                email: user.email,
                password:currentPassword,
                newPassword:newPassword
            });
            if (response.data) {
                setError('Password Reset Successfull!!!');
            }
        } catch (error) {
            setError('Error resetting password. current password does not match');
        }
    };

    return (
        <div>
            <Header />
            <div className='d-flex bg-light'>
                <LeftSideBar />
                <div className='w-75 bg-white vh-100'>
                    <h3 className='mt-2 text-center '>Reset Password</h3>
                    <Card className='w-75 mx-auto mt-3 mb-3'>
                        <Card.Body>
                            <Form>
                                <Form.Group controlId="formBasicCurrentPassword">
                                    <Form.Label>Current Password</Form.Label>
                                    <Form.Control type="password" placeholder="Enter current password" value={currentPassword} onChange={(e) => setCurrentPassword(e.target.value)} />
                                </Form.Group>
                                <Form.Group controlId="formBasicNewPassword">
                                    <Form.Label>New Password</Form.Label>
                                    <Form.Control type="password" placeholder="Enter new password" value={newPassword} onChange={(e) => setNewPassword(e.target.value)} />
                                </Form.Group>
                                <Form.Group controlId="formBasicConfirmNewPassword">
                                    <Form.Label>Confirm New Password</Form.Label>
                                    <Form.Control type="password" placeholder="Confirm new password" value={confirmNewPassword} onChange={(e) => setConfirmNewPassword(e.target.value)} />
                                </Form.Group>
                                <Button variant="primary" type="button" onClick={handleResetPassword} className='my-2'>
                                    Reset Password
                                </Button>
                                {error && <span className='text-danger fs-5'>{error}</span>}
                            </Form>
                        </Card.Body>
                    </Card>
                </div>
            </div>
        </div>
    );
};

export default ResetPass;
