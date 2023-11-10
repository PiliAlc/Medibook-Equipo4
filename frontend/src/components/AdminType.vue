<template>
  <div class="mainTable" v-for="card in cards" :key="card.id">
    <div class="info">
      <p class="id">{{ card.id }}</p>
      <p class="name">{{ card.name }}</p>
    </div>
    <div class="action">
      <p @click="modifyCard(card)">Modificar</p>
      <p @click="deleteCard(card)">Eliminar</p>
    </div>
  </div>
  <DataDialog @update-type="handleUpdateType"/>
</template>

<script>

import deleteMethods from '@/service/deleteMethod'
import getMethod from '@/service/getMethod'
import util from '@/utils/utils'
import DataDialog from './DataDialog'

export default {
  name:'AdminType',
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
  methods:{
    modifyCard(card) {
      console.log('Modificar', card);
    },
    async deleteCard(card) {
      let dialog = {
        type: 'delete',
        texto: 'Está seguro que desea eliminar esta categoría?',
        acept: async () =>{
          dialog = {}
          this.$store.dispatch('setDialog',dialog)
          util.cargarLoader("Eliminando sala")
          await deleteMethods.deleteTypeRoom(card.id)
          const updatedRooms = await getMethod.getTypeRooms();
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