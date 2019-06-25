import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import about from '@/components/warehouse/about'
import homepage from '@/components/warehouse/homepage'
import search from '@/components/warehouse/search'
import place from '@/components/warehouse/place'
import placetable from '@/components/nvgtable/placetable'
import maptable from '@/components/nvgtable/maptable'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/components/warehouse/about',
      name: 'about',
      component: about
    },
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/components/warehouse/homepage',
      name: 'homepage',
      component: homepage
    },
    {
      path: '/components/warehouse/search',
      name: 'search',
      component: search
    },
    {
      path: '/components/warehouse/place',
      name: 'place',
      component: place
    },
    {
      path: '/components/nvgtable/placetable',
      name: 'placetable',
      component: placetable
    },
    {
      path: '/components/nvgtable/maptable',
      name: 'maptable',
      component: maptable
    }
  ]
})
