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

      const data = await getMethod.getRooms()
      console.log(data);
      const categorias = {};

      data.forEach(room => {
        const {name} = room.typeroom
        if (!categorias[name]) {
          categorias[name] = []
        }
        categorias[name].push(room)
      })

      const arrayPorCategoria = Object.keys(categorias).map(categoria => ({
        id: categoria,
        salas: categorias[categoria]
      }))

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

@media only screen and (max-width:480px ){
  h3{
  font-size: 4.5vw;
  margin-left:-70% ;
}

}
</style>
