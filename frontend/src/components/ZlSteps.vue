<template>
  <div class="steps">
    <div v-for="(step,index) in steps" :key="index" class="step">
      <div class="step-head">
        <div class="step-line"></div>
        <div class="step-icon">
          <i class="iconfont icon-right" v-if="index < active"></i>
          <span v-else>{{index + 1}}</span>
        </div>
      </div>
      <div class="step-main">
        {{step.name_cn}}
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    active: Number,
    steps: Array
  }

}
</script>
<style scoped>
.steps {
  width: 100%;
  height: 60px;
}

.step {
  float: left;
  width: 10%;
}

.step:last-child{
  width: 24px;
}

.step-head {
  height: 24px;
  line-height: 24px;
  position: relative;
}

.step-line {
  background-color: #fff;
  height: 2px;
  position: absolute;
  right: 0px;
  top: calc(50% - 1px);
  left: 28px;
  bottom: auto;
}

.step-icon {
  border: 2px solid #fff;
  width: 24px;
  height: 24px;
  border-radius: 50%;
  text-align: center;
  font-size: 14px;
  font-weight: 700;
}
.step-main{
  margin-top: 12px;
}

.finished{
  color: #67c23a;
}
</style>