import { createStore } from "vuex";

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
    rooms: [],
    dialog:{},
    user:{},
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
    setRooms(state, room){
      state.rooms = room
    },
    setDialog(state, dialog){
      state.dialog = dialog
    },
    setUser(state, user){
      state.user = user
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
    setRooms({ commit }, room) {
      commit("setRooms", room);
    },
    setDialog({ commit }, dialog) {
      commit("setDialog", dialog);
    },
    setUser({ commit }, user) {
      commit("setUser", user);
    },
  },
  getters: {
    getTheme: state => state.theme,
    getCargando: state => state.loader.cargando,
    getTextoCargando: state => state.loader.textoCargando,
    getTextoPopUp: state => state.popup.textoPopup,
    getTituloPopUp: state => state.popup.tituloPopup,
    getPopUp: state => state.popup.cargando,
    getRooms: state => state.rooms,
    getDialog: state => state.dialog,
    getUser: state => state.user,
  },
});
