<template>
  <div :class="[theme, 'contenedor']">
    <div class="login-container">
      <h2>AGREGAR SALA</h2>
      <form ref="loginForm" @submit.prevent="submitForm">
        <label for="nombre">NOMBRE*</label>
        <input ref="nombre" type="text" id="nombre" :value="nombre" />

        <label for="tipo">TIPO DE SALA*</label>
        <select ref="tipo" id="tipo" :value="selectedTipo">
          <option value="general">General</option>
          <option value="odontologia">Odontologia</option>
          <option value="oftalmologia">Oftalmologia</option>
          <option value="quirofano">Quirofano</option>
        </select>

        <label for="description">DESCRIPCIÓN*</label>
        <textarea ref="description" id="description" :value="description" maxlength="100" rows="4" cols="50"></textarea>

        <label for="images">IMÁGENES*</label>
        <input ref="images" type="file" accept="image/png, image/jpeg" id="images" multiple @change="handleImageChange" />

        <button type="submit">AGREGAR SALA</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AgregarProducto',
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    }
  },
  data() {
    return {
      imageFiles: [],
      urls: []
    };
  },
  methods: {
    cargarLoader(){
      const cargando = {
        isCargando: !this.$store.state.loader.cargando,
        texto: this.$store.state.loader.textoCargando == '' ? 'Agregando sala...' : ''
      };
      this.$store.dispatch('setCargando', cargando)
    },
    cargarPopUp(texto, titulo){
      const cargando = {
        isCargando: !this.$store.state.popup.cargando,
        texto: this.$store.state.popup.textoPopup == '' ? texto : '',
        titulo: this.$store.state.popup.tituloPopup == '' ? titulo : ''
      };
      this.$store.dispatch('setPopup', cargando)
    },
    handleImageChange(event) {
      const selectedFiles = Array.from(event.target.files).slice(0, 5);
      this.imageFiles = selectedFiles;
    },
    submitForm() {
      if (this.imageFiles.length < 1) {
        this.cargarPopUp("Seleccione al menos 1 imagen", "Faltan datos..")
        return
      }
      this.imageFiles.forEach(img=>{
        const {name} = img
        const urlBase = `https://github.com/VICT0R89/ProyectoImgs/blob/main/${this.$refs.tipo.value}/${name}?raw=true`
        this.urls.push(urlBase)
      })
      const newData = {
        id: this.$store.state.data.length+4,
        name: this.$refs.nombre.value,
        description: this.$refs.tipo.value,
        url: this.urls
      }
      if (newData.name.length < 1) {
        this.cargarPopUp("Ingrese el nombre", "Faltan datos..")
        return
      }
      if (newData.description.length < 1) {
        this.cargarPopUp("Ingrese el tipo de sala", "Faltan datos..")
        return
      }
      if (this.$refs.description.value.length < 1) {
        this.cargarPopUp("Ingrese la descripción", "Faltan datos..")
        return
      }
      const data = this.$store.state.data
      data.push(newData)
      this.$store.dispatch('setData', data)
      this.$refs.loginForm.reset()
      this.cargarLoader()
      setTimeout(() => {
        this.cargarLoader()
        this.cargarPopUp("Sala agregada con éxito", "Gracias!")
      }, 1000);
    },
  }
}
</script>

<style scoped>
.contenedor {
  background-color: #15b4bc;
  color: var(--text);
  display: flex;
  align-items: center;
  justify-content: center;
}
.contenedor:hover{
  background-color: #15b4bc;
}

.login-container {
  padding: 20px;
  border: 1px solid var(--border);
  border-radius: 8px;
  background-color: var(--oscuro);
}

form {
  display: flex;
  flex-direction: column;
  padding: 10px;
}

label {
  margin-bottom: 8px;
}

select{
  padding: 10px;
}

input {
  padding: 8px;
  margin-bottom: 16px;
}

button {
  background-color: #15b4bc;
  color: var(--text);
  padding: 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: .5s ease-in-out;
}
button:hover{
  background-color: #0f8389;
  transition: .5s ease-in-out;
}
</style>
