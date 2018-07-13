<template>
  <section>
    <div class="info">
      <span>用户名</span>
      <input v-model="userName" placeholder="请输入用户名">
    </div>
    <div class="info">
      <span>密码</span>
      <input v-model="password" placeholder="请输入用户名" type="password">
    </div>
    <div class="btns" @click="login">
      <button class="button-primary">登录</button>
    </div>
  </section>
</template>
<script>
export default {
  data() {
    return {
      userName: '',
      password: ''
    }
  },
  methods: {
    login() {
      this.$router.push({ path: '/home' })
    }
  }
}
</script>
<style scoped>
section {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 300px;
  height: 200px;
  transform: translate(-50%, -50%);
  font-size: 20px;
  line-height: 20px;
  background-color: #d0dee9;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
  border-radius: 10px;
  padding: 20px;
}

.info {
  width: 250px;
  position: relative;
  padding-left: 120px;
}

.info span {
  position: absolute;
  top: 50%;
  left: 50px;
  transform: translateY(-50%);
  width: 150px;
  /*Flex布局*/
  text-align: left;
  font-size: 18px;
}

input {
  height: 30px;
  padding-left: 5px;
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
  width: 150px;
  color: #fff;
}
</style>