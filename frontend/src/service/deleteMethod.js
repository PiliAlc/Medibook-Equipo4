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
	const json = await response.json()
	return json
}

const deleteMethods = {
	deleteDoctor: deleteDoctor,
	deleteRoom: deleteRoom,
}

export default deleteMethods