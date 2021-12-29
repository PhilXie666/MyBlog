import Vue from 'vue'
import App from './App.vue'
import VueRouter from "vue-router";
import Login from "@/views/Login";
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import axios from "axios";
import Index from "@/views/Index";

// 富文本编辑器相关配置
import VueQuillEditor from "vue-quill-editor/src";
import '././assets/css/quill.core.css'
import '././assets/css/quill.snow.css'
import '././assets/css/quill.bubble.css'
import ArticleWriting from "@/views/ArticleWriting";
Vue.use(VueQuillEditor)

Vue.config.productionTip = false
Vue.use(VueRouter)
Vue.use(Antd)
Vue.prototype.$axios = axios

const router = new VueRouter({
  routes: [
    {path: "/login",component:Login},
    {
      path: '/index',
      component: Index,
    },
    {
      path: '/article_writing',
      component: ArticleWriting,
    }
  ],
  mode: 'history'
})

// Vue.prototype.$router = router


new Vue({
  render: h => h(App),
  router
}).$mount('#app')
