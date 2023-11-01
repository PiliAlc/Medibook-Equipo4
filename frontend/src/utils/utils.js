

const cargarPopUp = (texto, titulo) =>{
    const cargando = {
      isCargando: !this.$store.state.popup.cargando,
      texto: this.$store.state.popup.textoPopup == '' ? texto : '',
      titulo: this.$store.state.popup.tituloPopup == '' ? titulo : ''
    };
    this.$store.dispatch('setPopup', cargando)
  }


  const cargarLoader = texto =>{
    const cargando = {
      isCargando: !this.$store.state.loader.cargando,
      texto: this.$store.state.loader.textoCargando == '' ? texto : ''
    };
    this.$store.dispatch('setCargando', cargando)
  }

  const util = {
    cargarPopUp: cargarPopUp,
    cargarLoader: cargarLoader
  }

  export default util