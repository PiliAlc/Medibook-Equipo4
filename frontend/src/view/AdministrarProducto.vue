<template>
  <div class="contenedor">
    <h2>PANEL DE ADMINISTRACIÓN</h2>
    <div class="mainTable">
      <div class="salaCont">
        <p :class="{ back : display }" @click="displayHandler(true)">salas</p>
      </div>
      <div class="categoryCont">
        <p :class="{ back : !display }" @click="displayHandler(false)">categorías</p>
      </div>
    </div>
    <div class="mainTable">
      <div class="info">
        <p class="id">id</p>
        <p class="name">Nombre</p>
      </div>
      <div class="action">
        <p>Acciones</p>
      </div>
    </div>
    <div class="salaInfo" v-if="display">
      <AdminCard :cards="cards" @update-cards="updateCards" />
    </div>
    <div class="salaInfo" v-if="!display">
      <AdminType :cards="cards" @update-cards="updateCards" />
    </div>
  </div>
</template>

<script>
import getMethod from "@/service/getMethod";
import util from "@/utils/utils";
import AdminCard from "@/components/AdminCard";
import AdminType from '@/components/AdminType'

export default {
  name: "AdministrarProducto",
  components: {
    AdminCard,
    AdminType,
  },
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    },
  },
  data() {
    return {
      cards: [],
      display: true,
    };
  },
  async created() {
    await this.generarCards();
  },
  methods: {
    async generarCards() {
      util.cargarLoader("Cargando salas...");
      this.cards = await getMethod.getRooms();
      util.cargarLoader("");
    },
    async generarCards2() {
      util.cargarLoader("Cargando salas...");
      this.cards = await getMethod.getTypeRooms();
      util.cargarLoader("");
    },
    async updateCards(updatedRooms) {
      this.cards = updatedRooms;
    },
    async displayHandler(value){
      this.display = value
      if (value) {
        await this.generarCards()
      } else {
        await this.generarCards2()
      }
    }
  },
};
</script>
<style scoped>
.contenedor {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: flex-start;
  padding: 50px;
}
.mainTable {
  width: 100%;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: space-around;
  border: 2px solid black;
  border-radius: 25px;
  margin-top: 5px;
}

.categoryCont, .salaCont{
  width: 50%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}

.mainTable .back{
    height: 100%;
    width: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    border: 1px solid black;
    border-radius: 25px;
}

.info {
  width: 35%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: space-around;
}
.id {
  width: 30%;
}
.name {
  width: 70%;
}
.action {
  width: 65%;
  display: flex;
  align-items: center;
  justify-content: center;
}
.salaInfo {
  width: 100%;
}
</style>
