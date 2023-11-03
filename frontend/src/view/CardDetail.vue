<template>
  <div :class="[theme, 'card']">
    <div class="card-container">
      <!-- <img v-for="url in card.url" :key="url" :src=url :alt="card.name" > -->
      <div class="imgSimulation"></div>
      <div :class="[theme, 'info']">
        <h2>{{ card.name }}</h2>
        <p>{{ card.description }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import getMethod from '@/service/getMethod';
import util from '@/utils/utils';

export default {
  name: 'CardDetail',
  data() {
    return {
      card: {},
    };
  },
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    }
  },
  mounted() {
    this.loadCard();
  },
  methods: {
    async loadCard() {
      util.cargarLoader("Buscando sala...")
      const data= {
        id:this.$route.params.id,
        isId:true
      }
      this.card = await getMethod.getRoom(data)
      util.cargarLoader("")
    },
  },
};
</script>

<style scoped>
  .card {
    border: 1px solid var(--border);
    border-radius: 8px;
    margin: 10px;
    overflow: hidden;
    width: 300px;
    background-color: var(--background);
    color: var(--text);
  }
  
  .card img {
    width: 100%;
    height: 200px;
    object-fit: cover;
    border-radius: 8px;
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
    padding: 10px;
    background-color: var(--background);
    border-radius: 8px;
    margin-top: -20px;
    z-index: 2;
  }
  .card-container{
    background-color: white;
    height: 70vh;
  }

</style>
