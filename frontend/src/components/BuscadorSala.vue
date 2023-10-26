<template>
  <nav :class="theme">
    <h1>BUSCA LA SALA</h1>
    <div class="buscadorContainer">
      <label for="search">
        <input ref="search" id="search" type="text" placeholder="TIPO DE SALA">
      </label>
      <div class="btnContainer">
        <BotonPrincipal class="btnBusc" texto="BUSCAR" size="19" @click="buscar" />
      </div>
    </div>
  </nav>
  <div :class="theme"  id="resultados">
    <CardSala :resultados="resultados" />
  </div>
</template>

<script>
import BotonPrincipal from './BotonPrincipal.vue';
import data from '@/data';
import CardSala from './CardSala.vue';

export default {
  name: 'BuscadorSala',
  components:{
    BotonPrincipal,
    CardSala
  },
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    }
  },
  data() {
    return {
      resultados: [],
    };
  },
  methods: {
    cargarLoader(){
      const cargando = {
        isCargando: !this.$store.state.loader.cargando,
        texto: this.$store.state.loader.textoCargando == '' ? 'Buscando salas...' : ''
      };
      this.$store.dispatch('setCargando', cargando)
    },
    buscar(){
      this.cargarLoader()
      setTimeout(() => {
        const busqueda = this.$refs.search.value.trim().toLowerCase();
        busqueda.length == 0 ? this.cargarLoader() :
          (this.resultados = data.filter((sala) => {
            let {name, description, url} = sala
            return name.trim().toLowerCase().includes(busqueda) ||
            description.trim().toLowerCase().includes(busqueda) ||
            url[0].trim().toLowerCase().includes(busqueda)
          }),
        this.cargarLoader())
      }, 1000);
    }
  },
}
</script>

<style scoped>
nav{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 2vw;
  background-color: var(--background2);
  width:100%;
  height: 100%;
  
}
h1{
  margin-bottom: 25px;
  margin-top: -10px;
  color: var(--text2);
}
.buscadorContainer{
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 2vw;
}
label, input{
  padding: 1vw;
  outline: none;
  border: 1px solid var(--border);
  color: var(--oscuro);
  width: 70%;
  
}
label{
  display: flex;
  justify-content: flex-end;
}
input{
  width: 80%;
  border-radius: 20px;
  text-align: center;
}
.btnContainer{
  display: flex;
  align-items: center;
  justify-content: flex-start;
  width: 12vw ;
  
}
.btnBusc{
  border-radius: 20px;
  font-size: 1vw;
  height: 2.8vw ;
}
#resultados {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  background-color: var(--text);
}
@media only screen and (max-width:480px ){
    h1{
  font-size: 13px;
  margin-top: -5px;
}
label, input {
  padding: 0.3vw;
  margin-top: -4vw;
  margin-right: 2vw;
  font-size: 2vw;
}
.btnContainer{
  margin-top: -8vw;
  width: 10vw;
}
}
</style>
