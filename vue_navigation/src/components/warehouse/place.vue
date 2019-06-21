<template>
<div>
  <input id="txt" type="text"   placeholder="请输入查询的地点" v-model="postData" >
  <el-button class="login_btn" @click.native="message" type="primary" round :loading="isBtnLoading">查询</el-button>
</div>
</template>
<script>
    export default {
        data(){
          return{
            postData:'',
            isBtnLoading: false,
          }
        },
      created:function() {
      },
      methods: {
        message: function () {
          /* you can bind this from by this id(txt) */
          let content = document.getElementById("txt");
          let postData = {
            "text": content.value,
            /* here is transferring value of text */
          }
          alert('您要提交的数据为：' + postData.text)
          this.submits1(postData)
          /* invoking function(submits)
           *  if you change this order you may be meet the data's value miss
           *  or you can put this function into that(submit) function
           */
        },
        submits1: function (postData) {
          this.$axios({
            method: 'post',
            url: this.HOST + '/place/tt',
            data: postData
            /* parameter match  */
          }).then((res) => {
            console.log(res.data)
          }).catch(err => {
            console.log(err)
          })
        },
      }
    }
</script>

<style scoped>

</style>
