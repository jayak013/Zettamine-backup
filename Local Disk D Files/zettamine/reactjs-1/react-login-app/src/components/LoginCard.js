// import React, { useState } from 'react';
// import axios from 'axios';
// import logo from '../assets/images/logo.png';
// import { useNavigate } from 'react-router-dom';
// import ViewCardL from './ViewCardL';

// const LoginCard = () => {
//     const [email, setEmail] = useState('');
//     const [password, setPassword] = useState('');
//     const [isLoginEnabled, setIsLoginEnabled] = useState(false);
//     const [loginAttempts, setLoginAttempts] = useState(0);
//     const [isAccountLocked, setIsAccountLocked] = useState(false);
//     const navigate = useNavigate();

//     const validateEmail = (email) => {
//         const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
//         return emailRegex.test(email);
//     };

//     const handleEmailBlur = (e) => {
//         const enteredEmail = e.target.value.trim();
//         if (!enteredEmail) {
//             document.getElementById('error').innerText = 'Please enter your email';
//             return;
//         }
//         const isValid = validateEmail(enteredEmail);
//         if (!isValid) {
//             console.log('Invalid email format');
//             document.getElementById('error').innerText = 'Invalid email format';
//             setIsLoginEnabled(false);
//         } else {
//             axios.get('http://localhost:8080/api/user/valid-email', {
//                 params: {
//                     email: enteredEmail
//                 }
//             })
//                 .then(response => {
//                     if (response.data.accountEnabled) {
//                         document.getElementById('error').innerText = 'Account locked due to multiple failed attempts';
//                         setIsLoginEnabled(false)
//                     } else {
//                         document.getElementById('error').innerText = '';
//                         setIsLoginEnabled(true);
//                     }
//                 })
//                 .catch(error => {
//                     document.getElementById('error').innerText = 'Email is not available in Database';
//                     setIsLoginEnabled(false)
//                 });
//         }
//     };

//     const updateLoginAttempts = async () => {
//         try {
//             await axios.get('http://localhost:8080/api/user/update-login-attempts', {
//                 params: {
//                     attempts: loginAttempts + 1,
//                     email: email
//                 }
//             });
//         } catch (error) {
//             console.error('Error updating login attempts:', error);
//         }
//     };

//     const handleSubmit = async (e) => {
//         document.getElementById('error').innerText = '';
//         e.preventDefault();
//         try {
//             const response = await axios.post('http://localhost:8080/api/user/validate', {
//                 email: email,
//                 password: password
//             });
//             localStorage.setItem('loggedInUser',JSON.stringify(response.data))
//             const { loginStatus, roleId } = response.data;
//             if (loginStatus === 0) {
                
//             } else {
//                 switch (roleId) {
//                     case 1:
//                         navigate('/admin');
//                         break;
//                     case 2:
//                         navigate('/hr');
//                         break;
//                     default:
//                         navigate('/login')
//                 }
//             }
//         } catch (error) {
//             setLoginAttempts(prevAttempts => prevAttempts + 1);
//             if (loginAttempts >= 4) {
//                 setIsAccountLocked(true);
//                 document.getElementById('error').innerText = 'Account locked due to multiple failed attempts';
//                 await updateLoginAttempts();
//             } else {
//                 document.getElementById('error').innerText = 'Wrong Credentials';
//             }
//         }
//     };

//     const handlePasswordChange = (e) => {
//         const enteredPassword = e.target.value.trim();
//         setPassword(enteredPassword);
//     };

//     const handlePasswordEntered = (e) => {
//         const enteredPassword = e.target.value.trim();
//         setIsLoginEnabled(enteredPassword.length >= 8);
//     };

//     const handleChangePassword = async (e) => {
//         document.getElementById('error').innerText = '';
//         e.preventDefault();
//         const newPassword = e.target.newPassword.value;
//         try {
//             await axios.post('http://localhost:8080/api/user/change-password', {
//                 email: email,
//                 password: newPassword
//             });
//         } catch (error) {
//             console.error('Error changing password:', error);
//         }
//     };




