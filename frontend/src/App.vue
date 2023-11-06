<template>
<!-- importo las fuentes -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">

  <HeaderPrincipal />
  <router-view></router-view>
  <LoaderMain />
  <FooterComponent />
  <PopUp />

</template>

<script>
import HeaderPrincipal from './components/HeaderPrincipal.vue';
import LoaderMain from './components/LoaderMain.vue';
import FooterComponent from './components/FooterComponent.vue';
import PopUp from './components/PopUp.vue';

export default {
  name: 'App',
  components: {
    HeaderPrincipal,
    LoaderMain,
    FooterComponent,
    PopUp,
  },
  data() {
    return {
    };
  },
  mounted() {
  },
}
</script>

<style>
#app {
  font-family: 'Poppins', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
*{
  box-sizing: border-box;
  padding: 0;
  margin: 0;
}
p{
  color: var(--text);
}

.oscuro,
.claro{
  transition: .5s ease-in-out;
}

.claro{
  --background: #15b4bc;
  --background2: #99DCDD;
  --text: #daecec;
  --text2: #605B5B;
  --border: 1px solid #0f8389;
  --shadow: 0px 1px 5px 1px #99dcdd;
  --oscuro: #0d7277;
}
.claro:hover{
  --background: #0f8389;
  --text: #daecec;
  --border: 1px solid #0d7277;
  --shadow: 0px 1px 5px 1px #daecec;
  --oscuro: #0d7277;
}

.oscuro{
  --background: #0f8389;
  --text: #daecec;
  --border: 1px solid #0d7277;
  --shadow: 0px 1px 5px 1px #daecec;
  --oscuro: #0d7277;
}
.oscuro:hover{
  --background: #15b4bc;
  --text: #daecec;
  --border: 1px solid #0f8389;
  --shadow: 0px 1px 5px 1px #99dcdd;
  --oscuro: #0d7277;
}
a{
  text-decoration: none;
  color: var(--text);
}
LoaderMain{
  height: 100%;
}
</style>
