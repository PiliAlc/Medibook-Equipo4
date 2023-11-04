<template>
  <div class='logo'>
    <router-link to="/">
      <img src="../assets/LogoSlogan.png" alt="logo">
    </router-link>
  </div>
</template>

<script>
export default {
  name: 'LogoSlogan',
  props: {
  },
  computed: {
    themeClass() {
      return this.theme === 'claro' ? 'claro' : 'oscuro';
    },
  }
}
</script>

<style>
img {
  width: 20vw;
}

.logo{
  display: flex;
  align-items: center;
  height: 10vw;
}
@media only screen and (max-width:480px ){
  img {
  width: 60%;
  margin-right: 20vw;
}
}
</style>