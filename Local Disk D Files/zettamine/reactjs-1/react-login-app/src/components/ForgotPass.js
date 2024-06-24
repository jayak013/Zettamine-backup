import React, { useState, useEffect } from 'react';
import { Card, Form, Button } from 'react-bootstrap';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import ViewCardL from './ViewCardL';
import fp from '../assets/images/fp.gif'

const ForgotPass = () => {
    const [email, setEmail] = useState('');
    const [otp, setOtp] = useState();
    const [newPassword, setNewPassword] = useState('');
    const [step, setStep] = useState(1); // Step 1: Email Entry, Step 2: OTP Entry, Step 3: Password Reset
    const [sendOtp, setSendOtp] = useState(false)
    const navigate = useNavigate()

    const validateEmail = (email) => {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    };

    const handleEmailBlur = async (e) => {
        const enteredEmail = e.target.value.trim();
        if (!enteredEmail) {
            document.getElementById('error').innerText = 'Please enter your email';
            return;
        }
        const isValid = validateEmail(enteredEmail);
        if (!isValid) {
            console.log('Invalid email format');
            document.getElementById('error').innerText = 'Invalid email format';
            setSendOtp(false)
        } else {
            await axios.get('http://localhost:8080/api/user/valid-email', {
                params: {
                    email: enteredEmail
                }
            })
                .then(response => {
                    if (response) {
                        setSendOtp(true)
                        document.getElementById('error').innerText = '';
                    }
                })
                .catch(error => {
                    setSendOtp(false)
                    document.getElementById('error').innerText = 'Email is not available in Database';
                });
        }
    };

    const handleSendOtp = async () => {
        const response = await axios.put(`http://localhost:8080/api/user/send-otp/${email}`)
        if(response.data){
            setStep(2); 
        } 
        
    };

    const handleSubmitOtp = async () => {
        const response = await axios.get('http://localhost:8080/api/user/valid-email', {
            params: {
                email: email
            }
        })
        if(response.data.otp == otp){
            document.getElementById('errorOne').innerText = '';
            setStep(3);
        }else{
            document.getElementById('errorOne').innerText = 'OTP Mismatch';
        }
        
    };


    const handleResetPassword = async () => {
        const response = await axios.put('http://localhost:8080/api/user/change-password', {
                email: email,
                password : newPassword
        })
        if(response.data){
            document.getElementById('errorTwo').innerText = 'Password Successfully Changed';
            setTimeout(() => {
                navigate('/login'); 
            }, 3000);
        }
    };

    return (
        <div className='d-flex justify-content-between'>
            <ViewCardL />
            <div className='w-50 bg-white vh-100'>
            <h3 className='mt-2 text-center '>Forgot Password</h3>
            <Card className='w-75 mx-auto mt-3 mb-3'>
            <Card.Body>
                {step === 1 && (
                    <Form>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control type="email" placeholder="Enter email" value={email} onChange={(e) => setEmail(e.target.value)}
                            onBlur={handleEmailBlur} />
                        </Form.Group>
                        {sendOtp && <Button variant="primary" type="button" onClick={handleSendOtp} className='my-2'>
                            Send OTP
                        </Button>}<span id='error' className='text-danger fs-5'></span>
                    </Form>
                )}
                {step === 2 && (
                    <Form>
                        <Form.Group controlId="formBasicOtp">
                            <Form.Label>Enter OTP</Form.Label>
                            <Form.Control type="text" placeholder="Enter OTP" value={otp} onChange={(e) => setOtp(e.target.value)} />
                        </Form.Group>
                        <Button variant="primary" type="button" onClick={handleSubmitOtp} className='my-2'>
                            Submit OTP
                        </Button><span id='errorOne' className='text-danger fs-5'></span>
                    </Form>
                )}
                {step === 3 && (
                    <Form>
                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>New Password</Form.Label>
                            <Form.Control type="password" placeholder="Enter new password" value={newPassword} onChange={(e) => setNewPassword(e.target.value)} />
                        </Form.Group>
                        <Button variant="primary" type="button" onClick={handleResetPassword} className='my-2'>
                            Reset Password
                        </Button><span id='errorTwo' className='text-danger fs-5'></span>
                    </Form>
                )}
            </Card.Body>
        </Card>
        <div className='text-center h-50 w-100'>
            <img src={fp} className='text-center h-100 w-75 rounded-5' / >
        </div>
        </div>
        
        </div>
    );
};

export default ForgotPass;
