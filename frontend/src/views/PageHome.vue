<template>
  <div>
    <header>
      <div class="logo">
        <img src="../assets/logo.png">
      </div>
      <h1>云服务安全边界管控系统</h1>
      <div class="right-info">
        <a class="user-info"> <img src="../assets/user.png"></a>
        <a class="toggle">
            <i class="iconfont icon-mail"></i>
            <span>10</span>
        </a>
        <div class="time">
          <strong>{{t}}</strong>
          <br/> {{d}}
        </div>
        <a href="#/login" class="exit"> <i class="iconfont icon-exit"></i></a>
      </div>
    </header>
    <aside>
      <header>导航</header>
      <el-menu @select="openTab">
        <template v-for="(menu,index) in nav_menus">
          <el-submenu :index="''+index" v-if="menu.items">
            <template slot="title">
              <i class="iconfont" :class="menu.icon" v-if="menu.icon"></i>
              <span slot="title" class="menu-title">{{menu.name_cn}}</span>
            </template>
            <el-menu-item :index="sub_menu.url" v-for="(sub_menu,sub_index) in menu.items">
              <i class="iconfont" :class="sub_menu.icon" v-if="sub_menu.icon"></i>
              <span slot="title" class="menu-title">{{sub_menu.name_cn}}</span>
            </el-menu-item>
          </el-submenu>
          <el-menu-item :index="menu.url" v-else>
            <i class="iconfont" :class="menu.icon" v-if="menu.icon"></i>
            <span slot="title" class="menu-title">{{menu.name_cn}}</span>
          </el-menu-item>
        </template>
      </el-menu>
    </aside>
    <section class="tab-box">
      <ul>
        <li v-for="(tab,tab_index) in tabs" :key="tab.url">
          <router-link :to="pre_url+tab.url">{{tab.name}}
            <button class="destroy" @click.prevent="closeTab(tab_index)" v-if="tab_index!==0"><i class="iconfont icon-close"></i></button>
          </router-link>
        </li>
      </ul>
      <transition>
        <keep-alive :include="includedComponents">
          <router-view></router-view>
        </keep-alive>
      </transition>
    </section>
  </div>
</template>
<script>
import PaddleMenu from '@/components/PaddleMenu'
import { Date } from '@/shared/extend'
import { NAV_MENUS } from '@/json/nav'
import {
  mapGetters
} from 'vuex'
export default {
  components: {
    PaddleMenu
  },
  data() {
    return {
      nav_menus: [],
      sub_menus: [],
      currentMenuIndex: 0,
      dt: new Date()
    }
  },
  created() {
    this.nav_menus = NAV_MENUS
    window.setInterval(() => {
      this.dt = new Date()
    }, 1000)

    let r = this.$route.path.match(/\/home\/(\S+)/)
    if (r && r.length > 1) {
      let tab_url = r[1]
      this.$store.commit('addTab', tab_url)
    }
  },
  computed: {
    t() {
      return this.dt.format("hh:mm:ss")
    },
    d() {
      return this.dt.format("yyyy-MM-dd")
    },
    ...mapGetters({
      user: 'user',
      tabs: 'tabs',
    }),
    includedComponents() {
      return this.tabs.map(tab => {
        return tab.component
      }).join(',')
    }
  },
  methods: {
    onNavClick(menu, index) {
      this.sub_menus = menu.sub_menus
      this.$router.push(menu.url)
      this.currentMenuIndex = index
    },
    openTab(url) {
      this.$store.commit('addTab', url)
      this.$router.push({ path: this.pre_url + url })
    },
    closeTab(tab_index) {
      if (this.$route.path == this.pre_url + this.tabs[tab_index].url) {
        this.$router.push({ path: this.pre_url + this.tabs[tab_index - 1].url })
      }
      this.$store.commit('removeTab', tab_index)
    },
    closeCurrentTab() {
      for (let tab_index = 0; tab_index < this.tabs.length; tab_index++) {
        if (this.$route.path == this.pre_url + this.tabs[tab_index].url) {
          this.$store.commit('removeTab', tab_index)
        }
      }
      this.$router.push({ path: this.pre_url + this.tabs[0].url })
    }
  }
}
</script>
<style scoped>
header {
  height: 70px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 30px;
}

h1 {
  color: #fff;
}

