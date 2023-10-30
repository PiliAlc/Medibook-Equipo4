const URL_BASE = ""

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
			// authorization : jwt,
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

const updateRoom = async data => {
	const { id, name, description, favourite, url1, url2, url3, url4, url5, type, bookings } = data
	const url = URL_BASE+"/rooms"+id

	const datos = {
		name: name,
		description: description,
		favourite: favourite,
		url1: url1,
		url2: url2,
		url3: url3,
		url4: url4,
		url5: url5,
		type: type,
		bookings: bookings
	}
	const settings = {
		method: "PUT",
		headers: {
			// authorization : jwt,
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(datos)
	}
	const response = await fetch(url, settings)
	const json = await response.json()
	return json
}

const putMethod = {
	updateUser: updateUser,
	updateDoctor: updateDoctor,
	updateRoom: updateRoom,
}

export default putMethod