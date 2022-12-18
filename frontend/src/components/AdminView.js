
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
        }, []
    )

    return (
        <div className="admin-container">
            <NavBar />
            {
                rentedCars.length > 0 ?
                    <>
                        <h2>Rented Cars overview</h2>
                        <table>
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Model</th>
                                    <th>From</th>
                                    <th>To</th>
                                    <th>Cost</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    rentedCars.map((r, index) => (
                                        <tr key={index}>
                                            <td>{r.renterName}</td>
                                            <td>{r.carModel}</td>
                                            <td>{r.startDate}</td>
                                            <td>{r.endDate}</td>
                                            <td>{r.cost}</td>
                                        </tr>
                                    ))
                                }
                            </tbody>
                        </table>
                        <p>Total cost <b>{rentedCars.map(r => r.cost).reduce((x, y) => (x + y))}</b> kr</p>

                    </>
                    :
                    <>
                        <p>No one has rented any cars yet</p>
                    </>
            }

        </div>
    )
}
