export const TABS_LIST = [
  { url: 'desktop', name: '工作台' },
  { url: 'create-pro', name: '新建项目', component: 'PageCreatePro' },
  { url: 'progress', name: '进度查看', component: 'PageProgress' },
  { url: 'log', name: '日志查看', component: 'PageLog' },
  { url: 'process-edit', name: '流程配置', component: 'PageProcessEdit' },
  { url: 'attr-config', name: '属性配置', component: 'PageAttrConfig' },
  { url: 'user-manage', name: '用户管理', component: 'PageUserManage' },
  { url: 'role-manage', name: '角色管理', component: 'PageRoleManage' },
]

export const WORKFLOW_STEPS = [{
  name: 'ORDER_RECEIVE',
  name_cn: '业务受理',
  key_link: true, //关键环节
  point: [20, 20]
}, {
  name: 'ORDER_REVIEW',
  name_cn: '协议审核',
  key_link: false,
  point: [20, 80]
}, {
  name: 'RECORD_EDIT',
  name_cn: '原始记录录入',
  key_link: true,
  point: [20, 140]
}, {
  name: 'RECORD_REVIEW',
  name_cn: '原始记录审核',
  key_link: false,
  point: [20, 200]
}, {
  name: 'ARCHIVE',
  name_cn: '归档',
  key_link: true,
  point: [20, 260]
}]