import { createRouter, createWebHashHistory } from 'vue-router'
import BankView from '../views/BankView.vue'
import LoginView from '../views/LoginView.vue'

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  {
    path: '/bank',
    name: 'bank',
    component: BankView
  },

]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
