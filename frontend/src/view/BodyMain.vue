<template>
  <main>
    <BuscadorSala />
    <CategoriaSala />
    <RecomendacionSala />
  </main>
</template>

<script>

import BuscadorSala from '@/components/BuscadorSala.vue';
import CategoriaSala from '@/components/CategoriaSala.vue';
import RecomendacionSala from '@/components/RecomendacionSala.vue';

export default {
  name: 'BodyMain',
  components:{
    BuscadorSala,
    CategoriaSala,
    RecomendacionSala
  },
  props:{
  },
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    }
  },
  
}
</script>

<style scoped>

  main{
    width: 100%;
    height: auto;
  }
  
</style>