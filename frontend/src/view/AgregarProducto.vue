<template>
  <div :class="[theme, 'contenedor']">
    <div class="login-container">
      <h2>AGREGAR SALA</h2>
      <form ref="loginForm" @submit.prevent="submitForm">
        
        <label for="nombre">NOMBRE*</label>
        <input ref="nombre" type="text" id="nombre" :value="nombre" />

        <label for="category">CATEGORÍA*</label>
        <select ref="category" name="category" id="category">
          <option v-for="category in options" :key="category.id" :value=category.name>{{category.name}}</option>
        </select>

        <label for="description">DESCRIPCIÓN SALA*</label>
        <textarea ref="description" id="description" :value="description" maxlength="100" rows="4" cols="50"></textarea>

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
import util from '@/utils/utils';

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
      urls: [],
      options: []
    };
  },
  methods: {
    handleImageChange(event) {
      const selectedFiles = Array.from(event.target.files).slice(0, 5)
      this.imageFiles = selectedFiles
    },
    async submitForm() {

      if (this.imageFiles.length != 5) {
        util.cargarPopUp("Seleccione 5 imagenes", "Faltan datos..")
        return
      }
      if (this.$refs.nombre.length < 4) {
        util.cargarPopUp("Ingrese el nombre", "Faltan datos..")
        return
      }
      if (this.$refs.description.length < 10) {
        util.cargarPopUp("Ingrese el descripción de la sala", "Faltan datos..")
        return
      }
      if (!this.$refs.category.value) {
        util.cargarPopUp("Ingrese la categoría de la sala", "Faltan datos..")
        return
      }

      const roomsResult = await getMethod.getRooms()
        let aux = false
        if (roomsResult) {
          roomsResult.forEach(room => {
            if (room.name == this.$refs.nombre.value) {
              aux = true
              return
            }
          });
        }
        if (aux) {
          util.cargarPopUp("Ya exite una sala con ese nombre", "Error..")
          aux=false
          return
        }

      // INICIO DE AGREGAR SALA -------------------------

      util.cargarLoader("Agregando sala...")
      
      let id;
      this.options.forEach(opt=>{
        if(opt.name == this.$refs.category.value){
          id = opt.id
          return
        }
      })
      const datos= {
        description: this.$refs.description.value,
        favourite: false,
        name:this.$refs.nombre.value,
        typeroom:{
          id: id
        }
      }

      if (id) {
        await postMethods.addRoom(datos)
        const rooms = await getMethod.getRooms()
        const idx = rooms.length -1
        const id = rooms[idx].id
        
        const formData = new FormData()
        this.imageFiles.forEach( async (img)=>{
          formData.set("path", img)
          formData.set("room_id", id)
          await postMethods.addImg(formData)
        })

        util.cargarLoader("")
        this.$refs.loginForm.reset()
        util.cargarPopUp("Sala agregada con éxito", "Gracias!")
      } else {
        util.cargarLoader("")
        this.$refs.loginForm.reset()
        util.cargarPopUp("Ha ocurrido un error en el servido", "Lo sentimos!")
      }
      
    },
    async init(){
      this.options = await getMethod.getTypeRooms()
    }
  },
  mounted(){
    this.init()
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
  margin-bottom: 130px;
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

@media only screen and (max-width:480px ){
  .contenedor {
    margin-top:-20%;
  }
  .login-container {
    height: 75%;
    width: 75%;
  margin-bottom: -100px;
}

}

</style>
