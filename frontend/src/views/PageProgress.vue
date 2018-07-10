<template>
  <section>
    <ul>
      <li v-for="i in 4" :key="i">
        <span>项目{{i}}</span>
        <section>
          <!-- <zl-steps :active="active" :steps="steps"></zl-steps> -->
          <el-steps :active="active" finish-status="success">
            <el-step :title="step.name_cn" v-for="step in steps" :key="step.name"></el-step>
          </el-steps>
        </section>
      </li>
    </ul>
  </section>
</template>
<script>
import { WORKFLOW_STEPS } from '@/json/steps'
import ZlSteps from '@/components/ZlSteps'
export default {
  components: { ZlSteps },
  data() {
    return {
      active: 4,
      steps: WORKFLOW_STEPS
    }
  }
}
</script>
<style scoped>
li {
  margin-top: 20px;
  position: relative;
  padding-right: 20px;
}

li span {
  position: absolute;
  top: 0;
  left: 20px;
  font-size: 16px;
}

li section {
  width: calc(100% -100px);
  margin-left: 100px;

  border-radius: 3px;
  /*border: 1px solid #CED4DF;*/
}
</style>