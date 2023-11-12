import { createRouter, createWebHistory } from 'vue-router';

import BodyMain from './view/BodyMain.vue';
import LogIn from './view/LogIn.vue';
import SignUp from './view/SignUp.vue';
import CardDetail from './view/CardDetail'
import CardCategory from './view/CardCategory'
import AdministrarProducto from './view/AdministrarProducto'
import AgregarProducto from './view/AgregarProducto'
import AgregarCategoria from './view/AgregarCategoria'
import CardModify from './view/CardModify'
import UserInfo from './view/UserInfo'

const routes = [
  { path: '/', component: BodyMain },
  { path: '/login', component: LogIn },
  { path: '/signup', component: SignUp },
  { path: '/admin', component: AdministrarProducto },
  { path: '/admin/product', component: AgregarProducto },
  { path: '/admin/category', component: AgregarCategoria },
  { path: '/admin/user', component: UserInfo },
  { path: '/card-detail/:id', name: 'card-detail', component: CardDetail },
  { path: '/card-category/:id', name: 'card-category', component: CardCategory },
  { path: '/modify/:id', name: 'card-modify', component: CardModify },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
