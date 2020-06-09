<template>
  <div id="app">
    <el-container class="container">
      <el-header class="header">
        <navmenu />
      </el-header>
      <el-container>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>

  </div>
</template>

<script>
import NavMenu from '@/components/landscape/NavMenu'

export default {
  name: 'app',
  components: {
    'navmenu': NavMenu
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
  background-color: #fff;
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
.el-main {
  padding: 1px;
}
.el-input__inner {
  height: 60px;
  font-size:20px !important;
}
</style>
