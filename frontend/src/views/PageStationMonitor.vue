<template>
  <section class="wrapper">
    <DashboardBox title="gis分布">
      <Gis></Gis>
    </DashboardBox>
    <DashboardBox title="现场实时状况">
      <Scene></Scene>
    </DashboardBox>
    <DashboardBox title="现场信息统计">
      
    </DashboardBox>
  </section>
</template>
<script>
import DashboardBox from '@/components/DashboardBox';
import Gis from '@/components/station/Gis'
import Scene from '@/components/station/Scene'
export default {
  components: { DashboardBox, Gis ,Scene},

}
</script>
<style scoped>
.wrapper article:nth-child(1) {
  position: absolute;
  left: 0;
  top: 0;
  width: 60%;
  height: 60%;
}

.wrapper article:nth-child(2) {
  position: absolute;
  left: 0;
  top: 60%;
  width: 60%;
  height: 40%;
}

.wrapper article:nth-child(3) {
  position: absolute;
  left: 60%;
  top: 0;
  width: 40%;
  height: 100%;
}
</style>