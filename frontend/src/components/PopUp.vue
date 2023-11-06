<template>
  <div v-if="cargando" class="contenedor">
    <div class="textCont">
      <div class="texto">
        <h2>{{ titulo }}</h2>
        <p>{{ texto }}</p>
      </div>
      <div class="cerrarBtn" ref="cerrar" @click="cerrarPopUp">x</div>
    </div>
  </div>
</template>

<script>
export default {
  name:"PopUp",
  props: {
  },
  computed: {
    cargando() {
      return this.$store.getters.getPopUp;
    },
    titulo(){
      return this.$store.getters.getTituloPopUp
    },
    texto(){
      return this.$store.getters.getTextoPopUp
    }
  },
  methods:{
    cerrarPopUp(){
      const cargando = {
        isCargando: false,
        texto: '',
        titulo: ''
      };
      this.$store.dispatch('setPopup', cargando)
    },
  }
};
</script>

<style scoped>

.contenedor{
position: absolute;
width: 100%;
height: 115vh;
left: 50%;
top: 50%;
transform: translate(-50%, -50%);
background-color: rgba(0, 0, 0, 0.5);
}
.textCont{
  position: relative;
  left: 50%;
  top: 67%;
  transform: translate(-50%, -50%);
  display: flex;
  align-items: center;
  justify-content: center;
  width: 60vh;
  height: 55%;
  border: 1px solid aqua;
  background-color: rgba(0, 0, 0, 0.8);
}
h2, p{
  padding: 10px;
  color: aqua;
}

.cerrarBtn{
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 50%;
  width: 50px;
  height: 50px;
  border: 1px solid aqua;
  color: aqua;
  cursor: pointer;
  align-self: flex-start;
  justify-self: flex-start;
  margin-top: 10px;
}
.texto{
  width: 80%;
  text-align: right;
}

@media only screen and (max-width:480px ){

  .textCont{
  left: 50%;
  top: 55%;
  width: 45vh;
  height: 45%;
}
.contenedor{
height: 100vh;
}

}

</style>