<template>
    <div :class="[theme, 'contenedor']">
      <div class="login-container">
        <h2>AGREGAR CATEGORÍA</h2>
        <form ref="loginForm" @submit.prevent="submitForm">
          
          <label for="nombre">NOMBRE*</label>
          <input ref="nombre" type="text" id="nombre" :value="nombre" />
  
          <label for="description">DESCRIPCIÓN*</label>
          <textarea ref="description" id="description" :value="description" maxlength="100" rows="4" cols="50"></textarea>
  
          <button type="submit">AGREGAR</button>
        </form>
      </div>
    </div>
  </template>
  
  <script>
  import postMethods from '@/service/postMethod';
  import getMethod from '@/service/getMethod';
  import util from '@/utils/utils';

  export default {
    name: 'AgregarCategoria',
    computed: {
      theme() {
        return this.$store.getters.getTheme;
      }
    },
    data() {
      return {
      };
    },
    methods: {
      async submitForm() {

        const categoryResult = await getMethod.getTypeRooms()
        let aux = false
        if (categoryResult) {
          categoryResult.forEach(category => {
            if (category.name == this.$refs.nombre.value) {
              aux = true
              return
            }
          });
        }
        if (aux) {
          util.cargarPopUp("ya exite una categoría con ese nombre", "Faltan datos..")
          aux=false
          return
        }

        if (this.$refs.nombre.length < 1) {
          util.cargarPopUp("Ingrese el nombre", "Faltan datos..")
          return
        }
        if (this.$refs.description.length < 1) {
          util.cargarPopUp("Ingrese el descripción de la sala", "Faltan datos..")
          return
        }
  
        util.cargarLoader("agregando sala...")

        const category = {
          name: this.$refs.nombre.value,
          description: this.$refs.description.value
        }

        const res = await postMethods.addTypeRoom(category)
        
        if (res) {
          util.cargarLoader()
          this.$refs.loginForm.reset()
          util.cargarPopUp("Categoría agregada con éxito", "Gracias!")
        }
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
    margin-top: 15px;
  }
  button:hover{
    background-color: #0f8389;
    transition: .5s ease-in-out;
  }
  </style>
  