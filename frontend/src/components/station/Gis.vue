<template>
  <section ref="container"></section>
</template>
<script>
export default {
  data() {
    return {
      map: null,
      points: [
        [114.447257, 30.496942],
        [114.500266, 30.445063],
        [114.448266, 30.405063]
      ]
    };
  },
  mounted() {
    this.map = new BMap.Map(this.$refs["container"], {
      mapType: BMAP_HYBRID_MAP
    });
        // 创建点坐标  
    this.map.centerAndZoom(new BMap.Point(114.49639, 30.474205), 12)
    this.map.setMapStyle({ style: "light" })
    this.map.enableScrollWheelZoom(true)


    this.points.map(point => {
      let circle = new BMap.Circle(new BMap.Point(point[0], point[1]), 300, { strokeColor: 'red', fillColor: "red", strokeWeight: 2, fillOpacity: 1 });
      this.map.addOverlay(circle);
    })

  }
};
</script>
<style scoped>
section {
  width: 100%;
  height: 100%;
}
</style>