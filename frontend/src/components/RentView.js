import React, { useState } from 'react'
import { NavBar } from './NavBar'

export const RentView = () => {
    const [selectedCar, setSelectedCar] = useState()
    const [showDropdown, setShowDropdown] = useState(false)
    const [startDate, setStartDate] = useState()
    const [endDate, setEndDate] = useState()
    const [name, setName] = useState()
    const [age, setAge] = useState(0)

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


    const onSubmit = async () => {
        if (!name || name.trim() === "") {
            alert("Name cannot be empty!")
            return
        }
        if (age < 18) {
            alert("You need to be at least 18 years old to rent a car!")
            return
        }
        console.log('-----------------------------------')
        console.log(selectedCar)
        console.log(JSON.stringify({
            renterName: name,
            renterAge: parseInt(age),
            carModel: selectedCar.model,
            startDate: new Date(),
            endDate: new Date()
        }))
        const res = await fetch('/', {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify({
                renterName: name,
                renterAge: age,
                carModel: selectedCar.model,
                startDate: new Date(),
                endDate: new Date()
            })
        })
        console.log(res)

        console.log("Sending data....")
    }

    const onReset = () => {
        setSelectedCar()
    }

    return (
        <div className="rent-container">
            <NavBar />
            <div>
                <p>Please enter your name</p>
                <input type="text" value={name} onChange={e => {
                    if (Number(e.target.value)) {
                        console.log(e.nativeEvent.data)
                        return
                    } else {
                        setName(e.target.value)
                    }

                }} />
            </div>
            <div>
                <p>Please enter your age</p>
                <input type="number" value={age} onChange={e => setAge(e.target.value)} />
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
