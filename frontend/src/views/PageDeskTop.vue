<template>
    <section>
        <DashboardBox title="待办事件">
            <el-table :data="taskTodos_list" border @row-click="todoClick">
                <el-table-column type="index" width="60">
                </el-table-column>
                <el-table-column align="center" :prop="item.name" :label="item.caption" v-for="item in fields">
                </el-table-column>
            </el-table>
        </DashboardBox>
    </section>
</template>
<script>
import DashboardBox from '@/components/DashboardBox';

export default {
    components: { DashboardBox }

}
</script>
<style scoped></style>