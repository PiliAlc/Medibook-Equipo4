<template>
	<div class="container">
		<div v-for="card in cards" :key="card.id" :class="[theme, 'card']" >
			<img v-for="url in card.images" :key="url.id" :src="url.path" :alt="url.name">
			<div :class="[theme, 'info']">
				<h2> {{ card.name }} </h2>
				<p> {{ card.description }} </p>
				<router-link :to="{ name: 'card-detail', params: { id: card.id } }">
					<p>Detalle</p>
				</router-link>
			</div>
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
		data() {
			return {
				cards: [],
			};
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
				const categoryLength = this.$router.currentRoute.value.path.length
				const category = this.$router.currentRoute.value.path.slice(6,categoryLength)
				util.cargarLoader("Buscando salas...")
				this.cards = await getMethod.getRooms().filter( item => item.category.name == category )
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
    border: 1px solid #ccc;
    border-radius: 8px;
    margin: 10px;
    overflow: hidden;
    width: 300px;
  }
  
  .card img {
    width: 100%;
    height: 200px;
    object-fit: cover;
    border-radius: 8px 8px 0 0;
  }
  .info {
    padding: 10px;
  }
</style>
    