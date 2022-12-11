import React from 'react'
import { Outlet, Link } from "react-router-dom";

export const NavBar = () => {
    return (
        <>
            <nav>
                <ul>
                    {/* <li>
                        <Link to="/">Home</Link>
                    </li> */}
                    <li>
                        <Link to="/rent">Rent</Link>
                    </li>
                    <li>
                        <Link to="/admin">Admin</Link>
                    </li>
                </ul>
            </nav>

            <Outlet />
        </>
    )
}
