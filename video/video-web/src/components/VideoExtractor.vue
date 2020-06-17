<template>
  <div class="workspace">
    <div :class="searchClass">
      <el-form ref="extractorForm" :model="extractorForm">
        <el-form-item class="input-field"  size="large">
          <el-input size="large" v-model="extractorForm.url" @input="onMainPageUrlInput">
            <el-button slot="append" :icon="actionBtnIcon" @click="submitForm('extractorForm')"></el-button>
          </el-input>
        </el-form-item>
      </el-form>
    </div>
    <el-scrollbar class="videoLayout" wrap-class="default-scrollbar__wrap"  view-class="p20-scrollbar__view" v-if="videoLayoutVisible">
      <el-row :gutter="20">
        <el-col :span="8" :offset="0" v-for="(item, index) in videoUrls" :key="index">
          <video controls="" autoplay="false" name="media"><source :src="item.url" type="video/mp4"></video>
        </el-col>
      </el-row>
    </el-scrollbar>
  </div>
</template>
<script>
export default {
  data () {
    return {
      extractorForm: {
        url: 'https://mp.weixin.qq.com/s/C4vorgQHz79XaBwa8pJRRg'
      },
      searchClass: 'workspace-box',
      actionBtnIcon: 'el-icon-more',
      imgUrl: 'http://mmbiz.qpic.cn/mmbiz_jpg/aaVJqS7LaMIxrLeH1aCFvYSxcnfnib6jL3dPtaK4yyydJQMIPMAYVftBtAksBaMfCzKu2ciaX7xqa7SdLI7D5x6A/0?wx_fmt=jpeg',
      videoLayoutVisible: false,
      endPoint: '/getVideoUrls',
      videoUrls: ''
    }
  },
  methods: {
    submitForm (formName) {
      const formData = {
        url: this.extractorForm.url
      }
      console.log(formData)
      this.modal_loading = this.$loading({
        lock: true,
        text: '提取中...',
        spinner: 'el-icon-loading',
        background: 'rgba(0,0,0,0.7)'
      })

      var that = this
      this.$axios.post(this.endPoint, formData).then(resp => {
        that.modal_loading.close()
        let result = resp.data
        if (result.code === 200) {
          that.videoLayoutVisible = true
          that.videoUrls = result.data
        } else {
          that.$message({
            type: 'error',
            showClose: true,
            duration: 60000,
            message: result.info
          })
        }
      })
    },
    onMainPageUrlInput (value) {
      var state = this.getInputState(value)
      switch (state) {
        case 0:
          this.actionBtnIcon = 'el-icon-more'
          this.searchClass = 'workspace-box'
          this.videoLayoutVisible = false
          break
        case 1:
          this.actionBtnIcon = 'el-icon-check'
          this.searchClass = 'workspace-box-searching'
          this.videoLayoutVisible = false
          break
        case 2:
          this.actionBtnIcon = 'el-icon-check'
          this.searchClass = 'workspace-box-searching'
          this.videoLayoutVisible = false
          break
      }
    },
    getInputState (value) {
      if (value.length > 0) {
        return 1 // 正确
      } else if (value.length === 0) {
        return 0 // 无内容输入
      } else {
        return 2 // 内容有误
      }
    },
    load () {
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
  .videoLayout {
    position: absolute;
    margin-top: 10%;
    width: 1200px;
    height: 720px;
    left: 50%;
    transform: translateX(-50%);
  }
  .infinite-list {
    height: 100%;
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
  video {
    max-height: 100%;
    max-width: 100%;
  }

  .el-row {
    margin-bottom: 20px;
  }
  .el-col {
    border-radius: 4px;
  }

  .el-main {
  width: 100%;
  height: 100%;
  padding: 0;
}
.el-main.default {
  height: auto;
  padding: 20px;
}
.default-scrollbar {
  width: 100%;
  height: 100%;
}
.flex-scrollbar {
  width: auto;
  height: auto;
  -webkit-box-flex: 1;
  -ms-flex: 1;
  flex: 1;
}
.el-scrollbar__wrap.default-scrollbar__wrap {
  overflow-x: auto;
}
.el-scrollbar__view.default-scrollbar__view {}
.el-scrollbar__view.p20-scrollbar__view {
  padding: 20px;
  box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  -o-box-sizing: border-box;
  -ms-box-sizing: border-box;
}
</style>
