<template>
  <div :class="[theme, 'contenedor']">
    <div class="login-container">
      <h2>MODIFICAR SALA</h2>
      <form ref="modifyForm" @submit.prevent="submitForm">
        
        <label for="nombre">NOMBRE*</label>
        <input ref="nombre" type="text" id="nombre" v-model="localCard.name" />

        <label for="category">CATEGORÍA*</label>
        <select ref="category" name="category" id="category" v-model="localCard.category">
          <option v-for="category in options" :key="category.id" :value=category.name>{{category.name}}</option>
        </select>

        <label for="description">DESCRIPCIÓN SALA*</label>
        <textarea ref="description" id="description" v-model="localCard.description" maxlength="100" rows="4" cols="50"></textarea>

        <!-- <label for="images">IMÁGENES*</label>
        <input ref="images" type="file" accept="image/png, image/jpeg" id="images" multiple @change="handleImageChange" /> -->

        <button type="submit">MODIFICAR SALA</button>
      </form>
    </div>
  </div>
</template>

<script>
import putMethod from '@/service/putMethod'
import getMethod from '@/service/getMethod';
import util from '@/utils/utils';

export default {
  name: 'CardModify',
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    }
  },
  props: {
    card: {
      type: Object,
      default: () => ({})
    }
  },
  data() {
    return {
      imageFiles: [],
      urls: [],
      options: [],
      localCard: {
        name: '',
        category: '',
        description: ''
      }
    };
  },
  methods: {
    handleImageChange(event) {
      const selectedFiles = Array.from(event.target.files).slice(0, 5);
      this.imageFiles = selectedFiles;
    },
    async submitForm() {
      console.log(this.card);
      if (this.imageFiles.length != 5) {
        util.cargarPopUp("Seleccione 5 imagenes", "Faltan datos..")
        return
      }
      if (this.localCard.name.length < 1) {
        util.cargarPopUp("Ingrese el nombre", "Faltan datos..")
        return
      }
      if (this.localCard.description.length < 1) {
        util.cargarPopUp("Ingrese el descripción de la sala", "Faltan datos..")
        return
      }
      if (!this.localCard.category) {
        util.cargarPopUp("Ingrese la categoría de la sala", "Faltan datos..")
        return
      }
      /* this.imageFiles.forEach(img=>{
        const {name} = img
        const urlBase = `https://github.com/VICT0R89/ProyectoImgs/blob/main/${this.$refs.tipo.value}/${name}?raw=true`
        this.urls.push(urlBase)
      }) */

      // INICIO DE AGREGAR SALA -------------------------

      util.cargarLoader("Agregando sala...")
      
      let id;
      this.options.forEach(opt=>{
        if(opt.name == this.localCard.category){
          id = opt.id
          return
        }
      })
      const datos= {
        description: this.localCard.description,
        favourite: false,
        name:this.localCard.name,
        typeroom:{
          id: id
        }
      }
      if (id) {
        await putMethod.updateRoom(datos)
        util.cargarLoader("")
        this.$refs.modifyForm.reset()
        util.cargarPopUp("Sala agregada con éxito", "Gracias!")
      } else {
        util.cargarLoader("")
        this.$refs.modifyForm.reset()
        util.cargarPopUp("Ha ocurrido un error en el servido", "Lo sentimos!")
      }

    },
    async init(){
      this.options = await getMethod.getTypeRooms()
      this.localCard = { ...this.card };
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
