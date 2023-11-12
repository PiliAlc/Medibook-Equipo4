<template>
  <div v-for="sala in resultados" :key="sala.id" :class="[theme, 'card']">
    <img :key="sala.images[0].id" :src="sala.images[0].path" :alt="sala.images[0].name">
    <div :class="[theme, 'info']">
      <h2>{{ sala.name }}</h2>
      <h2>{{ sala.typeroom.name }}</h2>
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
      resultados:{
        type:Array,
        default:()=>[]
      }
    },
    computed: {
      theme() {
        return this.$store.getters.getTheme;
      },
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
    border: solid var(--text2);
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
  @media only screen and (max-width:480px ){ 
    .card {
      margin: 1%;
      overflow: hidden;
      width: 46%;
      height: 200px;
    }
    .card img {
      width: 100%;
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
  