import React, { useState } from 'react'
import { NavBar } from './NavBar'

export const RentView = () => {
    const [selectedCar, setSelectedCar] = useState()
    const [showDropdown, setShowDropdown] = useState(false)
    const [startDate, setStartDate] = useState(new Date())
    const [endDate, setEndDate] = useState(new Date())
    const [name, setName] = useState("")
    const [age, setAge] = useState(0)
    const [summary, setSummary] = useState("")


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

        const rentDays = (new Date(endDate) - new Date(startDate)) / (1000 * 60 * 60 * 24) + 1

        await fetch('/', {
            method: "POST",
            body: {
                renterName: name,
                renterAge: age,
                carModel: selectedCar.model,
                startDate: new Date(startDate),
                endDate: new Date(endDate)
            }
        }).then(res => {
            setSummary(`Hi ${name}, the cost for you to rent ${selectedCar.model} from ${startDate} to ${endDate} is ${selectedCar.price * rentDays} kr`)
            console.log("sent")
        })
            .catch(e => console.log(e))

    }

    const onReset = () => {
        setName("")
        setAge(0)
        setSelectedCar()
        setStartDate(new Date())
        setEndDate(new Date())
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
                <input type="number" value={age}
                    onFocus={() => {
                        if (age === 0) setAge("")
                    }}
                    onChange={e => {
                        if (e.target.value <= 0) return
                        setAge(e.target.value)
                    }} />
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
                        <input type="date"
                            value={startDate}
                            min={new Date()}
                            onChange={(e) => {
                                {
                                    const now = new Date().toISOString().split("T")[0]
                                    if (e.target.value < now) {
                                        alert("You can not select a date earlier than today")
                                    } else if (e.target.value > endDate) {
                                        alert("Start date cannot be later than end date")
                                    }
                                    else {
                                        setStartDate(e.target.value)
                                    }
                                }
                            }} />
                    </div>
                </div>
                <div>
                    <p>End date</p>
                    <input type="date"
                        value={endDate}
                        onChange={(e) => {
                            const start = new Date(startDate).toISOString().split("T")[0]
                            if (e.target.value < start) {
                                alert("End date must be later than start date")
                            } else {
                                setEndDate(e.target.value)
                            }
                        }} />

                </div>

                <button className='btn' onClick={onReset}>Reset</button>
                <button className='btn' onClick={onSubmit}>Submit</button>
            </div>

            <div className="summary">
                <p>Summary</p>
                <p>{summary}</p>
            </div>
        </div>
    )
}
