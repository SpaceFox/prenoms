import Vue from 'vue';
import AsyncComputed from 'vue-async-computed';
import './plugins/vuetify';
import App from './App.vue';
import router from './router';
import store from './store';
import './registerServiceWorker';

Vue.config.productionTip = false;

Vue.use(AsyncComputed);

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app');
