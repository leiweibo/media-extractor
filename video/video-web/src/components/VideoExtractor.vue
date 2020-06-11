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
    <el-scrollbar class="videoLayout" wrap-class="default-scrollbar__wrap"  view-class="p20-scrollbar__view" v-if="videoLayoutVisible">
      <el-row :gutter="20">
        <el-col :span="8">
          <video controls="" justify="space-between" autoplay="false" name="media"><source src="http://mpvideo.qpic.cn/0bf25aaasaaaqaajmgotafpfb2gdbhuaacia.f10003.mp4?dis_k=9816269c1500c66bc34399d75379d039&dis_t=1591881041" type="video/mp4"></video>
        </el-col>
        <el-col :span="8">
          <video controls="" autoplay="false" name="media"><source src="http://vhotakamai.video.gtimg.com/m0567i1j1pc.m701.mp4?vkey=D5B68F02976CC3D64F79E31C9E81316E1B5B4851C80F762B1D798E6BE3F4B79D2EF322DF9C839F764CAA04F090DDC427CE20AD624FD473E648F68C975623F8F19777E6358A614F0BB65AA2AA0D7C4DFB5FC46327B754BBAB5C53E07FCC967A8A26A90F25833E53E26394EA083C666105" type="video/mp4"></video>
        </el-col>
        <el-col :span="8">
          <video controls="" autoplay="false" name="media"><source src="http://vhotakamai.video.gtimg.com/c0343qal5pq.m701.mp4?vkey=40AF4910A231D39B131E40E0208CC62EC4C760F9EDA85232862414664525751CD7FFB9F7ACD77DCF1F8F3255FFCBED6B57BC360AFE21BEAC7BA416B0BBCDEA97C991139BCA38A5CE89860FCD5B6B317CEEF7D4B8F79A41076B01400FC640CC024DFBD068E657242C3AC02D0D0A6302C9" type="video/mp4"></video>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="8">
          <video controls="" justify="space-between" autoplay="false" name="media"><source src="http://mpvideo.qpic.cn/0bf25aaasaaaqaajmgotafpfb2gdbhuaacia.f10003.mp4?dis_k=9816269c1500c66bc34399d75379d039&dis_t=1591881041" type="video/mp4"></video>
        </el-col>
        <el-col :span="8">
          <video controls="" autoplay="false" name="media"><source src="http://vhotakamai.video.gtimg.com/m0567i1j1pc.m701.mp4?vkey=D5B68F02976CC3D64F79E31C9E81316E1B5B4851C80F762B1D798E6BE3F4B79D2EF322DF9C839F764CAA04F090DDC427CE20AD624FD473E648F68C975623F8F19777E6358A614F0BB65AA2AA0D7C4DFB5FC46327B754BBAB5C53E07FCC967A8A26A90F25833E53E26394EA083C666105" type="video/mp4"></video>
        </el-col>
        <el-col :span="8">
          <video controls="" autoplay="false" name="media"><source src="http://vhotakamai.video.gtimg.com/c0343qal5pq.m701.mp4?vkey=40AF4910A231D39B131E40E0208CC62EC4C760F9EDA85232862414664525751CD7FFB9F7ACD77DCF1F8F3255FFCBED6B57BC360AFE21BEAC7BA416B0BBCDEA97C991139BCA38A5CE89860FCD5B6B317CEEF7D4B8F79A41076B01400FC640CC024DFBD068E657242C3AC02D0D0A6302C9" type="video/mp4"></video>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="8">
          <video controls="" justify="space-between" autoplay="false" name="media"><source src="http://mpvideo.qpic.cn/0bf25aaasaaaqaajmgotafpfb2gdbhuaacia.f10003.mp4?dis_k=9816269c1500c66bc34399d75379d039&dis_t=1591881041" type="video/mp4"></video>
        </el-col>
        <el-col :span="8">
          <video controls="" autoplay="false" name="media"><source src="http://vhotakamai.video.gtimg.com/m0567i1j1pc.m701.mp4?vkey=D5B68F02976CC3D64F79E31C9E81316E1B5B4851C80F762B1D798E6BE3F4B79D2EF322DF9C839F764CAA04F090DDC427CE20AD624FD473E648F68C975623F8F19777E6358A614F0BB65AA2AA0D7C4DFB5FC46327B754BBAB5C53E07FCC967A8A26A90F25833E53E26394EA083C666105" type="video/mp4"></video>
        </el-col>
        <el-col :span="8">
          <video controls="" autoplay="false" name="media"><source src="http://vhotakamai.video.gtimg.com/c0343qal5pq.m701.mp4?vkey=40AF4910A231D39B131E40E0208CC62EC4C760F9EDA85232862414664525751CD7FFB9F7ACD77DCF1F8F3255FFCBED6B57BC360AFE21BEAC7BA416B0BBCDEA97C991139BCA38A5CE89860FCD5B6B317CEEF7D4B8F79A41076B01400FC640CC024DFBD068E657242C3AC02D0D0A6302C9" type="video/mp4"></video>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="8">
          <video controls="" justify="space-between" autoplay="false" name="media"><source src="http://mpvideo.qpic.cn/0bf25aaasaaaqaajmgotafpfb2gdbhuaacia.f10003.mp4?dis_k=9816269c1500c66bc34399d75379d039&dis_t=1591881041" type="video/mp4"></video>
        </el-col>
        <el-col :span="8">
          <video controls="" autoplay="false" name="media"><source src="http://vhotakamai.video.gtimg.com/m0567i1j1pc.m701.mp4?vkey=D5B68F02976CC3D64F79E31C9E81316E1B5B4851C80F762B1D798E6BE3F4B79D2EF322DF9C839F764CAA04F090DDC427CE20AD624FD473E648F68C975623F8F19777E6358A614F0BB65AA2AA0D7C4DFB5FC46327B754BBAB5C53E07FCC967A8A26A90F25833E53E26394EA083C666105" type="video/mp4"></video>
        </el-col>
        <el-col :span="8">
          <video controls="" autoplay="false" name="media"><source src="http://vhotakamai.video.gtimg.com/c0343qal5pq.m701.mp4?vkey=40AF4910A231D39B131E40E0208CC62EC4C760F9EDA85232862414664525751CD7FFB9F7ACD77DCF1F8F3255FFCBED6B57BC360AFE21BEAC7BA416B0BBCDEA97C991139BCA38A5CE89860FCD5B6B317CEEF7D4B8F79A41076B01400FC640CC024DFBD068E657242C3AC02D0D0A6302C9" type="video/mp4"></video>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="8">
          <video controls="" justify="space-between" autoplay="false" name="media"><source src="http://mpvideo.qpic.cn/0bf25aaasaaaqaajmgotafpfb2gdbhuaacia.f10003.mp4?dis_k=9816269c1500c66bc34399d75379d039&dis_t=1591881041" type="video/mp4"></video>
        </el-col>
        <el-col :span="8">
          <video controls="" autoplay="false" name="media"><source src="http://vhotakamai.video.gtimg.com/m0567i1j1pc.m701.mp4?vkey=D5B68F02976CC3D64F79E31C9E81316E1B5B4851C80F762B1D798E6BE3F4B79D2EF322DF9C839F764CAA04F090DDC427CE20AD624FD473E648F68C975623F8F19777E6358A614F0BB65AA2AA0D7C4DFB5FC46327B754BBAB5C53E07FCC967A8A26A90F25833E53E26394EA083C666105" type="video/mp4"></video>
        </el-col>
        <el-col :span="8">
          <video controls="" autoplay="false" name="media"><source src="http://vhotakamai.video.gtimg.com/c0343qal5pq.m701.mp4?vkey=40AF4910A231D39B131E40E0208CC62EC4C760F9EDA85232862414664525751CD7FFB9F7ACD77DCF1F8F3255FFCBED6B57BC360AFE21BEAC7BA416B0BBCDEA97C991139BCA38A5CE89860FCD5B6B317CEEF7D4B8F79A41076B01400FC640CC024DFBD068E657242C3AC02D0D0A6302C9" type="video/mp4"></video>
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
        url: '123'
      },
      searchClass: 'workspace-box-searching',
      actionBtnIcon: 'el-icon-more',
      imgUrl: 'http://mmbiz.qpic.cn/mmbiz_jpg/aaVJqS7LaMIxrLeH1aCFvYSxcnfnib6jL3dPtaK4yyydJQMIPMAYVftBtAksBaMfCzKu2ciaX7xqa7SdLI7D5x6A/0?wx_fmt=jpeg',
      videoLayoutVisible: false
    }
  },
  methods: {
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
          this.videoLayoutVisible = true
          break
        case 2:
          this.actionBtnIcon = 'el-icon-close'
          this.searchClass = 'workspace-box'
          this.videoLayoutVisible = false
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
