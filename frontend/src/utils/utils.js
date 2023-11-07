import createStore from '@/store'

const regExp = {
  regTexto : /^[a-zA-ZÀ-ÿ\s]{3,20}$/,
  regEmail : /^[a-zA-Z0-9_.+-]+@[a-zA-Z]+\.[a-zA-Z]{2,13}$/,
  regContrasenia : /^[a-zA-Z\d!@#$%^&*()_+]{8,12}$/
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
    const cargando = {
      isCargando: !createStore.state.loader.cargando,
      texto: createStore.state.loader.textoCargando == '' ? texto : ''
    };
    createStore.dispatch('setCargando', cargando)
  }

  const validarDatos = (dato,tipo) => {
    let result = false
    switch (tipo) {
      case "texto":
        result = regTexto.test(dato);
        break;
      case "email":
        result = regEmail.test(dato);
        break;
      case "password":
        result = regContrasenia.test(dato);
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