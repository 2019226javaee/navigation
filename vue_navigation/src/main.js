// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import Axios from 'axios'
import VueResource from 'vue-resource'  //请求http
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui' //element-ui的全部组件
import 'element-ui/lib/theme-chalk/index.css'//element-ui的css

Vue.use(ElementUI) //使用elementUI
Vue.use(Axios,VueAxios)
Vue.config.productionTip = false
Vue.prototype.$axios = Axios

Axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';



/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
