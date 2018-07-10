import Vue from 'vue'
import Router from 'vue-router'

import PageHome from '@/views/PageHome'
import PageNotFind from '@/views/PageNotFind'
import PageDeskTop from '@/views/PageDeskTop'
import PageProgress from '@/views/PageProgress'
import PageLog from '@/views/PageLog'
import PageUserManage from '@/views/PageUserManage'
import PageAttrConfig from '@/views/PageAttrConfig'
import PageRoleManage from '@/views/PageRoleManage'
import PageCreatePro from '@/views/PageCreatePro'
import PageProcessEdit from '@/views/PageProcessEdit'

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
            path: 'create-pro',
            component: PageCreatePro
        }, {
            path: 'progress',
            component: PageProgress
        }, {
            path: 'process-edit',
            component: PageProcessEdit
        }, {
            path: 'log',
            component: PageLog
        }, {
            path: 'attr-config',
            component: PageAttrConfig
        }, {
            path: 'log',
            component: PageLog
        }, {
            path: 'role-manage',
            component: PageRoleManage
        }, {
            path: 'user-manage',
            component: PageUserManage
        }]
    }]
})