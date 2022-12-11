import './App.css';
import { useState, useEffect } from 'react';
import { RentView } from './components/RentView';
import { AdminView } from './components/AdminView';

const App = () => {
	const [message, setMessage] = useState("If spring backend is running and database is running, then this message should be replaced!")

	const getHelloWorld = async () => {
		const response = await fetch('/helloworld');
		const helloWorldResponse = await response.json();
		setMessage(helloWorldResponse.message)
	}

	useEffect(() => {
		getHelloWorld()
	}, [])

	return (
		<div className="App">
			{/* <RentView /> */}
			<AdminView />
		</div>
	)
}

export default App;