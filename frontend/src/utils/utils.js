import createStore from '@/store'

const regExp = {
  regTexto : /^[a-zA-ZÀ-ÿ\s]{3,20}$/,
  regEmail : /^[a-zA-Z0-9_.+-]+@[a-zA-Z]+\.[a-zA-Z]{2,13}$/,
  regContrasenia: /^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+])[a-zA-Z\d!@#$%^&*()_+]{8,12}$/
};
const { regTexto, regEmail, regContrasenia } = regExp;

const cargarPopUp = (texto, titulo) =>{
    const cargando = {
      isCargando: !createStore.state.popup.cargando,
      texto: createStore.state.popup.textoPopup == '' ? texto : '',
      titulo: createStore.state.popup.tituloPopup == '' ? titulo : ''
    };
    createStore.dispatch('setPopup', cargando)
  }


  const cargarLoader = texto =>{
    let cargando = {}
      texto == "" ?
      cargando={ isCargando: false, texto: createStore.state.loader.textoCargando == '' } :
      cargando={ isCargando: !createStore.state.loader.cargando, texto: createStore.state.loader.textoCargando == '' ? texto : '' }
    createStore.dispatch('setCargando', cargando)
  }

  const validarDatos = (dato,tipo) => {
    let result = {
      isValid:false,
      texto: ""
    }
    switch (tipo) {
      case "nombre":
        result = {
          isValid:regTexto.test(dato),
          texto:"El nombre no cumple el formato"
        }
        break;
      case "apellido":
        result = {
          isValid:regTexto.test(dato),
          texto:"El apellido no cumple el formato"
        }
        break;
      case "email":
        result = {
          isValid:regEmail.test(dato),
          texto:"El email no cumple el formato"
        }
        break;
      case "password":
        result = {
          isValid:regContrasenia.test(dato),
          texto:"El password no cumple el formato"
        }
        break;
    }
    return result
  }

  const util = {
    cargarPopUp: cargarPopUp,
    cargarLoader: cargarLoader,
    validarDatos: validarDatos,
  }

  export default util