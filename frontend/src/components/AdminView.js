
import React, { useState, useEffect } from 'react'
import { NavBar } from './NavBar'

export const AdminView = () => {

    // Get data from backend
    // const rentedCars = [{ name: "Tom" }, { name: "Jerry" }, { name: "Huiyi" }]
    const [rentedCars, setRentedCars] = useState([])

    const getAllRentedCars = async () => {
        console.log('---------------')
        const res = await fetch('/admin');
        console.log("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-")
        console.log(res);
        const json = await res.json();
        setRentedCars(res);

    }


    useEffect(
        () => {
            getAllRentedCars()
            return () => setRentedCars([])
        }, []
    )

    console.log("------------///////////////////////------------")
    console.log(rentedCars)
    return (
        <div >
            <NavBar />
            <p>Rented Cars</p>
            <ul>
                {
                    rentedCars.length > 0 && rentedCars.map(c => (
                        <li >{
                            c.renterName
                        }</li>
                    ))
                }
            </ul>
        </div>
    )
}
