<template>
  <div class="mainTable" v-for="card in cards" :key="card.id">
    <div class="info">
      <p class="id">{{ card.id }}</p>
      <p class="name">{{ card.name }}</p>
    </div>
    <div class="action">
      <router-link :to="{ name: 'card-modify', params: { id: card.id } }">
        <p>Modificar</p>
      </router-link>
      <p @click="recategorizeCard(card)">Recategorizar</p>
      <p @click="viewCharacteristics(card)">Características</p>
      <p @click="deleteCard(card)">Eliminar</p>
    </div>
  </div>
  <DataDialog @update-type="handleUpdateType"/>
</template>

<script>

import deleteMethods from '@/service/deleteMethod'
import getMethod from '@/service/getMethod'
import putMethod from '@/service/putMethod'
import util from '@/utils/utils'
import DataDialog from './DataDialog'

export default {
  name:'AdminCard',
  emits: ['update-cards'],
  components: {
    DataDialog,
  },
  props:{
    cards:{
      type:Array,
      default:()=>[],
    }
  },
  data() {
    return {
      cardId:null,
    };
  },
  methods:{
    async recategorizeCard(card) {
      util.cargarLoader("Cargando categorías")
      let typerooms = await getMethod.getTypeRooms()
      util.cargarLoader("")
      this.cardId = card.id 
      let dialog = {
        type: 'recategorize',
        categorys: typerooms,
        cancel: () => {
          dialog = {};
          this.$store.dispatch('setDialog', dialog);
        },
      }
      this.$store.dispatch('setDialog',dialog)
    },
    async handleUpdateType(id) {
      let dialog = {};
      this.$store.dispatch('setDialog', dialog);
      util.cargarLoader("Actualizando sala...")
      let typeroom = {
          id: id
        }
      let dataGet = {
        id:this.cardId,
        isId: true
      }
      let room = await getMethod.getRoom(dataGet)
      room.typeroom = typeroom
      const res = await putMethod.updateRoom(room)
      util.cargarLoader("")
      if (res == 'OK') {
        util.cargarPopUp("Sala recategorizada con éxito", "Gracias!")
      } else {
        util.cargarPopUp("Lo sentimo, ha ocurrido un error", "Error!")
      }
    },
    viewCharacteristics(card) {
      console.log('Características', card);
    },
    async deleteCard(card) {
      let dialog = {
        type: 'delete',
        texto: 'Está seguro que desea eliminar esta sala?',
        acept: async () =>{
          dialog = {}
          this.$store.dispatch('setDialog',dialog)
          util.cargarLoader("Eliminando sala")
          await deleteMethods.deleteRoom(card.id)
          const updatedRooms = await getMethod.getRooms();
          this.$emit('update-cards', updatedRooms);
          util.cargarLoader("")
        },
        cancel: ()=> {
          dialog = {}
          this.$store.dispatch('setDialog',dialog)
        }
      }
      this.$store.dispatch('setDialog',dialog)
    },
    
  }
}
</script>
<style scoped>
  .mainTable{
    width: 100%;
    height: 50px;
    display: flex;
    align-items: center;
    justify-content: space-around;
    border: 2px solid black;
    border-radius: 25px;
    margin: 10px 0;
  }
  .info{
    width: 35%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .id{
    width: 30%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .name{
    width: 70%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    border: 1px solid black;
    border-radius: 25px;
  }
  .action{
    width: 65%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: space-around;
  }
  .action p{
    cursor: pointer;
  }
</style>