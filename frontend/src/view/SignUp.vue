<template>
  <div :class="[theme, 'contenedor']">
    <div class="signup-container">
      <h2>Registrarse</h2>
      <form @submit.prevent="submitForm">
        <label for="username">Usuario:</label>
        <input ref="username" type="text" id="username" :value="username" />

        <label for="email">Correo Electrónico:</label>
        <input ref="email" type="email" id="email" :value="email" />

        <label for="password">Contraseña:</label>
        <input ref="password" type="password" id="password" :value="password" />

        <button type="submit">Registrarse</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SignUp',
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    }
  },
  data() {
    return {
      username: '',
      email: '',
      password: ''
    };
  },
  methods: {
    submitForm() {

      this.username = this.$refs.username.value
      this.email = this.$refs.email.value
      this.password = this.$refs.password.value

      console.log('Usuario:', this.username);
      console.log('Correo Electrónico:', this.email);
      console.log('Contraseña:', this.password);

      // Enviar los datos del formulario al servidor

      this.resetForm();
    },
    resetForm() {
      this.username = '';
      this.email = '';
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
