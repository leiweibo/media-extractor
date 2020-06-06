<template>
  <div class="login">
    <div class="login-box">
    <el-form ref="loginDataForm" :model="loginDataForm" label-width="90px" label-position="left">
      <el-form-item label="用户名" class="input-field">
        <el-input v-model="loginDataForm.userName"></el-input>
      </el-form-item>
      <el-form-item label="密码" class="input-field">
        <el-input v-model="loginDataForm.password"></el-input>
      </el-form-item>
      <el-form-item label="验证码" class="input-field" prop="captcha" >
        <el-row>
          <el-col :span="14">
            <el-input v-model="loginDataForm.captcha"
                      placeholder="验证码">
            </el-input>
          </el-col>
          <el-col :span="10"
                  class="login-captcha">
            <img :src="captchaPath"
                  @click="getCaptcha()"
                  alt="123123">
          </el-col>
        </el-row>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" class="item-btn">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      loginDataForm: {
        userName: '',
        password: '',
        captcha: ''
      },
      captchaPath: 'http://mall4j-admin.gz-yami.com/apis/captcha.jpg?uuid=ab8d0297-d391-47b4-8fef-0440edc34a93'
    }
  }
}
</script>
<style>
.login {
  width: 100%;
  height: 100%;
  background: #000;
  background-size: cover;
  position: fixed;
}

.login-box {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  padding-top: 15%;
}

.input-field {
  width: 510px;
}

.login-captcha {
  height: 40px;
}

.item-btn {
  margin-top: 20px;
  width: 100%;
  height: 40px;
}

.input-field input {
  height: 40px;
}

img {
  vertical-align: middle;
  max-height: 100%;
  max-width: 100%;
}
</style>
