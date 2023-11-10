<template>
	<div class="container">
		<div v-for="card in cards" :key="card.id" :class="[theme, 'card']" >
			<router-link :to="{ name: 'card-detail', params: { id: card.id } }">
			<img :key="card.id" :src="card.images[0].path" :alt="card.name">
				<div :class="[theme, 'info']">
					<h2> {{ card.name }} </h2>
					<p> {{ card.description }} </p>
				</div>
			</router-link>
		</div>
	</div>
</template>
    
<script>
	import getMethod from '@/service/getMethod';
	import util from '@/utils/utils';

	export default {
		name:'CardCategory',
		components:{
		},
		props:{
		},
    data(){
      return {
        cards:[]
      }
    },
		computed: {
			theme() {
				return this.$store.getters.getTheme;
			},
		},
		created() {
			this.generarCards();
		},
		methods:{
			async generarCards(){
				util.cargarLoader("Buscando salas...")
				const categoryLength = this.$router.currentRoute.value.path.length
				const url = this.$router.currentRoute.value.path.slice(15,categoryLength)
        const category = decodeURIComponent(url)
				const rooms = await getMethod.getRooms()
				this.cards = rooms.filter( item => item.typeroom.name == category )
				util.cargarLoader("")
			}
		}
	}
</script>
    
<style scoped>
	.container{
		display: flex;
		align-items: center;
		justify-content: center;
		height: 100%;
		flex-wrap: wrap;
	}
	.card {
    margin: 1%;
    overflow: hidden;
    width: 390px;
		height: auto;
  }
  
  .card img {
    width: 100%;
    height: 300px;
    object-fit: cover;
    border-radius: 25px 25px 0 0;
    border: solid #605B5B;
  }
  .imgSimulation{
    width: 100%;
    height: 300px;
    background-color: #605B5B;
    border-radius: 25px 25px 0 0;
    border: solid #605B5B;
  }
  
  .info {
    position: relative;
    display: flex;
    justify-content: space-between;
    padding: 10px;
    background-color: var(--background2);
    border: solid var(--text2);
    margin-top: -25px;
    border-radius: 15px 15px 25px 25px;
    z-index: 2;
  }
  .info h2{
    margin-left: 5px;
    text-transform: capitalize;
    color: var(--text2);
  }
  .info p {
    color: var(--text2);
    margin-top: 6px;
    margin-right: 5px;
    text-decoration: underline;
  }
	@media only screen and (max-width:480px ){ 
  .card {
    margin: 1%;
    overflow: hidden;
    width: 46%;
    height: 200px;
  }

  .card img {
    height: 150px;
  }
  .imgSimulation{
    height: 150px;
  }
  .info {
    width: 100%;
    padding: 5px;
    margin-top: -18px;
    margin-left: 0px;
    height: 55px;
  }
  .info p {
    font-size: 12px;
    margin-top: 10px;
    margin-right: 0px;
    
  }
  div.info > p:first-of-type{
    margin-left: -120px;
    margin-top: 19px;
    
  }
  .info h2{
    font-size: 15px;
    margin-left: 5px;
  }
  }
</style>
    