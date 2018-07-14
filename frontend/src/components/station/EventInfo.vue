<template>
  <section class="wrapper">
    <ul ref="content" :style="{top:top + 'px'}">
      <li v-for="event in events" :class="event.event_level">
        <a>{{event.event_time}} {{event.location}} | {{event.event_desc}}</a>
      </li>
    </ul>
  </section>
</template>
<script>
export default {
  data() {
    return {
      map: null,
      top : 5,
      events: [{
        event_time: '2017-06-02 11:00:00',
        event_level: 'info',
        location: '和胜变电站',
        event_desc: '工作负责人李明进入现场'
      }, {
        event_time: '2017-06-02 11:00:00',
        event_level: 'info',
        location: '和胜变电站',
        event_desc: '工作人员刘洋进入现场'
      }, {
        event_time: '2017-06-02 11:00:00',
        event_level: 'info',
        location: '和胜变电站',
        event_desc: '工作人员陈思进入现场'
      }, {
        event_time: '2017-06-02 11:30:00',
        event_level: 'alarm',
        location: '和胜变电站',
        event_desc: '工作人员陈思进入危险区域'
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
  background-color: #0A2C4F;
}

ul {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  transition: top 3s ease 0s;
}


li:nth-child(odd) {
  background-color: #345278;
}

a {
  display: inline-block;
  width: 100%;
  height: 40px;
  line-height: 40px;
  text-indent: 5px;
  font-size: 14px;
}

.alarm {
  color: #EA7E9E;
}

.info {
  color: #8F8C9F;
}
</style>