import React, { useState } from 'react'

export const RentView = () => {
    const [selectedCar, setSelectedCar] = useState()
    const [showDropdown, setShowDropdown] = useState(false)
    const [startDate, setStartDate] = useState()
    const [endDate, setEndDate] = useState()
    const [name, setName] = useState()

    const tempCarpool = [{
        id: 1,
        model: "Volvo S60", price: 1500
    }, {
        id: 2,
        model: "Volkswagen Golf", price: 1333
    }, {
        id: 3,
        model: "Ford Mustang", price: 3000
    }, {
        id: 4,
        model: "Ford Transit", price: 2400
    }]

    const onSubmit = () => {
        //Send data to database
        console.log("Sending data....")
    }

    const onReset = () => {
        setSelectedCar()
    }

    return (
        <div className="rent-container">
            <div>
                <p>Please enter your name</p>
                <input type="text" value={name} onChange={e => setName(e.target.value)} />
            </div>
            <div className="options">
                <div>
                    <p>Car Modal</p>
                    <div className='car-modal-selector' >
                        <div className="selected" onClick={() => setShowDropdown(!showDropdown)}>
                            <div>

                                {selectedCar ? selectedCar.model : "Selecting..."}
                            </div>
                            <div>
                                &#x25BE;
                            </div>
                        </div>

                        {showDropdown && <div className="drop-down-menu">{tempCarpool.map((e) => (
                            <div key={e.id} className="drop-down-option" onClick={
                                () => {
                                    setSelectedCar(e)
                                    setShowDropdown(false)
                                }
                            }>

                                {e.model}

                            </div>
                        ))}
                        </div>}</div>
                </div>
                <div>
                    <p >Start date</p>
                    <div>
                        <input type="date" onSelect={(e) => console.log(e.target.value)} />
                    </div>
                </div>
                <div>
                    <p>End date</p>
                    <input type="date" onSelect={(e) => console.log(e.target.value)} />

                </div>

                <button className='btn' onClick={onReset}>Reset</button>
                <button className='btn' onClick={onSubmit}>Submit</button>
            </div>

            <div className="summary">
                <p>Summary</p>
                <p>total cost</p>
                {selectedCar && <p>
                    {selectedCar.price * 3}
                </p>}
                <p>{name}</p>
            </div>
        </div>
    )
}
