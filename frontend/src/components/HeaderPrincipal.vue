<template>
  <header :class="theme">
    <LogoSlogan />
    <div class="btnes">
      <router-link to="/signup">
        <BotonPrincipal class="btnCrearCuenta" texto="CREAR CUENTA" size="19" />
      </router-link>
      <router-link to="/login">
        <BotonPrincipal class="btnInicio" texto="INICIAR SESIÓN" size="19"/>
      </router-link>  
      <router-link to="/admin">
        <BotonPrincipal class="btnAgrSala" texto="AGREGAR SALA" size="19"/>
      </router-link>  
      <!-- <BotonPrincipal class="btnTheme" texto="🌓" @click="toggleTheme" style="border-radius: 50%; padding: .8vw;" /> -->
    </div>
  </header>
</template>

<script>
import LogoSlogan from '../components/LogoSlogan.vue';
import BotonPrincipal from '../components/BotonPrincipal';

export default {
  name: 'HeaderPrincipal',
  components:{
    LogoSlogan,
    BotonPrincipal,
  },
  props:{
  },
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    }
  },
  methods: {
    toggleTheme() {
      const newTheme = this.theme === 'claro' ? 'oscuro' : 'claro';
      this.$store.dispatch('setTheme', newTheme);
    },
  },
}
</script>

<style scoped>
header{
  display: flex;
  position: sticky;
  top: 0;
  justify-content: space-between;
  align-items: center;
  border: 4px solid var(--border);
  padding: 10px;
  background-color: var(--text);
  width:100%;
  height: 9vw;
}
.btnes {
  display: flex;
  align-items: center;
  justify-content: flex-end;

}
.btnCrearCuenta{
  background-color: white;
  color: var(--text2);
  border-radius: 20px;
  height: 3vw;
  font-size: 1vw;
  width: 12vw !important;
}

.btnInicio, .btnTheme, .btnAgrSala{
  border-radius: 20px;
  height: 3vw;
  font-size: 1vw;
  width: 12vw !important;

}

@media only screen and (max-width:480px ){
  header{
    height: 11vw;
  }
  .btnInicio, .btnTheme, .btnAgrSala, .btnCrearCuenta{
    height: 5vw;
  font-size: 1.5vw;
  width: 14vw !important;

}
.btnAgrSala{
  display: none;
}
}
</style>
