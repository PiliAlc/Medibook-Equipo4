const URL_BASE = "http://localhost:3306"
// import createStore from '@/store'
// let jwt = ""

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

	const url = URL_BASE+"/rooms/"+id

	const settings = {
		method: "DELETE",
		headers: {
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
	const settings = {
		method: "DELETE",
		headers: {
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
	deleteTypeRoom: deleteTypeRoom
}

export default deleteMethods