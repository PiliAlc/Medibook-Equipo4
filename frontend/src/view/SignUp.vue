<template>
  <div :class="[theme, 'contenedor']">
    <div class="signup-container">
      <h2>Registrarse</h2>
      <form @submit.prevent="submitForm">
        <label for="name">Nombre:</label>
        <input ref="name" type="text" id="name" :value="name" />

        <label for="lastName">Apellido:</label>
        <input ref="lastName" type="text" id="lastName" :value="lastName" />

        <label for="username">Correo Electrónico:</label>
        <input ref="username" type="email" id="username" :value="username" />

        <label for="password">Contraseña:</label>
        <input ref="password" type="password" id="password" :value="password" />

        <button type="submit">Registrarse</button>
      </form>
    </div>
  </div>
</template>

<script>

import postMethods from '@/service/postMethod';
import util from '@/utils/utils';

export default {
  name: 'SignUp',
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    }
  },
  data() {
    return {
      name: '',
      lastName: '',
      username: '',
      password: '',
      roles:["USER"]
    };
  },
  methods: {
    async submitForm() {

      this.name = this.$refs.name.value
      this.lastName = this.$refs.lastName.value
      this.username = this.$refs.username.value
      this.password = this.$refs.password.value

      const data = {
        name: this.name,
        lastname: this.lastName,
        username: this.username,
        password: this.password,
        roles:["USER"]
      }
      util.cargarLoader("Agregando usuario")
      let validation = {
        name: util.validarDatos(data.name,"texto"),
        lastname: util.validarDatos(data.lastname,"texto"),
        username: util.validarDatos(data.username,"email"),
        password: util.validarDatos(data.password,"password"),
      }
      let {name, lastname, username, password} = validation
      if (name && lastname && username && password) {
        const result = await postMethods.addUser(data)
        util.cargarLoader("")
        if (result) {
          this.resetForm();
          util.cargarPopUp("Usuario agregado con éxito", "GRACIAS")
          this.$store.commit('setUser', data)
          this.$router.push({ path: '/login' })
        }
      } else {
        util.cargarPopUp("los datos ingresados no son correctos", "ERROR")
      }
    },
    resetForm() {
      this.name = '';
      this.lastName = '';
      this.username = '';
      this.password = '';
    }
  }
};
</script>

<style scoped>
.contenedor {
  background-color: #15b4bc;
  color: var(--text);
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
}
.signup-container {
  width: 300px;
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

button:hover {
  background-color: #0f8389;
  transition: .5s ease-in-out;
}
</style>
