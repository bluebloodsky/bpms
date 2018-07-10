import Vue from 'vue'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

// import './assets/theme/index.css'

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