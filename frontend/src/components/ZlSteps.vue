<template>
  <div class="steps" ref="container">
    <div v-for="(step,index) in steps" :key="index" class="step" :style="{width: index < steps.length -1 ? width + 'px' : '24px'}">
      <div class="step-head">
        <div class="step-line" :class="index<active-1?'step-line-finished':'step-line-unfinished'"></div>
        <div class="step-icon" :class="index==active?'in-process':index<active?'finished':'unfinished'">
          <i class="iconfont icon-right" v-if="index < active"></i>
          <span v-else>{{index + 1}}</span>
        </div>
      </div>
      <div class="step-main" :class="index==active?'in-process':index<active?'finished':'unfinished'">
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
  },
  data() {
    return {
      width: 200
    }
  },
  mounted() {
    if (this.steps && this.steps.length) {
      this.width = (this.$refs["container"].clientWidth - 24) / (this.steps.length - 1)
    }
    window.addEventListener("resize", () => {
      if (this.steps && this.steps.length) {
        this.width = (this.$refs["container"].clientWidth - 24) / (this.steps.length - 1)
      }
    });
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

.step:last-child {
  width: 24px;
}

.step-head {
  height: 24px;
  line-height: 24px;
  position: relative;
}

.step-line {
  height: 2px;
  position: absolute;
  right: 0px;
  top: calc(50% - 1px);
  left: 28px;
  bottom: auto;
}

.step-icon {
  border: 2px solid;
  width: 24px;
  height: 24px;
  border-radius: 50%;
  text-align: center;
  font-size: 14px;
  font-weight: 700;
  background-color: #fff;
}

.step-main {
  margin-top: 12px;
}

.finished {
  color: #67c23a;
  border-color: #67c23a;
}

.step-line-finished {
  background-color: #67c23a;
}

.unfinished {
  color: #c0c4cc;
  border-color: #c0c4cc;
}

.step-line-unfinished {
  background-color: #c0c4cc
}

.in-process {
  color: #303133;
  border-color: #303133;
}
</style>