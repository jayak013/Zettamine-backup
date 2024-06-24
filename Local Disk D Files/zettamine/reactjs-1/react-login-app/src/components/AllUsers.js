import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Header from '../components/layouts/Header';
import LeftSideBar from '../components/layouts/LeftSideBar';
import { Link } from 'react-router-dom';

const AllUsers = () => {
    const [users, setUsers] = useState([]);
    const [usersAll, setUsersAll] = useState([]);
    const user = JSON.parse(localStorage.getItem("loggedInUser"))

    useEffect(() => {
        const fetchUsers = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/user/getAll');
                const usersData = response.data
                let sortedUsers = [...usersData].sort((a, b) => {
                    return a.id-b.id;
                });
                    sortedUsers = sortedUsers.filter(c =>  c.id!==user.id);
                setUsers(sortedUsers);
                setUsersAll(sortedUsers);
            } catch (error) {
                console.error('Error fetching users:', error);
            }
        };

        fetchUsers();
    }, []);

    const sortByNameAsc = () => {
        const sortedUsers = [...usersAll].sort((a, b) => {
            const nameA = a.firstName.toLowerCase();
            const nameB = b.firstName.toLowerCase();
            return nameA.localeCompare(nameB);
        });
        setUsers(sortedUsers);
    };

    const sortByNameDesc = () => {
        const sortedUsers = [...usersAll].sort((a, b) => {
            const nameA = a.firstName.toLowerCase();
            const nameB = b.firstName.toLowerCase();
            return nameB.localeCompare(nameA);
        });
        setUsers(sortedUsers);
    };

    const allUsers = () => {
        const sortedUsers = [...usersAll].sort((a, b) => {
            return a.id-b.id;
        });
        setUsers(sortedUsers);
    };

    const filterInternalEmployees = () => {
        const internalEmployees = usersAll.filter(user => user.roleId === 3);
        setUsers(internalEmployees);
    };

    const filterExternalEmployees = () => {
        const externalEmployees = usersAll.filter(user => user.roleId === 4);
        setUsers(externalEmployees);
    };

    return (
        <div>
            <Header />
            <div className='d-flex bg-light'>
                <LeftSideBar />
                <div className='mx-5 mt-2'>
                    <h2 className='text-center'>EMPLOYEES</h2>
                    <div className='d-flex justify-content-around my-3'>
                        <button className='mx-2' onClick={allUsers}>All Employees</button>
                        <button className='mx-2' onClick={sortByNameAsc}>Sort By Name Asc</button>
                        <button className='mx-2' onClick={sortByNameDesc}>Sort By Name Desc</button>
                        <button className='mx-2' onClick={filterInternalEmployees}>Internal Employees</button>
                        <button className='mx-2' onClick={filterExternalEmployees}>External Employees</button>
                    </div>

                    <table className="table table-striped">
                        <thead className="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>Designation</th>
                                <th>Options</th>
                            </tr>
                        </thead>
                        <tbody>
                            {users.map(user => (
                                <tr key={user.id}>
                                    <td>{user.id}</td>
                                    <td>{user.firstName}</td>
                                    <td>{user.lastName}</td>
                                    <td>{user.email}</td>
                                    <td>{user.designation}</td>
                                    <td>
                                        <span className='fs-5 mx-1'><Link><i className="bi bi-eye-fill"></i></Link></span>
                                        <span className='fs-5 mx-1'><Link><i className="bi bi-pencil-square"></i></Link></span>
                                        <span className='fs-5 mx-1'><Link><i className="bi bi-trash-fill"></i></Link></span>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
};

export default AllUsers;
