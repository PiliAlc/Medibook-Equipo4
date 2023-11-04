<template>
  <div class="contenedor">
    <h2>PANEL DE ADMINISTRACIÓN</h2>
    <div class="mainTable">
      <div class="info">
        <p class="id">id</p>
        <p class="name">Nombre</p>
      </div>
      <div class="action">
        <p>Acciones</p>
      </div>
    </div>
    <div class="salaInfo">
      <AdminCard :cards='cards' @update-cards="updateCards" />
    </div>
  </div>
</template>

<script>
  import getMethod from '@/service/getMethod';
  import util from '@/utils/utils';
  import AdminCard from '@/components/AdminCard';

  export default {
    name:'AdministrarProducto',
    components:{
      AdminCard
    },
    computed: {
      theme() {
        return this.$store.getters.getTheme;
      },
    },
    data(){
      return {
        cards:[]
      }
    },
    async created() {
      await this.generarCards();
    },
    methods:{
      async generarCards(){
        util.cargarLoader("Cargando salas...")
        this.cards = await getMethod.getRooms()
        util.cargarLoader("")
      },
      async updateCards(updatedRooms) {
        this.cards = updatedRooms;
      },
    }
  }
</script>
<style scoped>
  .contenedor{
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: flex-start;
    padding: 50px;
  }
  .mainTable{
    width: 100%;
    height: 50px;
    display: flex;
    align-items: center;
    justify-content: space-around;
    border: 2px solid black;
    border-radius: 25px;
  }
  .info{
    width: 35%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: space-around;
  }
  .id{
    width: 30%;
  }
  .name{
    width: 70%;
  }
  .action{
    width: 65%;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .salaInfo{
    width: 100%;
  }
</style>