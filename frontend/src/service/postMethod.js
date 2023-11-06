const URL_BASE = "http://localhost:3306"

// METODOS - USUARIO -

// Recibe un objeto data con los valores ingresado en el formulario de registro,
/* 
	name: string,
	lastName: string,
	email: string,
	password: string
*/
// Devuelve la respuesta de la API
const addUser = async data =>{
	const url = URL_BASE+"/users"
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
	} catch (error) {
		console.log(error);
		return false
	}
}

// Recibe un objeto data con los valores ingresado en el formulario de login,
/* 
    email: string,
    password: string
*/
// Devuelve la respuesta de la API
const logIn = async data =>{
	const url = URL_BASE+"/users"
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
	} catch (error) {
		console.log(error);
		return false
	}
}

// METDODOS - DOCTORS -

// Recibe un objeto data con los valores ingresado en el formulario de login,
/* 
	name: string,
	lastname: string,
	tuition: string,
	bookings: array,
	specialties: array
*/
// Devuelve la respuesta de la API
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
	} catch (error) {
		console.log(error);
		return false
	}
}

// METDODOS - ROOM -

// Recibe un objeto data con los valores ingresado en el formulario de agregar producto,
// Devuelve la respuesta de la API
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
	} catch (error) {
		console.log(error);
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
	} catch (error) {
		console.log(error);
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