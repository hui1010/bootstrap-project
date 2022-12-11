
import React, { useState, useEffect } from 'react'
import { NavBar } from './NavBar'

export const AdminView = () => {

    // Get data from backend
    // const rentedCars = [{ name: "Tom" }, { name: "Jerry" }, { name: "Huiyi" }]
    const [rentedCars, setRentedCars] = useState([])

    const getAllRentedCars = async () => {
        const res = await fetch('/');
        console.log(res);
        const json = await res.json();
        setRentedCars(json);
    }


    useEffect(
        () => {
            getAllRentedCars()
            return () => setRentedCars([])
        }, []
    )


    return (
        <div >
            <NavBar />
            <p>Rented Cars</p>
            <ul>
                {
                    rentedCars.map(c => (
                        <li >{
                            c.renterName
                        }</li>
                    ))
                }
            </ul>
        </div>
    )
}
