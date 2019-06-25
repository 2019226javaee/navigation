<template>
  <el-table
    :data="tableData"
    height="650px"
    style="width: 100%">
    <el-table-column
      label="日期"
      width="200">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ getLocalTime(scope.row.creatTime) }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="货品"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.goodName }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="负责人"
      width="160">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.dealByPersonName }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="重量"
      width="180">
      <template slot-scope="scope">
        <!--<i class="el-icon-time"></i>-->
        <span style="margin-left: 10px">{{ scope.row.dealMoney }}</span>
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <!--<el-button-->
        <!--size="mini"-->
        <!--@click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->

        <!-- Form -->
        <el-button type="primary" @click="dialogFormVisible = true" size="mini">新增</el-button>

        <el-dialog title="采购" :visible.sync="dialogFormVisible">
          <el-form :model="epdtForm">
            <el-form-item label="货品名称" :label-width="formLabelWidth">
              <el-input v-model="epdtForm.goodName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="负责人" :label-width="formLabelWidth">
              <el-input v-model="epdtForm.dealByPersonName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="重量" :label-width="formLabelWidth">
              <el-input v-model="epdtForm.dealMoney" autocomplete="off">
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
          @click="updateExpenditure(scope.$index, scope.row)">编辑</el-button>


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
        epdtForm: {
          goodName: '',
          dealByPersonName: '',
          dealMoney: ''
        },
        formLabelWidth: '120px',
        // epdtFormToUpdate:{
        //
        // }
      }
    },
    methods: {
      updateExpenditure(index,row) {
        this.$prompt('请输入更改的重量', '修改', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(({value}) => {
          this.$message({
            type: 'success',
            message: '已保存: '
          });
          console.log(row.id, value);


          this.$axios({
            method: "put",
            url: this.HOST + '/sun/expenditure/info?id=' + row.id + "&dealMoney=" + value,
            data:{

            },
          })
            .then(function (response) {

              console.log(response);

            })

            .catch(function (error) {

              console.log(error);

            });


        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });
        });
      },

      postForm() {
        const url = this.HOST + '/navigation-web/map/all';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('goodName', this.epdtForm.goodName);
        params.append('dealByPersonName', this.epdtForm.dealByPersonName);
        params.append('dealMoney', this.epdtForm.dealMoney);

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
        var expenditureId = row.id;
        console.log(expenditureId);
        this.$axios
          .delete(this.HOST + '/navigation-web/map/all' + expenditureId)
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
      }
    },
    created() {
      this.$axios.get(this.HOST + '/navigation-web/map/all')

      //then获取成功；response成功后的返回值（对象）

        .then(response => {

          console.log(response);

          this.tableData = response.data;

        })

        //获取失败

        .catch(error => {

          console.log(error);

          alert('网络错误，不能访问');

        })

    }
  }
</script>
