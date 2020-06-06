<template>
  <transition name="fade">
    <router-view></router-view>
  </transition>
</template>

<script>
export default {
  name: 'App'
}
</script>
<style>
body {
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  font-size: 14px;
  line-height: 1.15;
  color: #303133;
  background-color: #fff;
  margin: 0;
}
</style>
