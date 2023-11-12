<template>
  <div v-for="sala in resultados" :key="sala?.id" :class="[theme, 'card']">
    <router-link :to="{ name: 'card-category', params: { id: sala?.name } }">
      <img :key="sala?.id" :src="sala?.image?.path" :alt="sala?.image">
      <div :class="[theme, 'info']">
        <h2>{{ sala.name }}</h2>
          <p class="infoDet">Detalles</p>
        </div>
      </router-link>
  </div>
</template>
  
  <script>
  
  export default {
    name:'CardCategoria',
    components:{
    },
    props:{
      resultados:{
        type:Array,
        default:()=>[]
      }
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
  .imgSimulation{
    width: 100%;
    height: 300px;
    background-color: #605B5B;
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
    margin-right: 50px;
    text-decoration: underline;
  }
  @media only screen and (max-width:480px ){ 
    .card {
      margin: 1%;
      overflow: hidden;
      width: 46%;
      height: 200px;
    }

    .card img {
      height: 150px;
    }
    .imgSimulation{
      height: 150px;
    }
    .info {
      width: 100%;
      padding: 5px;
      margin-top: -18px;
      margin-left: 0px;
      height: 55px;
    }
    .info p {
      font-size: 12px;
      margin-top: 10px;
      margin-right: 0px;
      
    }
    div.info > p:first-of-type{
      margin-left: -120px;
      margin-top: 19px;
      
    }
    .info h2{
      font-size: 15px;
      margin-left: 5px;
    }
  }
  </style>
  