//     return (
//         <div className='d-flex justify-content-between rounded-5'>
//             <ViewCardL />
//             <div className="vh-100 w-50 bg-info">
//                 <div className='d-flex align-items-left w-75'>
//                     <img className='mx-5 w-50 h-25 mt-5' src={logo} alt="Logo" />
//                 </div>
//                 <div>
//                     <h1 className='fs-3 mx-5 mb-5'>Empowering Your Workforce, One Click at a Time</h1>
//                 </div>
//                 <div>
//                     <form className='mx-5 form-group' onSubmit={handleSubmit}>
//                         <div className="form-group">
//                             <label htmlFor="email" className='fs-5'>Email :</label>
//                             <input
//                                 type="email"
//                                 className='form-control'
//                                 id="email"
//                                 placeholder='Your mail address '
//                                 value={email}
//                                 onChange={(e) => setEmail(e.target.value)}
//                                 onBlur={handleEmailBlur}
//                             />
//                         </div>
//                         <div className="form-group">
//                             <label htmlFor="password" className='fs-5'>Password :</label>
//                             <input
//                                 type="password"
//                                 className='form-control'
//                                 id="password"
//                                 placeholder='Your password '
//                                 value={password}
//                                 onChange={handlePasswordChange}
//                                 onBlur={handlePasswordEntered}
//                                 disabled={!isLoginEnabled || isAccountLocked}
//                             />
//                         </div>
//                         <div className='d-flex justify-content-between'>
//                             <button type="submit" className={`btn btn-primary my-3 ${isLoginEnabled ? '' : 'disabled'}`} disabled={!isLoginEnabled || isAccountLocked}>LOG IN</button>
//                             <button className="btn btn-primary my-3" onClick={()=>navigate("/forgot-password")}>FORGOT PASSWORD</button>
//                         </div>
//                     </form>
//                     <h3 id='error' className='text-danger text-center'></h3>
//                 </div>
//             </div>
//         </div>
//     );
// };

// export default LoginCard;


import React, { useState } from 'react';
import axios from 'axios';
import logo from '../assets/images/logo.png';
import { useNavigate } from 'react-router-dom';
import ViewCardL from './ViewCardL';
import { Modal, Form, Button } from 'react-bootstrap';

