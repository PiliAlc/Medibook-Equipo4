const URL_BASE = "http://localhost:8090"
import createStore from '@/store'
let jwt = ""

// METDODOS - USERS -

const deleteUser = async id =>{
	const url = URL_BASE+"/users/"+id
	jwt = createStore.getters.getUser.jwt
	const settings = {
		method: "DELETE",
		headers: {
			'Authorization' : "Bearer " + jwt,
			'Content-Type': 'application/json'
		}
	}
	try {
		const response = await fetch(url, settings)
		return response
	} catch (error) {
		console.log(error);
		return false
	}
}

// METDODOS - DOCTORS -

const deleteDoctor = async id =>{

	const url = URL_BASE+"/doctors/"+id

	const settings = {
		method: "DELETE",
		headers: {
			'Content-Type': 'application/json'
		}
	}
	try {
		const response = await fetch(url, settings)
		return response
	} catch (error) {
		console.log(error);
		return false
	}
}

// METDODOS - ROOM -

const deleteRoom = async id => {
	jwt = createStore.getters.getUser.jwt
	const url = URL_BASE+"/rooms/"+id
	const settings = {
		method: "DELETE",
		headers: {
			'Authorization' : "Bearer " + jwt,
			'Content-Type': 'application/json'
		},
	}
	try {
		const response = await fetch(url, settings)
		return response
	} catch (error) {
		console.log(error);
		return false
	}
}

// METODO - TYPEROOM -

const deleteTypeRoom = async id =>{
	const url = URL_BASE+"/typerooms/"+id
	jwt = createStore.getters.getUser.jwt
	const settings = {
		method: "DELETE",
		headers: {
			'Authorization' : "Bearer " + jwt,
			'Content-Type': 'application/json'
		},
	}
	try {
		const response = await fetch(url, settings)
		return response
	} catch (error) {
		console.log(error);
		return false
	}
}

const deleteMethods = {
	deleteDoctor: deleteDoctor,
	deleteRoom: deleteRoom,
	deleteTypeRoom: deleteTypeRoom,
	deleteUser: deleteUser,
}

export default deleteMethods