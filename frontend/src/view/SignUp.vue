<template>
  <div :class="[theme, 'contenedor']">
    <div class="signup-container">
      <h2>Registrarse</h2>
      <form @submit.prevent="submitForm">

        <label for="name">Nombre:</label>
        <input ref="name" type="text" id="name" :value="name" placeholder="Entre 3 y 20 Letras"/>

        <label for="lastName">Apellido:</label>
        <input ref="lastName" type="text" id="lastName" :value="lastName" placeholder="Entre 3 y 20 Letras"/>

        <label for="username">Correo Electrónico:</label>
        <input ref="username" type="text" id="username" :value="username" placeholder="En formato xxxx@xxx.xxx"/>

        <label for="password">Contraseña:</label>
        <input ref="password" type="password" id="password" :value="password" placeholder="8-20: May, Min, !@#$%^&*()_+." @change="checkPass"/>

        
        <button type="submit">Registrarse</button>
      </form>
      <span v-if="!showMsg">{{ msg }}</span>
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
      roles:["ADMIN"],
      showMsg:true,
      msg:"La contraseña debe cumplir con los requisitos: \n Al menos una letra minúscula y una maypuscula. \n Un caracter especial: !@#$%^&*()_+ \n Tener una longitud entre 8 y 12 caracteres."
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
        roles: this.roles
      }
      util.cargarLoader("Agregando usuario")
      let validation = [ { name: util.validarDatos(data.name,"nombre") },
        { lastname: util.validarDatos(data.lastname,"apellido") },
        { username: util.validarDatos(data.username,"email"), },
        { password: util.validarDatos(data.password,"password") }
      ]
      for(let item of validation){
        const fieldName = Object.keys(item)[0]
        if (!item[fieldName].isValid) {
          util.cargarLoader("")
          util.cargarPopUp(item[fieldName].texto, "ERROR")
          return
        }
      }

      if (validation[0].name.isValid && validation[1].lastname.isValid && validation[2].username.isValid && validation[3].password.isValid) {
        const result = await postMethods.addUser(data)
        util.cargarLoader("")
        if (result) {
          this.resetForm();
          util.cargarPopUp("Usuario agregado con éxito", "GRACIAS")
          this.$store.commit('setUser', data)
          this.$router.push({ path: '/login' })
        } else {
          util.cargarPopUp("Problema en el servidor", "ERROR")
        }
      }
    },
    resetForm() {
      this.name = '';
      this.lastName = '';
      this.username = '';
      this.password = '';
    },
    checkPass(e){
      this.showMsg = util.validarDatos(e.target.value,"password").isValid
    }
  }
};
</script>

<style scoped>
.contenedor {
  background-color: #15b4bc;
  color: var(--text);
  height: auto;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px 0;
}
.signup-container {
  width: 300px;
  padding: 20px;
  margin: 20px;
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