const LoginCard = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [newPasswordIn,setNewPasswordIn] = useState('')
    const [isLoginEnabled, setIsLoginEnabled] = useState(false);
    const [loginAttempts, setLoginAttempts] = useState(0);
    const [isAccountLocked, setIsAccountLocked] = useState(false);
    const [showChangePasswordModal, setShowChangePasswordModal] = useState(false);
    const navigate = useNavigate();

    const validateEmail = (email) => {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    };

    const handleEmailBlur = (e) => {
        const enteredEmail = e.target.value.trim();
        if (!enteredEmail) {
            document.getElementById('error').innerText = 'Please enter your email';
            return;
        }
        const isValid = validateEmail(enteredEmail);
        if (!isValid) {
            console.log('Invalid email format');
            document.getElementById('error').innerText = 'Invalid email format';
            setIsLoginEnabled(false);
        } else {
            axios.get('http://localhost:8080/api/user/valid-email', {
                params: {
                    email: enteredEmail
                }
            })
                .then(response => {
                    if (response.data.accountEnabled) {
                        document.getElementById('error').innerText = 'Account locked due to multiple failed attempts';
                        setIsLoginEnabled(false)
                    } else {
                        document.getElementById('error').innerText = '';
                        setIsLoginEnabled(true);
                    }
                })
                .catch(error => {
                    document.getElementById('error').innerText = 'Email is not available in Database';
                    setIsLoginEnabled(false)
                });
        }
    };

    const updateLoginAttempts = async () => {
        try {
            await axios.get('http://localhost:8080/api/user/update-login-attempts', {
                params: {
                    attempts: loginAttempts + 1,
                    email: email
                }
            });
        } catch (error) {
            console.error('Error updating login attempts:', error);
        }
    };

    const handleSubmit = async (e) => {
        document.getElementById('error').innerText = '';
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/user/validate', {
                email: email,
                password: password
            });
            localStorage.setItem('loggedInUser', JSON.stringify(response.data))
            const { loginStatus, roleId } = response.data;
            if (loginStatus === 0) {
                setShowChangePasswordModal(true); // Show the modal for changing password
            } else {
                switch (roleId) {
                    case 1:
                        navigate('/admin');
                        break;
                    case 2:
                        navigate('/hr');
                        break;
                    default:
                        navigate('/login')
                }
            }
        } catch (error) {
            setLoginAttempts(prevAttempts => prevAttempts + 1);
            if (loginAttempts >= 4) {
                setIsAccountLocked(true);
                document.getElementById('error').innerText = 'Account locked due to multiple failed attempts';
                await updateLoginAttempts();
            } else {
                document.getElementById('error').innerText = 'Wrong Credentials';
            }
        }
    };
    

    const handlePasswordChange = (e) => {
        const enteredPassword = e.target.value.trim();
        setPassword(enteredPassword);
    };

    const handlePasswordEntered = (e) => {
        const enteredPassword = e.target.value.trim();
        setIsLoginEnabled(enteredPassword.length >= 8);
    };

    const handleChangePassword = async (e) => {
        e.preventDefault();
    
        if (newPasswordIn !== password) {
            document.getElementById('passwordMatchError').innerText = 'Passwords do not match';
            return;
        }
    
        document.getElementById('passwordMatchError').innerText = '';
    
        try {
            await axios.put('http://localhost:8080/api/user/change-password', {
                email: email,
                password: newPasswordIn
            });
            document.getElementById('passwordMatchError').innerText = 'Passwords Updated Successfully';
            setTimeout(() => {
                setShowChangePasswordModal(false); 
            }, 3000);
        } catch (error) {
            console.error('Error changing password:', error);
        }
    };
    

    return (
        <div className='d-flex justify-content-between rounded-5'>
            <ViewCardL />
            <div className="vh-100 w-50 bg-info">
                <div className='d-flex align-items-left w-75'>
                    <img className='mx-5 w-50 h-25 mt-5' src={logo} alt="Logo" />
                </div>
                <div>
                    <h1 className='fs-3 mx-5 mb-5'>Empowering Your Workforce, One Click at a Time</h1>
                </div>
                <div>
                    <form className='mx-5 form-group' onSubmit={handleSubmit}>
                        <div className="form-group">
                            <label htmlFor="email" className='fs-5'>Email :</label>
                            <input
                                type="email"
                                className='form-control'
                                id="email"
                                placeholder='Your mail address '
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                onBlur={handleEmailBlur}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="password" className='fs-5'>Password :</label>
                            <input
                                type="password"
                                className='form-control'
                                id="password"
                                placeholder='Your password '
                                value={password}
                                onChange={handlePasswordChange}
                                onBlur={handlePasswordEntered}
                                disabled={!isLoginEnabled || isAccountLocked}
                            />
                        </div>
                        <div className='d-flex justify-content-between'>
                            <button type="submit" className={`btn btn-primary my-3 ${isLoginEnabled ? '' : 'disabled'}`} disabled={!isLoginEnabled || isAccountLocked}>LOG IN</button>
                            <button className="btn btn-primary my-3" onClick={()=>navigate("/forgot-password")}>FORGOT PASSWORD</button>
                        </div>
                    </form>
                    <h3 id='error' className='text-danger text-center'></h3>
                </div>
            </div>

            {/* Change Password Modal */}
            <Modal show={showChangePasswordModal} onHide={() => setShowChangePasswordModal(false)}>
                <Modal.Header closeButton>
                    <Modal.Title>Change Password</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={handleChangePassword}>
                        <Form.Group controlId="formBasicNewPassword">
                            <Form.Label>New Password</Form.Label>
                            <Form.Control type="password" name="newPassword" placeholder="Enter new password" onChange={(e) => setPassword(e.target.value)}  />
                        </Form.Group>
                        <Form.Group controlId="formBasicConfirmPassword">
                            <Form.Label>Confirm New Password</Form.Label>
                            <Form.Control type="password" name="confirmPassword" placeholder="Confirm new password" onChange={(e) => setNewPasswordIn(e.target.value)} />
                            <div className="text-danger" id="passwordMatchError"></div>
                        </Form.Group>
                        <Button variant="primary" type="submit" className='mt-3'>
                            Change Password
                        </Button>
                    </Form>
                </Modal.Body>
            </Modal>
        </div>
    );
};

export default LoginCard;



