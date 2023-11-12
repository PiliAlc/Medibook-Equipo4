const URL_BASE = "http://localhost:8090"
import createStore from '@/store'
let jwt = createStore.getters.getUser.jwt

// METDODOS - USER -

const updateUser = async data => {
	jwt = createStore.getters.getUser.jwt
	const url = URL_BASE+"/users/editUsers"
	const config = {
		method : "PUT",
		body : JSON.stringify(data),
		headers : {
			'Authorization' : "Bearer " + jwt,
			'Content-Type': 'application/json'
		}
	}
	try {
		const response = await fetch(url, config)
		const json = await response.json()
		return json
	} catch (e) {
		console.log(e)
		return false
	}
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
			// 'Authorization' : "Bearer " + jwt,
			'Content-Type': 'application/json'
		}
	}
	const response = await fetch(url, config)
	const json = await response.json()
	return json
}

const updateRoom = async (data) => {
	const url = URL_BASE+"/rooms"
	jwt = createStore.getters.getUser.jwt
	const settings = {
		method: "PUT",
		headers: {
			'Authorization' : "Bearer " + jwt,
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