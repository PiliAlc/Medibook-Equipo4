import { createStore } from "vuex";
import data from "./data";

export default createStore({
  state: {
    theme: "claro",
    loader: {
      cargando: false,
      textoCargando: "",
    },
    popup: {
      cargando: false,
      textoPopup: "",
      tituloPopup: "",
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
    setPopup(state, { isCargando, texto, titulo }) {
      state.popup.cargando = isCargando;
      state.popup.textoPopup = texto;
      state.popup.tituloPopup = titulo;
    },
    setData(state, data) {
      state.data = data;
    },
  },
  actions: {
    setTheme({ commit }, theme) {
      commit("setTheme", theme);
    },
    setCargando({ commit }, cargando) {
      commit("setCargando", cargando);
    },
    setPopup({ commit }, popup) {
      commit("setPopup", popup);
    },
    setData({ commit }, data) {
      commit("setData", data);
    },
  },
  getters: {
    getTheme: (state) => state.theme,
    getCargando: (state) => state.loader.cargando,
    getTextoCargando: (state) => state.loader.textoCargando,
    getTextoPopUp: (state) => state.popup.textoPopup,
    getTituloPopUp: (state) => state.popup.tituloPopup,
    getPopUp: (state) => state.popup.cargando,
    getData: (state) => state.data,
  },
});
