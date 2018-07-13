<template>
  <section class="wrapper">
    <ul>
      <li>现场工作人员</li>
      <li>人员角色</li>
      <li>联系电话</li>
    </ul>
    <ul>
      <li>李明</li>
      <li>负责人</li>
      <li>13708693825</li>
    </ul>
    <ul>
      <li>刘洋</li>
      <li>工作人员</li>
      <li>/</li>
    </ul>
    <ul>
      <li>陈思</li>
      <li>工作人员</li>
      <li>/</li>
    </ul>
  </section>
</template>
<script>
export default {
  data() {
    return {
      a: 1
    };
  },
  mounted() {

  }
};
</script>
<style scoped>
.wrapper {
  width: 100%;
  height: 100%;
  position: relative;
  background-color: #0A2C4F;
  color: #fff;
}

.wrapper>ul {
  height: 40px;
  line-height: 40px;
}

.wrapper>ul:nth-child(even) {
  background-color: #345278;
}

.wrapper li {
  width: 30%;
  text-align: center;
  float: left;
  font-size: 16px;
}
</style>