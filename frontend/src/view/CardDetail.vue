<template>
  <div :class="[theme, 'card']">
    <div class="card-container">
      <img :src=url :alt="card.name" >
      <div :class="[theme, 'info']">
        <h2>{{ card.name }}</h2>
        <p>{{ card.description }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import data from '@/data';

export default {
  name: 'CardDetail',
  data() {
    return {
      card: {},
      url: ""
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
    loadCard() {
      this.card = data.filter(item => item.id == this.$route.params.id)
      this.card = this.card[0]
      this.url = this.card.url[0]
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
