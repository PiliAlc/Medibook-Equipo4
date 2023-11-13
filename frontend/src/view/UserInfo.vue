<template>
  <div class="user-profile">
    <div class="contenedor">
      <h2>ADMINISTRACIÓN DE USUARIOS</h2>
      <p>{{user.id}}</p>
      <p>{{user.name}}</p>
      <p>{{user.lastname}}</p>
      <p>{{user.username}}</p>
      <p>{{user.roles[0].name}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'UsersInfo',
  emits: ['update-users'],
  computed: {
    theme() {
      return this.$store.getters.getTheme;
    },
    user(){
      return this.$store.getters?.getUser
    }
  },
  data() {
    return {
      users: []
    };
  },
  created() {
  },
  methods: {
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