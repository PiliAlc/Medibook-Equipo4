import { createRouter, createWebHistory } from 'vue-router';

import BodyMain from './view/BodyMain.vue';
import LogIn from './view/LogIn.vue';
import SignUp from './view/SignUp.vue';
import CardDetail from './view/CardDetail'
import CardCategory from './view/CardCategory'
import AgregarProducto from './view/AgregarProducto'

const routes = [
  { path: '/', component: BodyMain },
  { path: '/login', component: LogIn },
  { path: '/signup', component: SignUp },
  { path: '/admin', component: AgregarProducto },
  { path: '/card/:id', name: 'card-detail', component: CardDetail },
  { path: '/card/:id', name: 'card-category', component: CardCategory },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
