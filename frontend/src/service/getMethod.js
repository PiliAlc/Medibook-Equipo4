const URL_BASE = "http://localhost:8090"
import createStore from '@/store'
let jwt = ""

// USER --------------

const getUsers = async () =>{
	jwt = createStore.getters.getUser.jwt
	const url = URL_BASE+"/users/listUsers"
	const settings = {
		method: 'GET',
		headers: {
			'Authorization' : "Bearer " + jwt,
			'Content-Type': 'application/json'
		}
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
	} catch (e) {
		console.log(e)
		return false
	}
}
const getUser = async (id, isId) =>{
	jwt = createStore.getters.getUser.jwt
	const url = isId ? URL_BASE+"/users/"+id : URL_BASE+"/users/username/"+id
	const settings = {
		method: 'GET',
		headers: {
			'Authorization' : "Bearer " + jwt,
			'Content-Type': 'application/json'
		}
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
	} catch (e) {
		console.log(e)
		return false
	}
}

// DOCTORS ------------------------------
// get doctor id or tuition
/* 
	data = {
		id: integer or string (tuition)
		isId: boolean (true = id, false = tuition)
	}
*/
const getDoctor = async data =>{
	const {id, isId} = data
	const url = isId ? URL_BASE+"/doctors/"+id : URL_BASE+"/doctors/tuition/"+id
	const settings = {
		method: 'GET',
		headers: {
			// 'Authorization' : "Bearer " + jwt,
			'Content-Type': 'application/json'
		}
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
	} catch (error) {
		console.log(error)
		return false
	}
}
const getDoctors = async () =>{
	const url = URL_BASE+"/doctors"
	const settings = {
		method: 'GET',
		headers: {
			// 'Authorization' : "Bearer " + jwt,
			'Content-Type': 'application/json'
		}
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
	} catch (error) {
		console.log(error)
		return false
	}
}

// ROOMS -----------------------------------

const getRooms = async () =>{
	const url = URL_BASE+"/rooms/listrooms"
	const settings = {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
		
	} catch (error) {
		console.log(error)
		return false
	}
}

const getRoom = async ({id, isId}) =>{
	const url = isId ? URL_BASE+"/rooms/"+id : URL_BASE+"/rooms/listrooms/name/"+id
	const settings = {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
	} catch (error) {
		console.log(error)
		return false
	}
}

const getTypeRooms = async () =>{
	const url = URL_BASE+"/typerooms/listtyperooms"
	const settings = {
		method: 'GET',
		headers: {
			// 'Authorization' : "Bearer " + jwt,
			'Content-Type': 'application/json'
		}
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
	} catch (error) {
		console.log(error)
		return false
	} 
}
const getTypeRoom = async id =>{
	const url = URL_BASE+"/typerooms/"+id
	const settings = {
		method: 'GET',
		headers: {
			// 'Authorization' : "Bearer " + jwt,
			'Content-Type': 'application/json'
		}
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
	} catch (error) {
		console.log(error)
		return false
	}
}

const getMethod = {
	getUsers: getUsers,
	getUser: getUser,
	getDoctor: getDoctor,
	getDoctors: getDoctors,
	getRooms: getRooms,
	getRoom: getRoom,
	getTypeRooms: getTypeRooms,
	getTypeRoom: getTypeRoom,
}

export default getMethod