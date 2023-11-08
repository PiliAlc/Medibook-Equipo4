<template>
    <div class="user-profile">
      <div class="profile-picture" :style="{ backgroundImage: `url(${picture})` }"></div>
      <div class="container" @click="toggleMenu"><span></span><span></span><span></span></div>
      <div class="menu" :class="{ 'is-open': isOpen }">
        <ul>
          <li v-for="(option, index) in options" :key="index">
            <a href="#">{{ option }}</a>
          </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script>
export default {
  name: 'UserProfile',
  props: {
    picture: {
      type: String,
      required: false,
    },
    options: {
      type: Array,
      default: () => ['Administrar', 'Cerrar Sesión'],
    },
  },
  data() {
    return {
      isOpen: false,
    };
  },
  methods: {
    toggleMenu() {
      this.isOpen = !this.isOpen;
    },
  },
};
</script>
  
  <style scoped>
.user-profile {
  display: flex;
  align-items: center;
}

.profile-picture {
  width: 80px;
  height: 80px;
  border-radius: 50%;
  background-color: #ccc;
  border: 2px solid #000;
  background-size: cover;
  background-position: center;
}

.container{
	width: 50px;
  height: 50px;
  border-radius: 50%;
  background-size: cover;
  background-position: center;
	display: flex;
	align-items: center;
	justify-content: center;
	font-weight: bold;
	cursor: pointer;
}
span{
	width: 5px;
  height: 5px;
  border-radius: 50%;
  background-color: white;
  border: 2px solid #000;
  background-size: cover;
  background-position: center;
	display: flex;
	align-items: center;
	justify-content: center;
	font-weight: bold;
	margin-right: 1px;
}

.menu.is-open {
	display: block;
	width: 250px;
	height: 250px;
	position: absolute;
	left: 100%;
	top: 0%;
	transform: translate( -100%, 50%);
}

.menu {
  display: none;
  position: absolute;
  top: calc(100% + 10px);
  left: 0;
  z-index: 1;
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  padding: 10px;
}

.menu ul {
  list-style: none;
  margin: 0;
  padding: 0;
}

.menu li {
  margin-bottom: 5px;
}

.menu a {
  text-decoration: none;
  color: #000;
}
</style>