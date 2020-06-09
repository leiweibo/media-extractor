<template>
  <div class="workspace">
    <div class="workspace-box">
      <el-form ref="extractorForm" :model="extractorForm">
        <el-form-item class="input-field"  size="large">
          <el-input size="large" v-model="extractorForm.url"></el-input>
        </el-form-item>
    </el-form>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      extractorForm: {
        url: ''
      }
    }
  }
}
</script>
<style>
  .input-field {
    width: 800px;
    height: 60px;
  }
  .workspace {
    width: 100%;
    height: 100%;
    background: -webkit-image-set(url(~@/assets/images/login_bg@1x.png) 1x, url(~@/assets/images/login_bg@2x.png) 2x) center bottom no-repeat rgb(255, 255, 255);

    background-size: cover;
    position: fixed;
  }

  .workspace-box {
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    padding-top: 15%;
  }
</style>
