<template>
  <section class="wrapper">
    <img src="@/assets/section.png">
    <div :style="{ left:person.positionX + '%' , top:person.positionY  + '%'}" v-for="person in persons">
      <button type="text">
        <i class="iconfont icon-circle"></i>
      </button>
    </div>
  </section>
</template>
<script>
export default {
  data() {
    return {
      map: null,
      persons: [{
        positionX: 5,
        positionY: 12
      }, {
        positionX: 50,
        positionY: 22
      }, {
        positionX: 55,
        positionY: 31
      }]
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
}

.wrapper>img {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
}

.iconfont {
  font-size: 20px;
  color: red;
}

.wrapper>div {
  position: absolute;
  line-height: 20px;
}
</style>