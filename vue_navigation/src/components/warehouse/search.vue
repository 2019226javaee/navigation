<template>
  <div>
    <input type="text"   placeholder="请输入起点" >
    <input type="text"   placeholder="请输入终点" >
    <el-button class="login_btn" @click.native="search" type="primary" round :loading="isBtnLoading">查询</el-button>
  </div>
</template>

<script>
  export default {
    name: "search"
  }
</script>

<style scoped>
  .qxs-ic_user {
    background-size: 13px 15px;
    background-position: 3%;
  }
</style>
