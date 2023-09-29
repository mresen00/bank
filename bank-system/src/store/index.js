import { createStore } from 'vuex'

export default createStore({
    //global variables (to use: this.$store.state.username;)
    state() {
        return {
            username: "",
        }
    },
    
    mutations: {
        setUsername(state, username) {
            state.username = username;
        },

    },
    getters: {
        getUsername(state) {
            return state.username;
        },
    },
    //methods to access global variables (to use: this.$store.dispatch("setUsername", this.username);)
    actions: {
        setUsername(context, username) {
            context.commit('setUsername', username);
      }  
    },
})