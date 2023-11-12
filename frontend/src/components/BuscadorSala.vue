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
  <section :class="theme"  id="resultados">
    <h2 v-if="resultados.length > 0" >RESULTADOS DE BÚSQUEDA</h2>
    <div class="contenedor">
      <CardSala :resultados="resultados" />
    </div>
  </section>
</template>

<script>
import BotonPrincipal from './BotonPrincipal.vue';
import CardSala from './CardSala.vue';
import getMethod from '@/service/getMethod';
import util from '../utils/utils'

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
    async buscar(){
      this.resultados = []
      util.cargarLoader("Buscando salas...")
      const datos = await getMethod.getRooms()
      const busqueda = this.$refs.search.value.trim().toLowerCase();
      busqueda.length == 0 ? (
        util.cargarLoader(""),
        util.cargarPopUp("no se encontran coincidencias", "RESULTADO")
        ) :
      (this.resultados = datos.filter((sala) => {  
        let {name, description} = sala
        return name.trim().toLowerCase().includes(busqueda) ||
        description.trim().toLowerCase().includes(busqueda) 
        }) 
      )
      util.cargarLoader("")
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
section{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 4px solid var(--border);
  padding: 10px;
  background-color: white;
  width:100%;
}
.contenedor{
  display: flex;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
  width:100%;
}
h1{
  text-align: left;
  margin-bottom: 25px;
  margin-top: -10px;
  color: var(--text2);
}
h2{
  align-self: flex-start;
  margin-left: 50px;
  font-size: 2vw;
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
  margin-left: -3vw;
  width: 15vw;
}
.btnBusc{
  width: 100px;
  height: 4vw;
  font-size: 2vw;
}
nav {
  height: 14vw;
}
}
</style>
