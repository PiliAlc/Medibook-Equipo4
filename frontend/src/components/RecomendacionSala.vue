<template>
  <section :class="theme">
    <h3>RECOMENDACIONES</h3>
    <div class="contenedor">
      <CardSala :resultados="resultados" />
    </div>
  </section>
</template>

<script>
import CardSala from "./CardSala.vue";
import util from "@/utils/utils";
import getMethod from "@/service/getMethod";

export default {
  name: "RecomendacionSala",
  props: {},
  components: {
    CardSala,
  },
  data() {
    return {
      resultados: [],
    };
  },
  computed: {
    theme() {
      return this.$store.getters.getTheme
    },
  },
  async mounted() {
    await this.generarResultados()
  },
  methods: {
    async generarResultados() {
      const data = await getMethod.getRooms()
      if (data) {
        util.cargarLoader("cargando")
        this.$store.dispatch('setRooms', data)
        const cantidad = data.length < 5 ? data.length : 5
        const indicesAleatorios = this.obtenerIndicesAleatorios(data.length,cantidad)
        this.resultados = indicesAleatorios.map((index) => data[index])
        util.cargarLoader("")
      }
    },
    obtenerIndicesAleatorios(max, cantidad) {
      const indices = []
      while (indices.length < cantidad) {
        const indice = Math.floor(Math.random() * max)
        if (!indices.includes(indice)) {
          indices.push(indice);
        }
      }
      return indices
    },
  },
};
</script>

<style scoped>
section {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 4px solid var(--border);
  padding: 10px;
  background-color: white;
  width: 100%;
  height: auto;
}
.contenedor {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
  width: 100%;
}
h3 {
  margin-left: -73%;
  font-size: 2vw;
  color: var(--text2);
}
@media only screen and (max-width: 480px) {
  h3 {
    font-size: 4.5vw;
    margin-left: -52%;
  }
}
</style>
