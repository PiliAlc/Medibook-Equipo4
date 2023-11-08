const URL_BASE = "http://localhost:3306"
// import createStore from '@/store'
// let jwt = ""

// METDODOS - USER -

const updateUser = async data => {
	const { id, nombre, apellido, email, password } = data
	const url = URL_BASE+"/users/"+id
	const datos = {
		name: nombre,
		lastName: apellido,
		email: email,
		password: password
	}
	const config = {
		method : "PUT",
		body : JSON.stringify(datos),
		headers : {
			'Content-Type': 'application/json'
		}
	}
	const response = await fetch(url, config)
	const json = await response.json()
	return json
}

const updateDoctor = async data =>{
	const { id, name, lastname, tuition, bookings, specialties } = data
	const url = URL_BASE+"/doctors/"+id

	const datos = {
		name: name,
		lastname: lastname,
		tuition: tuition,
		bookings: bookings,
		specialties: specialties
	}
	const config = {
		method : "PUT",
		body : JSON.stringify(datos),
		headers : {
			// authorization : jwt,
			'Content-Type': 'application/json'
		}
	}
	const response = await fetch(url, config)
	const json = await response.json()
	return json
}

const updateRoom = async (data) => {
	const url = URL_BASE+"/rooms"
	const settings = {
		method: "PUT",
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
	}
}
const updateTypeRoom = async (data,id) => {
	const url = URL_BASE+"/typerooms/"+id
	const settings = {
		method: "PUT",
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
	}
}

const putMethod = {
	updateUser: updateUser,
	updateDoctor: updateDoctor,
	updateRoom: updateRoom,
	updateTypeRoom: updateTypeRoom,
}

export default putMethod