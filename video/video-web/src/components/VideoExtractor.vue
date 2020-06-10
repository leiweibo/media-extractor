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
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      extractorForm: {
        url: ''
      },
      searchClass: 'workspace-box',
      actionBtnIcon: 'el-icon-more'
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
</style>
