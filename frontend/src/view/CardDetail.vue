<template>
  <div :class="[theme, 'card']">
    <div class="card-container">
      <div class="headerContainer">
        <h2>DETALLE DE SALA - {{ card?.name }}</h2>
        <div class="cerrar" @click="goBack">&lt;</div>
      </div>
      <div class="mainContainer">
        <div class="mainImage" v-if="card?.images && card.images.length > 0">
          <img :src="card?.images[0]?.path" :alt="card?.images[0]?.alt">
        </div>
        <div class="secondaryImages">
          <img v-for="(image, index) in card?.images?.slice(1, 5)" :key="index" :src="image.path" :alt="image.alt">
        </div>
      </div>
      <div class="footerCont">
        <p><strong>TIPO DE SALA: </strong>{{ card?.typeroom?.name }}</p>
        <div class="descripcion">
          <strong>DESCRIPCIÓN:</strong>
          <p>{{ card?.description }}</p>
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
  created() {
			this.loadCard();
		},
  methods:{
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
    goBack() {
      this.$router.go(-1);
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
  p{
    color: black;
  }
  .mainContainer {
    width: 80%;
    height: 350px;
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 20px 0;
  }
  .mainImage{
    position: relative;
    width: 50%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .secondaryImages{
    position: relative;
    width: 50%;
    height: 100%;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: space-around;
  }
  .mainImage img {
    width: 100%;
    height: 100%;
    border-radius: 8px;
  }
  .secondaryImages img {
    width: 45%;
    height: 45%;
    border-radius: 8px;
    margin-bottom: 10px;
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
