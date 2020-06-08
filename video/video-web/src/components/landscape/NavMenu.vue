<template>
  <el-row class="container">
    <el-menu :default-active="activeIndex"
      router
      class="el-menu-demo"
      mode="horizontal"
      background-color="#ffffff"
      @select="handleSelect" >
      <el-menu-item index="basic_layout1">Basic Layout</el-menu-item>
      <el-menu-item index="basic_container1">Basic Container</el-menu-item>
    </el-menu>
  </el-row>
</template>

<script>
export default {
  data () {
    return {
      activeIndex: '1'
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>
