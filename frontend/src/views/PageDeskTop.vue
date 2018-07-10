<template>
  <section>
    <DashboardBox title="待办事件">
      <el-table :data="taskTodos_list" border @row-click="todoClick">
        <el-table-column type="index" width="60">
        </el-table-column>
        <el-table-column align="center" :prop="item.name" :label="item.caption" v-for="item in fields" :key="item.name">
        </el-table-column>
      </el-table>
    </DashboardBox>
  </section>
</template>
<script>
import DashboardBox from '@/components/DashboardBox';
import {TODO} from '@/json/project';
export default {
  components: { DashboardBox },
  data() {
    return {
      fields: [{
        name: 'pro_name',
        caption: '项目名称'
      },{
        name: 'task_num',
        caption: '工程号'
      },{
        name: 'pro_manager',
        caption: '项目经理'
      },{
        name: 'step',
        caption: '项目进度'
      }],
      taskTodos_list:TODO
    }
  },
  methods:{
    todoClick(row){
      console.log(row)
    }
  }

}
</script>
<style scoped></style>