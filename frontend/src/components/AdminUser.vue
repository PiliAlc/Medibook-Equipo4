<template>
    <div class="mainTable" v-for="user in users" :key="user.id">
      <div class="info">
        <p class="id">{{ user.id }}</p>
        <p class="name">{{ user.name }}</p>
        <p class="name">{{ user.roles[0].name }}</p>
      </div>
      <div class="action">
        <!-- <router-link :to="{ name: 'user-modify', params: { id: user.id }, props: {card: card} }">
          <p>Modificar</p>
        </router-link> -->
        <p @click="changeRol(user)">Rol</p>
      </div>
    </div>
    <DataDialog @update-rol="handleUpdateRol"/>
  </template>
  
  <script>
  
  import getMethod from '@/service/getMethod'
  import putMethod from '@/service/putMethod'
  import util from '@/utils/utils'
  import DataDialog from './DataDialog'
  
  export default {
    name:'AdminUser',
    emits: ['update-rol','update-users'],
    components: {
      DataDialog,
    },
    props:{
      users:{
        type:Array,
        default:()=>[],
      }
    },
    data() {
      return {
        userId: null,
      };
    },
    methods:{
      async changeRol(user) {
        this.userId = user.id
        let dialog = {
          type: 'rol',
          texto: 'Cambiar rol del usuario?',
          users: user,
          cancel: () => {
            dialog = {};
            this.$store.dispatch('setDialog', dialog);
          },
        }
        this.$store.dispatch('setDialog',dialog)
      },
      async handleUpdateRol(rol) {
        let dialog = {}
        this.$store.dispatch('setDialog', dialog)
        util.cargarLoader("Actualizando rol...")

        let user = await getMethod.getUser(this.userId,true)
        user.roles[0].name = rol
        const res = await putMethod.updateUser(user)
        util.cargarLoader("")
        if (res == "OK") {
          util.cargarPopUp("Rol asignado con éxito", "Gracias!")
          user = await getMethod.getUsers()
          this.$emit('update-user', user)
        } else {
          util.cargarPopUp("Lo sentimo, ha ocurrido un error", "Error!")
        }
      }
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