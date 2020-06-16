// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import axios from 'axios'
import router from './router'
// 将element组件的引用均放在element-ui/index.js里面
import './element-ui'

Vue.config.productionTip = false

axios.defaults.baseURL = 'http://localhost:8080'
Vue.prototype.$axios = axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
