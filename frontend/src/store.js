import { createStore } from 'vuex';
import data from './data'

export default createStore({
  state: {
    theme: 'claro',
    loader: {
      cargando: false,
      textoCargando: '',
    },
    data: data,
  },
  mutations: {
    setTheme(state, theme) {
      state.theme = theme;
    },
    setCargando(state, { isCargando, texto }) {
      state.loader.cargando = isCargando;
      state.loader.textoCargando = texto;
    },
    setData(state, data){
      state.data = data
    },
  },
  actions: {
    setTheme({ commit }, theme) {
      commit('setTheme', theme);
    },
    setCargando({ commit }, cargando) {
      commit('setCargando', cargando);
    },
    setData({ commit }, data) {
      commit('setData', data);
    },
  },
  getters: {
    getTheme: state => state.theme,
    getCargando: state => state.loader.cargando,
    getTextoCargando: state => state.loader.textoCargando,
    getData: state => state.data
  },
});
