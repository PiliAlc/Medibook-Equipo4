<template>
  <div v-for="sala in resultados" :key="sala.id" :class="[theme, 'card']">
    <img :src="sala.url[0]" :alt="sala.name">
    <div :class="[theme, 'info']">
      <h2>{{ sala.name }}</h2>
      <p class="infoDesc">{{ sala.description }}</p>
      <router-link :to="{ name: 'card-detail', params: { id: sala.id } }">
        <p class="infoDet">Detalles</p>
      </router-link>
      </div>
    </div>
</template>
  
  <script>
  
  export default {
    name:'CardSala',
    components:{
    },
    props:{
      resultados:[]
    },
    computed: {
    theme() {
      return this.$store.getters.getTheme;
    },
  },
    mounted(){
      this.resultados.forEach(element => {
        console.log(element.utr[0])
      });
      console.log(this.resultados);
    }
  }
  </script>
  
  <style scoped>
  
  .card {
    margin: 10px;
    overflow: hidden;
    width: 330px;
  }
  
  .card img {
    width: 100%;
    height: 300px;
    object-fit: cover;
    border-radius: 25px 25px 0 0;
    border: solid var(--text2);
  }
  
  .info {
    position: relative;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding: 10px;
    background-color: var(--background2);
    border: solid  var(--text2);
    margin-top: -25px;
    border-radius: 15px 15px 25px 25px;
    z-index: 2;
    height: 4vw;
  }
  .info h2{
    margin-left: 35px;
    text-transform: capitalize;
    color: var(--text2);
  }
  .infoDesc {
    color: var(--text2);
    margin-top: 28px;
    margin-left: -160px;
  }
  .infoDet {
    color: var(--text2);
    margin-top: 13px;
    margin-right: 50px;
    text-decoration: underline;
  }
  </style>
  