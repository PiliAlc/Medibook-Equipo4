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
import data from '@/data';

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
    generarCategorias() {
      const categorias = {};

      data.forEach(sala => {
        if (sala.description != "pasillo de la clinica" && sala.description != "recepcion de la clinica") {
          const categoria = sala.description;
          if (!categorias[categoria]) {
            categorias[categoria] = [];
          }
          categorias[categoria].push(sala);
        }
      });

      const arrayPorCategoria = Object.keys(categorias).map(categoria => ({
        id: categoria,
        salas: categorias[categoria]
      }));

      // reformular este resultado
      this.resultados = arrayPorCategoria.map(item=> item.salas[0])
      
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
</style>
