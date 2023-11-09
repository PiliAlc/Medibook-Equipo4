<template>
  <div class="user-profile">
    <div class="contenedor">
      <h2>ADMINISTRACIÓN DE USUARIOS</h2>
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
        <AdminUser :users="users" @update-user="updateUsers" />
      </div>
    </div>
  </div>
</template>

<script>

import getMethod from "@/service/getMethod";
import util from "@/utils/utils";
import AdminUser from "@/components/AdminUser";

export default {
  name: 'UserInfo',
  emits: ['update-users'],
  components: {
    AdminUser,
  },
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    },
  },
  data() {
    return {
      users: []
    };
  },
  async created() {
    await this.generarUsers()
  },
  methods: {
    async generarUsers() {
      util.cargarLoader("Cargando usuarios...")
      this.users = await getMethod.getUsers()
      util.cargarLoader("")
    },
    async updateUsers(updateUsers) {
      this.users = updateUsers
    },
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