<template>
  <section :class="theme">
    <h3>CATEGORÍAS</h3>
    <div class="contenedor">
      <CardCategoria :resultados="resultados" />
    </div>
  </section>
</template>

<script>
import CardCategoria from './CardCategoria.vue';
import getMethod from '@/service/getMethod';
import util from '@/utils/utils';

export default {
  name: 'CategoriaSala',
  props:{
  },
  components:{
    CardCategoria
  },
  data() {
    return {
      resultados: [],
    };
  },
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    }
  },
  mounted() {
    this.generarCategorias();
  },
  methods: {
    async generarCategorias() {
      util.cargarLoader("Buscando salas...")
      this.resultados = await getMethod.getTypeRooms()
      util.cargarLoader("")
    },
  },

}
</script>

<style scoped>
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
h3{
  margin-left:-80% ;
  font-size: 2vw;
  color: var(--text2);
}

@media only screen and (max-width:480px ){
  h3{
  font-size: 4.5vw;
  margin-left:-70% ;
}

}
</style>
