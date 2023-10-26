<template>
  <section :class="theme">
    <h3>RECOMENDACIONES</h3>
    <div class="contenedor">
      <CardSala :resultados="resultados" />
    </div>
  </section>
</template>

<script>
import CardSala from './CardSala.vue';
import data from '@/data';

export default {
  name: 'RecomendacionSala',
  props:{
  },
  components:{
    CardSala
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
    this.generarResultados();
  },
  methods: {
    generarResultados() {
      // esta dataFiltrada es únicamente porque las 3 primeras imágenes del data.js no son de salas
      const dataFiltrada = data.slice(3);
      const indicesAleatorios = this.obtenerIndicesAleatorios(dataFiltrada.length, 5);
      this.resultados = indicesAleatorios.map(index => dataFiltrada[index]);
    },
    obtenerIndicesAleatorios(max, cantidad) {
      const indices = [];
      while (indices.length < cantidad) {
        const indice = Math.floor(Math.random() * max);
        indices.push(indice);
      }
      return indices;
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
}
h3{
  margin-left:-73% ;
  font-size: 2vw;
  color: var(--text2);
}
</style>
