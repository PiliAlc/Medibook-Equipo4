<template>
  <div :class="[theme, 'contenedor']">
    <div class="login-container">
      <h2>MODIFICAR SALA</h2>
      <form ref="modifyForm" @submit.prevent="submitForm">
        
        <label for="nombre">NOMBRE*</label>
        <input ref="nombre" type="text" id="nombre" v-model="localCard.name" />

        <label for="category">CATEGORÍA*</label>
        <select ref="category" name="category" id="category" v-model="localCard.category">
          <option v-for="category in options" :key="category.id" :value="category.name">{{category.name}}</option>
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
  },
  data() {
    return {
      imageFiles: [],
      urls: [],
      options: [],
      card: [],
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

      if (this.localCard.name.length < 3) {
        util.cargarPopUp("Ingrese el nombre", "Faltan datos..")
        return
      }
      if (this.localCard.description.length < 1) {
        util.cargarPopUp("Ingrese la descripción de la sala", "Faltan datos..")
        return
      }
      if (!this.localCard.category) {
        util.cargarPopUp("Ingrese la categoría de la sala", "Faltan datos..")
        return
      }

      // INICIO DE AGREGAR SALA -------------------------

      util.cargarLoader("Modificando sala...")
      
      let id;
      this.options.forEach(opt=>{
        if(opt.name == this.localCard.category){
          id = opt.id
          return
        }
      })
      const datos= {
        id: this.card.id,
        description: this.localCard.description,
        favourite: false,
        name:this.localCard.name,
        typeroom:{
          id: id
        },
        images: this.card.images
      }
      const res = await putMethod.updateRoom(datos)
      if (res) {
        util.cargarLoader("")
        this.$refs.modifyForm.reset()
        util.cargarPopUp("Sala modificada con éxito", "Gracias!")
      }else {
        util.cargarLoader("")
        this.$refs.modifyForm.reset()
        util.cargarPopUp("Ha ocurrido un error en el servido", "Lo sentimos!")
      }
    },
    async init(){
      util.cargarLoader("Cargando datos...")
      this.options = await getMethod.getTypeRooms()
      const data = {
        id:parseInt(this.$router.currentRoute.value.params.id, 10),
        isId: true
      }
      this.card = await getMethod.getRoom(data)
      this.localCard = {
        name:this.card.name,
        category:this.card.typeroom.name,
        description:this.card.description
      }
      util.cargarLoader("")
    }
  },
  async mounted(){
    await this.init()
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
  margin-top: 15px;
}
button:hover{
  background-color: #0f8389;
  transition: .5s ease-in-out;
}
</style>
