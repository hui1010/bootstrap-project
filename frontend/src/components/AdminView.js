import React from 'react'

export const AdminView = () => {

    // Get data from backend
    const rentedCars = [{ name: "Tom" }, { name: "Jerry" }, { name: "Huiyi" }]

    return (
        <div >
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
