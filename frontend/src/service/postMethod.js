const URL_BASE = ""

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
    const { nombre, apellido, email, password } = data
    const datos = {
        name: nombre,
        lastName: apellido,
        email: email,
        password: password
    }
    const settings = {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos),
    }
    const response = await fetch(url, settings)
    const json = await response.json()
    return json
}

// Recibe un objeto data con los valores ingresado en el formulario de login,
/* 
    email: string,
    password: string
*/
// Devuelve la respuesta de la API
const logIn = async data =>{
    const url = URL_BASE+"/users"
    const { email, password } = data
    const datos = {
        email: email,
        password: password
    }
    const settings = {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos),
    }
    const response = await fetch(url, settings)
    const json = await response.json()
    return json
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
    const { name, lastname, tuition, bookings, specialties } = data
    const url = URL_BASE+"/doctors"

    const datos = {
        name: name,
        lastname: lastname,
        tuition: tuition,
        bookings: bookings,
        specialties: specialties
    }
    const settings = {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    }
    const response = await fetch(url, settings)
    const json = await response.json()
    return json
}

// METDODOS - ROOM -

// Recibe un objeto data con los valores ingresado en el formulario de login,
/* 
    name: string,
    description: string,
    favourite: boolean,
    url1: string,
    url2: string,
    url3: string,
    url4: string,
    url5: string,
    type: string,
    bookings: []
*/
// Devuelve la respuesta de la API
const addRoom = async data => {
    const { name, description, favourite, url1, url2, url3, url4, url5, type, bookings } = data
    const url = URL_BASE+"/rooms"

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
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    }
    const response = await fetch(url, settings)
    const json = await response.json()
    return json
}

const postMethods = {
    addUser: addUser,
    logIn: logIn,
    addDoctor: addDoctor,
    addRoom: addRoom,
}

export default postMethods