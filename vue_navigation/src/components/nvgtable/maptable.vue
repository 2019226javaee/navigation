<template>
  <el-table
    :data="tableData"
    height="650px"
    style="width: 100%">

    <el-table-column
      label="创建日期"
      width="300">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{date}}</span>
      </template>
    </el-table-column>
    <el-table-column  label="ID" width="200">
      <template slot-scope="scope">
        <span>{{ scope.row.id}}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="地图名称"
      width="250">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.name }}</span>
      </template>
    </el-table-column>



    <el-table-column
      label="地图面积"
      width="200">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.area }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="地点个数"
      width="200">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.placenum }}</span>
      </template>
    </el-table-column>

    <el-table-column label="操作">
      <template slot-scope="scope">
        <!--<el-button-->
        <!--size="mini"-->
        <!--@click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->

        <!-- Form -->
        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>

        <el-dialog title="地图增加" :visible.sync="dialogFormVisible">
          <el-form :model="Form">
            <el-form-item label="地图名称" :label-width="formLabelWidth">
              <el-input v-model="Form.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="地图面积" :label-width="formLabelWidth">
              <el-input v-model="Form.area" autocomplete="off">
              </el-input>
            </el-form-item>
            <el-form-item label="地点个数" :label-width="formLabelWidth">
              <el-input v-model="Form.placenum" autocomplete="off">
              </el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="postForm">确 定</el-button>
          </div>
        </el-dialog>



        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>


        <el-button
          type="success"
          size="mini"
          @click="update(scope.$index, scope.row)">修改</el-button>


      </template>
    </el-table-column>
  </el-table>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [],
        dialogTableVisible: false,
        dialogFormVisible: false,
        Form: {
          name: '',
          area: '',
          id: '',
          placenum: '',
          date:'',
        },
        formLabelWidth: '120px',
        date:new Date(),
      }
    },
    methods: {
      update(index,row) {
      },
      postForm() {
        const url = this.HOST + '/navigation-web/map/save';
        this.dialogFormVisible = false;
        var params = new URLSearchParams();
        params.append('name', this.Form.name);
        params.append('area', this.Form.area);
        params.append('placenum', this.Form.placenum);
        console.log(params);
        this.$axios({
          method: 'post',
          url: url,
          data: params
        })
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
        var placeId = row.id;
        console.log(placeId);
        this.$axios
          .delete(this.HOST + '/navigation-web/map/delete/' + placeId)
          .then(res => {
            console.log(res);
            this.tableData.splice(index, 1)
          })
          .catch(err => {
            console.log(err);
          });
      },
      //时间戳转化
      getLocalTime(nS) {
        return new Date(parseInt(nS) * 1000).toLocaleString().replace(/:\d{1,2}$/, ' ');
      },
      timeNow () {
        return moment().utc().format('YYYY年MM月DD日') + ' ' + moment().utc().format('dddd')
      }
    },
    created() {
      this.$axios.get(this.HOST+'/navigation-web/map/all')
        .then(response=>{
          console.log(response);
          this.tableData=response.data;
        })
        .catch(error=>{
          console.log(error);
          alert('网络错误，不能访问');
        })
    },
    mounted() {
      let _this = this;
      this.timer = setInterval(function() {
        _this.date = new Date().toLocaleString();
      });
    },
    beforeDestroy: function() {
      if (this.timer) {
        clearInterval(this.timer);
      }
    },
  }
</script>
