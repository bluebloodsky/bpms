import Vue from 'vue'
import Router from 'vue-router'

import PageHome from '@/views/PageHome'
import PageNotFind from '@/views/PageNotFind'
import PageDeskTop from '@/views/PageDeskTop'
import PageProgress from '@/views/PageProgress'
import PageConfig from '@/views/PageConfig'
import PageLog from '@/views/PageLog'
import PageUserManage from '@/views/PageUserManage'

Vue.use(Router)

export default new Router({
    routes: [{
        path: '/',
        redirect: '/home',
    }, {
        path: '/home',
        name: 'home',
        redirect: '/home/desktop',
        component: PageHome,
        children: [{
            path: 'not-find',
            component: PageNotFind
        }, {
            path: 'desktop',
            component: PageDeskTop
        }, {
            path: 'progress',
            component: PageProgress
        }, {
            path: 'config',
            component: PageConfig
        }, {
            path: 'log',
            component: PageLog
        }, {
            path: 'user-manage',
            component: PageUserManage
        }]
    }]
})