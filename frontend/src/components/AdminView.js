
import React, { useState, useEffect } from 'react'
import { NavBar } from './NavBar'

export const AdminView = () => {


    const [rentedCars, setRentedCars] = useState([])

    const getAllRentedCars = async () => {
        const res = await fetch('/admin');
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
                    rentedCars.length > 0 && rentedCars.map(c => (
                        <li key={c.id} >{
                            c.renterName
                        }</li>
                    ))
                }
            </ul>
        </div>
    )
}
