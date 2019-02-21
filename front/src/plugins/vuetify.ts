import Vue from 'vue';
import Vuetify from 'vuetify/lib';
import 'vuetify/src/stylus/app.styl';
import fr from 'vuetify/src/locale/fr';

Vue.use(Vuetify, {
  iconfont: 'fa',
  lang: {
    locales: { fr },
    current: 'fr',
  },
});
