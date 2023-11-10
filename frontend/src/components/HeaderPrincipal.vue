<template>
  <header :class="theme">
    <LogoSlogan />
    <div class="btnes">
      <router-link to="/signup" v-if="(path == '/' || path == '/login') && jwt == ''">
        <BotonPrincipal class="btnCrearCuenta" texto="CREAR CUENTA" size="19" />
      </router-link>
      <router-link to="/login" v-if="(path == '/' || path == '/signup') && jwt == ''">
        <BotonPrincipal class="btnInicio" texto="INICIAR SESIÓN" size="19"/>
      </router-link>  
      <router-link to="/admin" v-if="path != '/admin' && jwt != '' && rol == 'ADMIN'">
        <BotonPrincipal class="btnAgrSala" texto="ADMINISTRAR" size="19"/>
      </router-link>  
      <router-link to="/admin/product" v-if="(path == '/admin' || path == '/admin/category') && jwt != '' && rol == 'ADMIN'">
        <BotonPrincipal class="btnAgrSala" texto="AGREGAR SALA" size="19"/>
      </router-link>  
      <router-link to="/admin/category" v-if="(path == '/admin' || path == '/admin/product') && jwt != '' && rol == 'ADMIN'">
        <BotonPrincipal class="btnAgrSala" texto="+ CATEGORÍA" size="19"/>
      </router-link>
      <UserProfile v-if="(path != '/login' || path == '/signup') && jwt != ''"/>
      <!-- <BotonPrincipal class="btnTheme" texto="🌓" @click="toggleTheme" style="border-radius: 50%; padding: .8vw;" /> -->
    </div>
  </header>
</template>

<script>
import LogoSlogan from '../components/LogoSlogan.vue';
import BotonPrincipal from '../components/BotonPrincipal';
import UserProfile from '../components/UserProfile.vue'

export default {
  name: 'HeaderPrincipal',
  components:{
    LogoSlogan,
    BotonPrincipal,
    UserProfile,
  },
  props:{
  },
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    },
    rol() {
      let rol = ""
      if (this.$store.getters.getUser && this.$store.getters.getUser.roles) {
        rol = this.$store.getters.getUser.roles[0].name
      }
      return rol 
    },
    jwt() {
      return this.$store.getters?.getUser?.jwt || ""
    },
    path() {
      return this.$router.currentRoute.value.path
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
  z-index: 9;
  display: flex;
  position: sticky;
  top: 0;
  justify-content: space-between;
  align-items: center;
  border: 4px solid var(--border);
  padding: 10px;
  background-color: var(--text);
  width:100%;
  height: 8vw;
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
  
}
</style>
