<template>
  <div :class="[theme, 'card']">
    <div class="card-container">
      <div class="headerContainer">
        <h2>DETALLE DE SALA - {{ card[0].name }}</h2>
        <router-link to="/">
          <div class="cerrar">&lt;</div>
        </router-link>
      </div>
      <img v-for="images in card.images" :key="images.id" :src=images.path >
      <div class="footerCont">
        <p><strong>TIPO DE SALA: </strong>{{ card[0].typeroom.name }}</p>
        <div class="descripcion">
          <strong>DESCRIPCIÓN:</strong>
          <p>{{ card[0].description }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import util from '@/utils/utils';
import getMethod from '@/service/getMethod'

export default {
  name: 'CardDetail',
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    },
  },
  data(){
    return {
      card:[]
    }
  },
  methods: {
    async loadCard() {
      util.cargarLoader("Buscando sala...")
      const data = {
        id: this.$route.params.id,
        isId: true
      };
      const resultado = await getMethod.getRoom(data)
      this.card = resultado
      util.cargarLoader("")
    },
  },
};
</script>

<style scoped>
  .card{
    width: 100%;
  }
  .card-container{
    width: 100%;
    height: auto;
    padding: 50px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }
  .headerContainer{
    width: 85%;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 5px 20px;
    color: #605B5B;
  }
  .cerrar{
    display: flex;
    align-items: center;
    justify-content: center;
    color: #605B5B;
    border: 3px #605B5B solid;
    background-color: #cbcaca;
    font-size: 30px;
    font-weight: bold;
    width: 45px;
    height: 45px;
    border-radius: 50%;
    cursor: pointer;
    margin-right: 40px;
  }
  .imgSimulationCont{
    display: flex;
    align-items: center;
    justify-content: space-evenly;
    width: 80%;
    height: 300px;
  }
  .imgMainCont{
    display: flex;
    align-items: center;
    justify-content: center;
    width: 40%;
    height: 90%;
  }
  .imgMain{
    width: 100%;
    height: 100%;
    border: 2px solid black;
    border-radius: 5px;
  }
  .imgBox{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;
    flex-wrap: wrap;
    width: 50%;
    height: 90%;
  }
  .imgSimulation{
    width: 48%;
    height: 45%;
    border: 2px solid black;
    border-radius: 5px;
  }

  p{
    color: black;
  }

  .footerCont{
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    width: 80%;
  }
  .descripcion{
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: flex-start;
  }
  .descripcion p{
    width: 85%;
    padding-left: 5px;
    text-align: left;
  }


</style>
