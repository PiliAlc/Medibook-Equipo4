const URL_BASE = "http://localhost:3306"

// METDODOS - DOCTORS -

const deleteDoctor = async id =>{

	const url = URL_BASE+"/doctors/"+id

	const settings = {
		method: "DELETE",
		headers: {
			'Content-Type': 'application/json'
		}
	}
	const response = await fetch(url, settings)
	const json = await response.json()
	return json

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
	const response = await fetch(url, settings)
	return response
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
	const response = await fetch(url, settings)
	return response
}

const deleteMethods = {
	deleteDoctor: deleteDoctor,
	deleteRoom: deleteRoom,
	deleteTypeRoom: deleteTypeRoom
}

export default deleteMethods