<template>
  <section class="wrapper">
    <DashboardBox title="gis分布">
      <Gis></Gis>
    </DashboardBox>
    <DashboardBox title="实时轨迹显示">
      <Scene></Scene>
    </DashboardBox>
    <DashboardBox title="现场工作人员信息">
      <UserInfo></UserInfo>
    </DashboardBox>
     <DashboardBox title="实时告警信息">
      <EventInfo></EventInfo>
    </DashboardBox>
  </section>
</template>
<script>
import DashboardBox from '@/components/DashboardBox';
import Gis from '@/components/station/Gis'
import Scene from '@/components/station/Scene'
import UserInfo from '@/components/station/UserInfo'
import EventInfo from '@/components/station/EventInfo'
export default {
  components: { DashboardBox, Gis ,Scene ,UserInfo , EventInfo},

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
  height: 40%;
}

.wrapper article:nth-child(4) {
  position: absolute;
  left: 60%;
  top: 40%;
  width: 40%;
  height: 60%;
}
</style>