header nav li {
  display: inline-block;
  padding: 0 16px;
  text-align: center;
}

header nav a {
  color: #78B0C1;
}

header nav a:hover {
  color: #4FD4FF;
}

header nav a:hover i.iconfont {
  color: #fff;
}

header nav a i.iconfont {
  color: #8B9DB7;
  font-size: 44px;
}

.logo {
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.logo img {
  display: inline-block;
  height: 40px;
  margin-right: 10px;
}

.right-info {
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.user-info {
  display: inline-block;
  height: 64px;
  width: 64px;
  border-radius: 32px;
  overflow: hidden;
  background-color: #fff;
  margin-right: 20px;
}

.user-info img {
  height: 64px;
}

.time {
  color: #8B9DB7;
  font-size: 16px;
}

.time strong {
  font-size: 22px;
  font-weight: normal;
}

.toggle {
  position: relative;
  display: block;
  padding-right: 30px;
  color: #999c9e;
  height: 60px;
  line-height: 60px;
}

.toggle .iconfont {
  font-size: 30px;
}

.toggle span {
  position: absolute;
  right: 20px;
  top: 10px;
  line-height: 12px;
  background-color: #36c6d3;
  color: #FFF;
  font-size: 10px;
  font-weight: 600;
  padding: 3px 6px;
  border-radius: 12px;
  text-align: center;
}

.exit .iconfont {
  font-size: 30px;
  padding-left: 30px;
  color: #999c9e;
}

aside {
  position: absolute;
  left: 2px;
  right: auto;
  width: 200px;
  top: 80px;
  bottom: 2px;
  background-color: rgb(238, 245, 246);
  color: #3c3c3c;
  border: 1px solid #3f6aa1;
  border-radius: 5px;
}

aside>header {
  height: 36px;
  font-size: 16px;
  line-height: 36px;
  position: relative;
  border-bottom: 1px solid #3f6aa1;
  padding-left: 20px;
}

.tab-box {
  position: absolute;
  left: 204px;
  right: 2px;
  top: 80px;
  bottom: 2px;
  background-color: #0b3567;
  border: 1px solid #3f6aa1;
  border-radius: 5px;
}

.tab-box>ul {
  margin-left: 5px;
  font-size: 16px;
  height: 36px;
  line-height: 36px;
  overflow: hidden;
  position: relative;
}

.tab-box>ul li {
  float: left;
}

.tab-box>ul a {
  position: relative;
  height: 0;
  display: inline-block;
  padding: 0 30px;
  border-bottom: 36px solid #75a7c4;
  border-left: 18px solid transparent;
  border-right: 18px solid transparent;
  margin-left: -18px;
  color: #fff;
}

.tab-box>ul a:before {
  position: absolute;
  content: "";
  right: -18px;
  top: 0;
  border-bottom: 36px solid #ccc;
  border-right: 18px solid transparent;
  z-index: 2;
}

.tab-box>ul a:after {
  position: absolute;
  content: "";
  right: -17px;
  top: 1px;
  border-bottom: 35px solid #75a7c4;
  border-right: 17px solid transparent;
  z-index: 2;
}

.tab-box>ul a:hover {
  border-bottom: 36px solid #86b8d5;
}

.tab-box>ul a.router-link-active {
  border-bottom: 36px solid #cfdee9;
  color: #3c3c3c;
  z-index: 3;
}

.tab-box>ul a:hover::after {
  position: absolute;
  content: " ";
  right: -17px;
  top: 1px;
  border-bottom: 35px solid #86b8d5;
  border-right: 17px solid transparent;
}

.tab-box>ul a.router-link-active::after {
  position: absolute;
  content: " ";
  right: -17px;
  top: 1px;
  border-bottom: 35px solid #cfdee9;
  border-right: 17px solid transparent;
  z-index: 3;
}

.tab-box>section {
  position: absolute;
  top: 36px;
  bottom: 0;
  left: 5px;
  right: 0;
  overflow-y: auto;
  background-color: #cedde8;
  padding-top: 20px;
}

.destroy {
  position: absolute;
  right: 5px;
  top: 10px;
  margin: auto 0;
  border: none;
  padding: 0;
  background: transparent;
  color: #333;
  font-weight: bold;
}

.destroy:hover {
  border-radius: 5px;
  color: #C55C60;
}
</style>