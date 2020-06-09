<template>
  <el-row class="container">
    <el-menu :default-active="activeIndex"
      router
      class="el-menu-demo"
      mode="horizontal"
      background-color="#ffffff"
      @select="handleSelect" >
      <!-- <el-menu-item index="basic_layout1">Basic Layout</el-menu-item>
      <el-menu-item index="basic_container1">Basic Container</el-menu-item> -->
      <div v-for="(item, index) in menu" :index="index" :key="index" class="el-menu--horizontal">
        <el-submenu v-if="item.sub" :index="item.id">
          <template slot="title">
            <span v-text="item.name"></span>
          </template>
          <el-menu-item-group class="over-hide" v-for="sub in item.sub" :key="sub.componentName">
            <el-menu-item :index="sub.componentName" v-text="sub.name">
            </el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-menu-item :index="item.componentName" v-text="item.name" v-if ="!item.sub" />
      </div>
      <!-- <el-submenu v-for="item in menu" :index="item.id" :key="item.id">
          <template slot="title">
            <span v-text="item.name"></span>
          </template>
          <el-menu-item-group class="over-hide" v-for="sub in item.sub" :key="sub.componentName">
            <el-menu-item :index="sub.componentName" v-text="sub.name">
            </el-menu-item>
          </el-menu-item-group>
        </el-submenu> -->
    </el-menu>
  </el-row>
</template>

<script>
import menu from '@/config/menu-config-landscape'

export default {
  data () {
    return {
      activeIndex: '1',
      menu: menu
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>
<style>
</style>
