<template>
  <button
    :class="['mainBtn', theme]"
    :style="{ width: size + 'vw' }"
  >{{ texto }}</button>
</template>

<script>
export default {
  name: 'BotonPrincipal',
  props: {
    texto: {
      type:String,
      default:()=>""
    },
    size: {
      type:String,
      default:()=>""
    }
  },
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    }
  },
};
</script>

<style scoped>
.mainBtn {
  padding: 0.3vw 1vw;
  cursor: pointer;
  margin-right: 10px;
  transition: 0.5s ease-in-out;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: var(--background);
  border: var(--border);
  color: var(--text);
  box-shadow: var(--shadow);
  font-size: 1.5vw;
  font-family: 'Poppins', sans-serif;
}

.mainBtn:hover {
  background-color: var(--background);
  border: var(--border);
  color: var(--text);
  box-shadow: var(--shadow);
}
</style>
