import React from 'react'
import { NavBar } from './NavBar'

export const AdminView = () => {

    // Get data from backend
    const rentedCars = [{ name: "Tom" }, { name: "Jerry" }, { name: "Huiyi" }]

    return (
        <div >
            <NavBar />
            <p>Rented Cars</p>
            <ul>
                {
                    rentedCars.map(c => (
                        <li >{
                            c.name
                        }</li>
                    ))
                }
            </ul>
        </div>
    )
}
