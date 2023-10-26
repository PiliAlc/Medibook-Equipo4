<template>
    <div v-if="cargando" class="contenedor">
      <div class="lds-heart"><div></div></div>
      <p>{{ texto }}</p>
    </div>
</template>

<script>
  export default {
    name:"LoaderMain",
    props: {
    },
    computed: {
    cargando() {
      return this.$store.getters.getCargando;
    },
    texto(){
      return this.$store.getters.getTextoCargando
    }
  },
  };
</script>
<style scoped>

.lds-heart {
  display: inline-block;
  position: relative;
  top: 50%;
  transform: translate(-50%, -50%);
  width: 80px;
  height: 80px;
  transform: rotate(45deg);
  transform-origin: 40px 40px;
}
.lds-heart div {
  top: 32px;
  left: 32px;
  position: absolute;
  width: 32px;
  height: 32px;
  background: #cef;
  animation: lds-heart 1.2s infinite cubic-bezier(0.215, 0.61, 0.355, 1);
}
.lds-heart div:after,
.lds-heart div:before {
  content: " ";
  position: absolute;
  display: block;
  width: 32px;
  height: 32px;
  background: #cef;
}
.lds-heart div:before {
  left: -24px;
  border-radius: 50% 0 0 50%;
}
.lds-heart div:after {
  top: -24px;
  border-radius: 50% 50% 0 0;
}
@keyframes lds-heart {
  0% {
    transform: scale(0.95);
  }
  5% {
    transform: scale(1.1);
  }
  39% {
    transform: scale(0.85);
  }
  45% {
    transform: scale(1);
  }
  60% {
    transform: scale(0.95);
  }
  100% {
    transform: scale(0.9);
  }
}
.contenedor{
  position: absolute;
  width: 100%;
  height: 100%;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  background-color: rgba(0, 0, 0, 0.5);
}
p{
  position: relative;
  left: 50%;
  top: 52%;
  transform: translate(-50%, -50%);
}

</style>