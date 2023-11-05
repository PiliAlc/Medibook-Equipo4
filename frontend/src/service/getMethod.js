const URL_BASE = "http://localhost:3306"

// USER --------------
const getUsers = async () =>{
	const url = URL_BASE+"/users"
	const settings = {
		method: 'GET',
		headers: {
		//   authorization : jwt,
			'Content-Type': 'application/json'
		}
	}
	const response = await fetch(url, settings)
	const json = await response.json()
	return json
}
const getUser = async id =>{
	const url = URL_BASE+"/users/"+id
	const settings = {
		method: 'GET',
		headers: {
		//   authorization : jwt,
			'Content-Type': 'application/json'
		}
	}
	const response = await fetch(url, settings)
	const json = await response.json()
	return json
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
		//   authorization : jwt,
			'Content-Type': 'application/json'
		}
	}
	const response = await fetch(url, settings)
	const json = await response.json()
	return json
}
const getDoctors = async () =>{
	const url = URL_BASE+"/doctors"
	const settings = {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	}
	const response = await fetch(url, settings)
	const json = await response.json()
	return json
}

// ROOMS -----------------------------------
const getRooms = async () =>{
	const url = URL_BASE+"/rooms"
	const settings = {
		method: 'GET',
		headers: {
		//   authorization : jwt,
			'Content-Type': 'application/json'
		}
	}
	try {
		const response = await fetch(url, settings)
		const json = await response.json()
		return json
		
	} catch (error) {
		console.log(error);
	}
}

// get room id or name
/* 
data = {
	id: integer or string (name)
	isId: boolean (true = id, false = name)
}
*/
const getRoom = async data =>{
	const {id, isId} = data
	const url = isId ? URL_BASE+"/rooms/"+id : URL_BASE+"/rooms/name/"+id
	const settings = {
		method: 'GET',
		headers: {
			//   authorization : jwt,
			'Content-Type': 'application/json'
		}
	}
	const response = await fetch(url, settings)
	const json = await response.json()
	return json
}

const getTypeRooms = async () =>{
	const url = URL_BASE+"/typerooms"
	const settings = {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	}
	const response = await fetch(url, settings)
	const json = await response.json()
	return json
}
const getTypeRoom = async id =>{
	const url = URL_BASE+"/typerooms/"+id
	const settings = {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	}
	const response = await fetch(url, settings)
	const json = await response.json()
	return json
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