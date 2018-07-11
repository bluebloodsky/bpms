<template>
  <section>
    <div class="box">
      <header>
        <span>基本信息</span>
      </header>
      <section>
        <AttrRender :attr="attr" v-model="baseInfo[attr.name]" v-for="attr in baseAttrs" :key="attr.name"></AttrRender>
      </section>
    </div>
    <div class="box">
      <header>
        <span>人员分配</span>
      </header>
      <section>
        <AttrRender :attr="attr" v-model="personInfo[attr.name]" v-for="attr in proPersonAttrs" :key="attr.name"></AttrRender>
      </section>
    </div>
    <div class="btns">
      <button class="button-primary">提交</button>
      <button>重置</button>
    </div>
  </section>
</template>
<script>
import AttrRender from '../components/AttrRender'
import { BASE_ATTRS } from '@/json/attr'

import { PRO_PERSON_ATTRS } from '@/json/attr'
export default {
  name: 'PageProjectCreate',
  components: { AttrRender },
  data() {
    return {
      baseAttrs: BASE_ATTRS,
      proPersonAttrs: PRO_PERSON_ATTRS,
      baseInfo: {},
      personInfo: {}
    }
  }
}
</script>
<style scoped>
.box {
  margin: 0 10px;
  border: 1px solid #9c9c9c;
  border-top: none;
}

.box:first-child {
  border-top: 1px solid #9c9c9c;
}

.box>header {
  height: 35px;
  text-align: left;
  line-height: 35px;
  font-size: 16px;
  padding-left: 10px;
  border-bottom: 1px solid #9c9c9c;
  background-color: #dfecec;
}

.box>section {
  padding: 10px;
}

.btns {
  text-align: right;
  margin-top: 10px;
  margin-right: 30px;
}

.btns button {
  background-color: #F8F8F8;
  height: 40px;
  width: 80px;
  font-size: 18px;
  color: #fff;
  border-style: solid;
  border-radius: 10px;
  margin-right: 10px;
  color: #000;
}

.btns .button-primary {
  background-color: #1AAD19;
  width: 120px;
  color: #fff;
}
</style>