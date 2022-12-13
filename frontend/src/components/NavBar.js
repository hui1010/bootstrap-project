import React from 'react'
import { Outlet, Link } from "react-router-dom";

export const NavBar = () => {
    return (
        <>
            <ul className="nav-bar">
                <li className='nav-bar-item'>
                    <Link to="/rent">Rent</Link>
                </li>
                <li className='nav-bar-item'>
                    <Link to="/admin">Admin</Link>
                </li>
            </ul>

            <Outlet />
        </>
    )
}
