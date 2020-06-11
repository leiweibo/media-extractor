<template>
  <div class="workspace">
    <div :class="searchClass">
      <el-form ref="extractorForm" :model="extractorForm">
        <el-form-item class="input-field"  size="large">
          <el-input size="large" v-model="extractorForm.url" @input="onMainPageUrlInput">
            <el-button slot="append" :icon="actionBtnIcon"></el-button>
          </el-input>
        </el-form-item>
      </el-form>
      <!-- <el-row :gutter="24">
        <el-col :span="12">
          <div class="video-view">
            <el-image :src="imgUrl"></el-image>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="video-view">
            <el-image :src="imgUrl"></el-image>
          </div>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="12">
          <div class="video-view">
            <el-image :src="imgUrl"></el-image>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="video-view">
            <el-image :src="imgUrl"></el-image>
          </div>
        </el-col>
      </el-row> -->

      <el-row :gutter="20">
        <el-col :span="8"><el-image :src="imgUrl"></el-image></el-col>
        <el-col :span="8"><el-image :src="imgUrl"></el-image></el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="8"><el-image :src="imgUrl"></el-image></el-col>
        <el-col :span="8"><el-image :src="imgUrl"></el-image></el-col>
      </el-row>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      extractorForm: {
        url: '123'
      },
      searchClass: 'workspace-box-searching',
      actionBtnIcon: 'el-icon-more',
      imgUrl: 'http://mmbiz.qpic.cn/mmbiz_jpg/aaVJqS7LaMIxrLeH1aCFvYSxcnfnib6jL3dPtaK4yyydJQMIPMAYVftBtAksBaMfCzKu2ciaX7xqa7SdLI7D5x6A/0?wx_fmt=jpeg'
    }
  },
  methods: {
    onMainPageUrlInput (value) {
      var state = this.getInputState(value)
      switch (state) {
        case 0:
          this.actionBtnIcon = 'el-icon-more'
          this.searchClass = 'workspace-box'
          break
        case 1:
          this.actionBtnIcon = 'el-icon-check'
          this.searchClass = 'workspace-box-searching'
          break
        case 2:
          this.actionBtnIcon = 'el-icon-close'
          this.searchClass = 'workspace-box'
          break
      }
    },
    getInputState (value) {
      if (value === '123') {
        return 1 // 正确
      } else if (value.length === 0) {
        return 0 // 无内容输入
      } else {
        return 2 // 内容有误
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
  .workspace-box-searching {
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    padding-top: 3%;
  }
  .video-view {
    width: 338px;
    height: 190px;
  }
  .el-row {
    margin-bottom: 20px;
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  img {
    vertical-align: middle;
    max-height: 100%;
    max-width: 100%;
  }

  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
</style>
