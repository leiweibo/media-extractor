<template>
  <div id="app">
    <el-container class="container">
      <el-header class="header">
        <vheader />
      </el-header>
      <el-container>
        <el-aside class="aside">
          <navmenu></navmenu>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>

  </div>
</template>

<script>
import NavMenu from '@/components/NavMenu'
import Header from '@/components/Header'

export default {
  name: 'app',
  components: {
    'navmenu': NavMenu,
    'vheader': Header
  }
}

</script>

<style>
html,
body {
    height: 100%;
}
#app {
    height: 100%;
}
.header {
  background-color: #409EFF;
  color: #fff;
  line-height: 60px;
}
.aside {
    height: 100%;
    width: 15%;
    min-width: 200px;
    max-width: 240px;
}
.container {
    height: 100%;
}
</style>
