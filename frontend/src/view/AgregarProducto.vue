<template>
  <div :class="[theme, 'contenedor']">
    <div class="login-container">
      <h2>AGREGAR SALA</h2>
      <form ref="loginForm" @submit.prevent="submitForm">
        
        <label for="nombre">NOMBRE*</label>
        <input ref="nombre" type="text" id="nombre" :value="nombre" />

        <label for="descriptionRoom">DESCRIPCIÓN SALA*</label>
        <textarea ref="descriptionRoom" id="descriptionRoom" :value="descriptionRoom" maxlength="100" rows="4" cols="50"></textarea>

        <label for="category">CATEGORÍA*</label>
        <input ref="category" type="text" id="category" :value="category" />

        <label for="descriptionCategory">DESCRIPCIÓN CATEGORÍA*</label>
        <textarea ref="descriptionCategory" id="descriptionCategory" :value="descriptionCategory" maxlength="100" rows="4" cols="50"></textarea>

        <label for="images">IMÁGENES*</label>
        <input ref="images" type="file" accept="image/png, image/jpeg" id="images" multiple @change="handleImageChange" />

        <button type="submit">AGREGAR SALA</button>
      </form>
    </div>
  </div>
</template>

<script>
import postMethods from '@/service/postMethod';
import getMethod from '@/service/getMethod';
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
    async submitForm() {

      if (this.imageFiles.length != 5) {
        this.cargarPopUp("Seleccione 5 imagenes", "Faltan datos..")
        return
      }
      if (this.$refs.nombre.length < 1) {
        this.cargarPopUp("Ingrese el nombre", "Faltan datos..")
        return
      }
      if (this.$refs.description.length < 1) {
        this.cargarPopUp("Ingrese el descripción de la sala", "Faltan datos..")
        return
      }
      if (this.$refs.tipo.value.length < 1) {
        this.cargarPopUp("Ingrese el tipo de sala", "Faltan datos..")
        return
      }
      this.imageFiles.forEach(img=>{
        const {name} = img
        const urlBase = `https://github.com/VICT0R89/ProyectoImgs/blob/main/${this.$refs.tipo.value}/${name}?raw=true`
        this.urls.push(urlBase)
      })

      // INICIO DE AGREGAR SALA -------------------------

      this.cargarLoader()


      const category = {
        name: this.$refs.category.value,
        description: this.$refs.descriptionCategory.value
      }
      await postMethods.addTypeRoom(category)      
      const categoryResult = await getMethod.getTypeRooms()
      console.log(categoryResult);
      /* 
      const datos= {
        description: this.$refs.description.value,
        favourite: false,
        name:this.$refs.nombre.value,
        typeroom:{
          id: 1
        }
      }
      await postMethods.addRoom(datos) */
      this.cargarLoader()
      this.$refs.loginForm.reset()
      this.cargarPopUp("Sala agregada con éxito", "Gracias!")
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
  height: 100vh;
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
