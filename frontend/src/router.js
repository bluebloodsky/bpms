import Vue from 'vue'
import Router from 'vue-router'

import PageHome from '@/views/PageHome'
import PageNotFind from '@/views/PageNotFind'
import PageDeskTop from '@/views/PageDeskTop'
import PageProgress from '@/views/PageProgress'
import PageStationMonitor from '@/views/PageStationMonitor'
import PageLog from '@/views/PageLog'
import PageUserManage from '@/views/PageUserManage'
import PageAttrConfig from '@/views/PageAttrConfig'
import PageRoleManage from '@/views/PageRoleManage'
import PageProjectCreate from '@/views/PageProjectCreate'
import PageProcessEdit from '@/views/PageProcessEdit'
import PageProcessHandle from '@/views/PageProcessHandle'


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
            path: 'project-create',
            component: PageProjectCreate
        }, {
            path: 'process-handle',
            component: PageProcessHandle
        }, {
            path: 'progress',
            component: PageProgress
        }, {
            path: 'station-monitor',
            component:PageStationMonitor 
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