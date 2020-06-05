<template>
  <div class="login">
    <div class="login-box">
    <el-form ref="loginDataForm" :model="loginDataForm" label-width="80px" label-position="left">
      <el-form-item label="用户名" class="input-field">
        <el-input v-model="loginDataForm.userName"></el-input>
      </el-form-item>
      <el-form-item label="密码" class="input-field">
        <el-input v-model="loginDataForm.password"></el-input>
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
        password: ''
      }
    }
  }
}
</script>
<style>
.login {
  width: 100%;
  height: 100%;
}

.login .login-box {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  height: 100%;
  padding-top: 10%;
}

.input-field {
  width: 410px;
}
</style>
