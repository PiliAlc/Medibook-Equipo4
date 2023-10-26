<template>
	<div v-for=" card in cards" :key="card.id" :class="[theme, 'card']" >
		<img :src="card.url[0]" :alt="card.name">
		<div :class="[theme, 'info']">
			<h2> {{ card.name }} </h2>
			<p> {{ card.description }} </p>
			<router-link :to="{ name: 'card-detail', params: { id: card.id } }">
				<p>Detalle</p>
			</router-link>
		</div>
	</div>
</template>
    
<script>
	import data from '@/data';

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
			generarCards(){
				const categoryLength = this.$router.currentRoute.value.path.length
				const category = this.$router.currentRoute.value.path.slice(6,categoryLength)
				this.cards = data.filter( item => item.description == category )
			}
		}
	}
</script>
    
<style scoped>
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
    