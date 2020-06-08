import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Login from '@/view/Login'
import Main from '@/view/Main'
import MainLandscape from '@/view/Main-Landscape'

Vue.use(Router)

export default new Router({
  mode: 'hash',
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/main',
      name: 'Main',
      component: Main
    },
    {
      path: 'menu1',
      name: 'menu1',
      component: Main,
      children: [
        {
          path: '/basic_container',
          name: 'BasicContainer',
          component: () => import('@/components/tmp/BasicContainer')
        },
        {
          path: '/basic_layout',
          name: 'BasicLayout',
          component: () => import('@/components/tmp/BasicLayout')
        }
      ]
    },
    {
      path: 'menu2',
      name: 'menu2',
      component: Main,
      children: [
        {
          path: '/form_checkbox',
          name: 'FormCheckBox',
          component: () => import('@/components/tmp/FormCheckbox')
        },
        {
          path: '/form_radio',
          name: 'FormRadio',
          component: () => import('@/components/tmp/FormRadio')
        }
      ]
    },
    {
      path: '/main-landscape',
      name: 'MainLandScape',
      component: MainLandscape
    },
    {
      path: 'menu1',
      name: 'menu1',
      component: MainLandscape,
      children: [
        {
          path: '/basic_container1',
          name: 'BasicContainer',
          component: () => import('@/components/tmp/BasicContainer')
        },
        {
          path: '/basic_layout1',
          name: 'BasicLayout',
          component: () => import('@/components/tmp/BasicLayout')
        }
      ]
    }
  ]
})
