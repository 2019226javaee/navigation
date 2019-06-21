<template>
  <div>
    <el-menu :default-active="$route.path" router="true"  class="el-menu-demo" mode="horizontal" @select="handleSelect" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
      <el-menu-item index="/components/warehouse/homepage">
        <i class="el-icon-menu"></i>
        <span slot="title" >首页</span>
      </el-menu-item>
      <el-menu-item index="/components/warehouse/search">查询路线</el-menu-item>
      <el-menu-item index="/components/warehouse/place">查询地点</el-menu-item>
      <el-menu-item index="/components/warehouse/location">获取当前位置</el-menu-item>
      <el-submenu index="2">
        <template slot="title">其他</template>
        <el-menu-item index="/components/warehouse/testv">测速</el-menu-item>
        <el-menu-item index="/components/warehouse/voice">语音导航</el-menu-item>
        <el-menu-item index="/components/warehouse/roadcondition">路段拥堵情况</el-menu-item>
      </el-submenu>
      <el-menu-item>
        <a href="https://www.amap.com/search?id=B01730JQWK&city=410184&geoobj=113.71147%7C34.612157%7C113.728006%7C34.618916&query_type=IDQ&query=%E4%B8%AD%E5%8E%9F%E5%B7%A5%E5%AD%A6%E9%99%A2%E9%BE%99%E6%B9%96%E6%A0%A1%E5%8C%BA&zoom=16" target="_blank">中工藏宝图</a>
      </el-menu-item>
      <el-menu-item  index="/components/warehouse/about">关于</el-menu-item>
    </el-menu>
    <el-main>
      <img src="../assets/logo.png" height="200" width="200" align="center"/>
    </el-main>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1'
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>
