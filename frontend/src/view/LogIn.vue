<template>
  <div :class="[theme, 'contenedor']">
    <div class="login-container">
      <h2>Iniciar Sesión</h2>
      <form ref="loginForm" @submit.prevent="submitForm">
        <label for="username">Usuario:</label>
        <input ref="username" type="text" id="username" :value="username" />

        <label for="password">Contraseña:</label>
        <input ref="password" type="password" id="password" :value="password" />

        <button type="submit">Iniciar Sesión</button>
      </form>
    </div>
  </div>
</template>

<script>
import getMethod from '../service/getMethod'
import postMethods from '@/service/postMethod';
export default {
  name: 'LogIn',
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    }
  },
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    async submitForm() {
      // this.$refs.loginForm.preverntDefault()
      const data= {
        description: "aca estamos testeando el post",
        favourite: false,
        name:"sala post",
        typeroom:{id:1}
      }
      const posteando = await postMethods.addRoom(data)
      console.log(posteando);
      const {getRooms} = getMethod
      const json = await getRooms()
      console.log(json);
      /* this.username = this.$refs.username.value
      this.password = this.$refs.password.value
      console.log('Usuario:', this.username);
      console.log('Contraseña:', this.password); */
      this.resetForm()
    },
    resetForm(){
      this.username = ""
      this.password = ""
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
.contenedor:hover{
  background-color: #15b4bc;
}

.login-container {
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
button:hover{
  background-color: #0f8389;
  transition: .5s ease-in-out;
}
</style>
