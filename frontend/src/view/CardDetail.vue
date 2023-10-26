<template>
  <div :class="[theme, 'card']">
    <img :src=url :alt="card.name" >
    <div :class="[theme, 'info']">
      <h2>{{ card.name }}</h2>
      <p>{{ card.description }}</p>
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
      console.log(this.card);
      this.card = this.card[0]
      console.log(this.card);
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
    padding: 10px;
  }
</style>
