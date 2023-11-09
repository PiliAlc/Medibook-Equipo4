const URL_BASE = "http://localhost:8090"
// import createStore from '@/store'
// let jwt = ""

// METODOS - USUARIO -

const addUser = async data =>{
	const url = URL_BASE+"/signup"
	const settings = {
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data),
	}
	try {
		const response = await fetch(url, settings)
		return response
	} catch (e) {
		console.log(e);
		return false
	}
}

const logIn = async data =>{
	const url = URL_BASE+"/login"
	const settings = {
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data),
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
	} catch (e) {
		console.log(e);
		return false
	}
}

// METDODOS - DOCTORS -

const addDoctor = async data =>{
	const url = URL_BASE+"/doctors"
	const settings = {
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
	} catch (e) {
		console.log(e);
		return false
	}
}

// METDODOS - ROOM -

const addRoom = async data => {
	const url = URL_BASE+"/rooms"

	const settings = {
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
	} catch (e) {
		console.log(e);
		return false
	}
}
const addTypeRoom = async data => {
	const url = URL_BASE+"/typerooms"

	const settings = {
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
	} catch (e) {
		console.log(e);
		return false
	}
}

const postMethods = {
	addUser: addUser,
	logIn: logIn,
	addDoctor: addDoctor,
	addRoom: addRoom,
	addTypeRoom: addTypeRoom
}

export default postMethods