export const NAV_MENUS = [{
    name_cn: '项目管理',
    icon: 'icon-manage',
    items: [{
        name_cn: '新建项目',
        url: 'project-create'
    }, {
        name_cn: '进度查看',
        url: 'progress'
    }, {
        name_cn: '现场监控',
        url: 'station-monitor'
    }]
}, {
    name_cn: '日志查看',
    icon: 'icon-order',
    url: 'log'
}, {
    name_cn: '信息配置',
    icon: 'icon-setup',
    items: [{
        name_cn: '流程配置',
        url: 'process-edit'
    }, {
        name_cn: '属性配置',
        url: 'attr-config',
    }]
}, {
    name_cn: '权限管理',
    icon: 'icon-group',
    items: [{
        name_cn: '用户管理',
        url: 'user-manage'
    }, {
        name_cn: '角色管理',
        url: 'role-manage',
    }]
}]