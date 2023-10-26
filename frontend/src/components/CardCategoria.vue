<template>
  <div v-for="sala in resultados" :key="sala.id" :class="[theme, 'card']">
    <router-link :to="{ name: 'card-category', params: { id: sala.description } }">
      <img :src="sala.url[0]" :alt="sala.name">
    </router-link>
      <div :class="[theme, 'info']">
        <h2>{{ sala.description }}</h2>
        <p>{{ sala.description }}</p>
        <p class="infoDet">Detalles</p>
      </div>
  </div>
</template>
  
  <script>
  
  export default {
    name:'CardCategoria',
    components:{
    },
    props:{
      resultados:[],
    },
    computed: {
      theme() {
        return this.$store.getters.getTheme;
      }
    },
    mounted(){
    }
  }
  </script>
  
  <style scoped>
  
  .card {

    margin: 1%;
    overflow: hidden;
    width: 390px;
  }
  
  .card img {
    width: 100%;
    height: 300px;
    object-fit: cover;
    border-radius: 25px 25px 0 0;
    border: solid #605B5B;
  }
  
  .info {
    position: relative;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding: 10px;
    background-color: var(--background2);
    border: solid var(--text2);
    margin-top: -25px;
    border-radius: 15px 15px 25px 25px;
    z-index: 2;
  }
  .info h2{
    margin-left: 35px;
    text-transform: capitalize;
    color: var(--text2);
  }
  .info p {
    color: var(--text2);
    margin-top: 6px;
    text-decoration: underline;
  }
  </style>
  