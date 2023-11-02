import { createStore } from '@/store'

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

  const util = {
    cargarPopUp: cargarPopUp,
    cargarLoader: cargarLoader
  }

  export default util