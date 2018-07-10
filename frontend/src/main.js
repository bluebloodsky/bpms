import Vue from 'vue'

import './assets/theme/index.css'
import ElementUI from 'element-ui'

import App from './App.vue'
import router from './router'
import store from './store'
import axios from './http'

Vue.config.productionTip = false

Vue.prototype.axios = axios
Vue.prototype.pre_url = '/home/'


Vue.use(ElementUI)

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')