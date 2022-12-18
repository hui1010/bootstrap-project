import React, { useEffect, useState } from 'react'
import { NavBar } from './NavBar'

export const RentView = () => {
    const [cars, setCars] = useState([])

    const [selectedCar, setSelectedCar] = useState()
    const [showDropdown, setShowDropdown] = useState(false)
    const [startDate, setStartDate] = useState(new Date().toISOString().split("T")[0])
    const [endDate, setEndDate] = useState(new Date().toISOString().split("T")[0])
    const [name, setName] = useState("")
    const [age, setAge] = useState("")
    const [summary, setSummary] = useState("")
    const [disableSubmit, setDisableSubmit] = useState(true)


    const getAllCars = async () => {
        const res = await fetch("/rent")
        const json = await res.json()
        setCars(json)
    }

    useEffect(() => {
        getAllCars()
    }, [])


    const onSubmit = async () => {
        if (disableSubmit) {
            alert("Button is not clickable right now!")
            return
        }

        if (!name || name.trim() === "") {
            alert("Name cannot be empty!")
            return
        }

        if (!age) {
            alert("Age cannot be empty!")
            return
        }

        if (!selectedCar) {
            alert("You must select a car!")
            return
        }

        if (!startDate) {
            alert("Please select the start date!")
            return
        }

        if (!endDate) {
            alert("Please select the end date!")
            return
        }

        if (age < 18) {
            alert("You need to be at least 18 years old to rent a car!")
            return
        }

        const rentDays = (new Date(endDate) - new Date(startDate)) / (1000 * 60 * 60 * 24) + 1

        let data = {
            renterName: name,
            renterAge: age,
            carModel: selectedCar.model,
            startDate: new Date(startDate),
            endDate: new Date(endDate),
            cost: selectedCar.price * rentDays
        }

        await fetch('/rent', {
            method: "POST",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(data)
        }).then((res) => {
            if (res.ok) {
                setSummary(`Hi ${name}, the cost for you to rent ${selectedCar.model} from ${startDate} to ${endDate} is ${selectedCar.price * rentDays} kr`)
            } else {
                // This is not perfect, need backend to throw better http error code and message
                alert("This car may have been rented during the date you have selected!")
                onReset()
            }

        }).catch(e => {
            console.error(e)
        })
            .finally(() => setDisableSubmit(true))
    }

    const onReset = () => {
        setName("")
        setAge("")
        setSelectedCar()
        setStartDate(new Date().toISOString().split("T")[0])
        setEndDate(new Date().toISOString().split("T")[0])
        setDisableSubmit(true)
        setSummary()
    }

    return (
        <div className="rent-container" onClick={() => { if (showDropdown) setShowDropdown(false) }}>
            <NavBar />
            <div className="rent-main-body">
                <div className="inputs">
                    <div className="input-wrapper">
                        <p className="input-label">Please enter your name</p>
                        <input type="text" value={name} onChange={e => {
                            setDisableSubmit(false)
                            if (Number(e.nativeEvent.data)) {
                                alert("Number is not allowed in name")
                            } else {
                                setName(e.target.value)
                            }
                        }} />
                    </div>
                    <div className="input-wrapper">
                        <p className="input-label">Please enter your age</p>
                        <input type="number" value={age}
                            onChange={e => {
                                setDisableSubmit(false)
                                if (e.target.value <= 0) return
                                setAge(e.target.value)
                            }} />
                    </div>

                    <div className="input-wrapper">
                        <p className="input-label">Car Model</p>
                        <div className='car-model-selector' >
                            <div className={`select-input ${showDropdown && `select-input-focus`}`}
                                onClick={() => setShowDropdown(!showDropdown)}>
                                <>
                                    {selectedCar ? selectedCar.model : "Selecting..."}
                                </>
                                <div>
                                    &#x25BE;
                                </div>
                            </div>

                            {showDropdown && <div className="drop-down-menu">{cars.map((e) => (
                                <div key={e.id} className="drop-down-option" onClick={
                                    () => {
                                        setDisableSubmit(false)
                                        setSelectedCar(e)
                                        setShowDropdown(false)
                                    }
                                }>
                                    {e.model}
                                </div>
                            ))}
                            </div>}
                        </div>
                    </div>
                    <div className="input-wrapper">
                        <p className="input-label">Start date</p>
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
                                        setDisableSubmit(false)

                                        setStartDate(e.target.value)
                                    }
                                }
                            }}
                        />
                    </div>
                    <div className="input-wrapper">
                        <p className="input-label">End date</p>
                        <input type="date"
                            value={endDate}
                            onChange={(e) => {
                                const start = new Date(startDate).toISOString().split("T")[0]
                                if (e.target.value < start) {
                                    alert("End date must be later than start date")
                                } else {
                                    setDisableSubmit(false)

                                    setEndDate(e.target.value)
                                }
                            }}
                        />
                    </div>
                </div>

                <div className="buttons">
                    <button className='btn reset' onClick={onReset}>Reset</button>
                    <button className={`btn submit ${disableSubmit && `disabled`}`} onClick={onSubmit}>Submit</button>
                </div>

                <div className="summary">
                    {!!summary && <h2>Summary</h2>}
                    <p>{summary}</p>
                </div>
            </div>
        </div >
    )
}
