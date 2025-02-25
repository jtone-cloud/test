<template>
  <div
    :style="{
      width: '100%',
      padding: '30px 7% 40px',
      margin: '0px auto',
      position: 'relative',
      background: '#fff',
    }"
  >
    <el-form
      :style="{
        border: '1px solid #eee',
        width: '100%',
        padding: '30px',
        position: 'relative',
        background: '#fcfcfc',
      }"
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="180px"
    >
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="装修公司名称"
        prop="gongsimingcheng"
      >
        <el-input
          v-model="ruleForm.gongsimingcheng"
          placeholder="装修公司名称"
          clearable
          :disabled="false || ro.gongsimingcheng"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="负责人"
        prop="fuzeren"
      >
        <el-input
          v-model="ruleForm.fuzeren"
          placeholder="负责人"
          clearable
          :disabled="false || ro.fuzeren"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="装修公司封面"
        v-if="type != 'cross' || (type == 'cross' && !ro.gongsifengmian)"
        prop="gongsifengmian"
      >
        <file-upload
          tip="点击上传装修公司封面"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.gongsifengmian ? ruleForm.gongsifengmian : ''"
          @change="gongsifengmianUploadChange"
        ></file-upload>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        class="upload"
        v-else
        label="装修公司封面"
        prop="gongsifengmian"
      >
        <img
          v-if="ruleForm.gongsifengmian.substring(0, 4) == 'http'"
          class="upload-img"
          style="margin-right: 20px"
          v-bind:key="index"
          :src="ruleForm.gongsifengmian.split(',')[0]"
          width="100"
          height="100"
        />
        <img
          v-else
          class="upload-img"
          style="margin-right: 20px"
          v-bind:key="index"
          v-for="(item, index) in ruleForm.gongsifengmian.split(',')"
          :src="baseUrl + item"
          width="100"
          height="100"
        />
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="联系方式"
        prop="lianxifangshi"
      >
        <el-input
          v-model="ruleForm.lianxifangshi"
          placeholder="联系方式"
          clearable
          :disabled="ro.lianxifangshi"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="预约时间"
        prop="yuyueshijian"
      >
        <el-date-picker
          :disabled="false || ro.yuyueshijian"
          value-format="yyyy-MM-dd HH:mm:ss"
          v-model="ruleForm.yuyueshijian"
          type="datetime"
          placeholder="预约时间"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="业主账号"
        prop="yezhuzhanghao"
      >
        <el-input
          v-model="ruleForm.yezhuzhanghao"
          placeholder="业主账号"
          clearable
          :disabled="true"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="业主姓名"
        prop="yezhuxingming"
      >
        <el-input
          v-model="ruleForm.yezhuxingming"
          placeholder="业主姓名"
          clearable
          :disabled="true"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="房屋名称"
        prop="fangwumingcheng"
      >
        <el-select
          @change="fangwumingchengChange"
          v-model="ruleForm.fangwumingcheng"
          placeholder="请选择房屋名称"
        >
          <el-option
            v-for="(item, index) in fangwumingchengOptions"
            :key="index"
            :label="item"
            :value="item"
          >
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="楼层"
        prop="louceng"
      >
        <el-input
          v-model="ruleForm.louceng"
          placeholder="楼层"
          clearable
          :disabled="false || ro.louceng"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="房间号"
        prop="fangjianhao"
      >
        <el-input
          v-model="ruleForm.fangjianhao"
          placeholder="房间号"
          clearable
          :disabled="false || ro.fangjianhao"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="面积"
        prop="mianji"
      >
        <el-input
          v-model="ruleForm.mianji"
          placeholder="面积"
          clearable
          :disabled="false || ro.mianji"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="房型"
        prop="fangxing"
      >
        <el-input
          v-model="ruleForm.fangxing"
          placeholder="房型"
          clearable
          :disabled="false || ro.fangxing"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="位置"
        prop="weizhi"
      >
        <el-input
          v-model="ruleForm.weizhi"
          placeholder="位置"
          clearable
          :disabled="false || ro.weizhi"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="预约内容"
        prop="yuyueneirong"
      >
        <editor
          :style="{
            minHeight: '250px',
            padding: '0',
            boxShadow: '0 0 0px rgba(75,223,201,.5)',
            margin: '0',
            borderColor: '#eee',
            backgroundColor: '#fff',
            borderRadius: '0',
            borderWidth: '1px',
            width: '100%',
            borderStyle: 'solid',
            height: 'auto',
          }"
          v-model="ruleForm.yuyueneirong"
          class="editor"
          action="file/upload"
        >
        </editor>
      </el-form-item>

      <el-form-item :style="{ padding: '0', margin: '0' }">
        <el-button
          :style="{
            border: '0',
            cursor: 'pointer',
            padding: '0',
            margin: '0 20px 0 0',
            outline: 'none',
            color: 'rgba(255, 255, 255, 1)',
            borderRadius: '4px',
            background: '#F5BB00',
            width: '128px',
            lineHeight: '40px',
            fontSize: '14px',
            height: '40px',
          }"
          type="primary"
          @click="onSubmit"
          >提交</el-button
        >
        <el-button
          :style="{
            border: '0px solid rgba(64, 158, 255, 1)',
            cursor: 'pointer',
            padding: '0',
            margin: '0',
            outline: 'none',
            color: '#fff',
            borderRadius: '4px',
            background: '#333',
            width: '128px',
            lineHeight: '40px',
            fontSize: '14px',
            height: '40px',
          }"
          @click="back()"
          >返回</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    // 自定义时间验证函数
    const validateTime = (rule, value, callback) => {
      if (!value) {
        // 若未选择时间，提示请选择时间
        return callback(new Error("请选择时间"));
      }
      // 获取当前时间
      const currentTime = new Date();
      // 将选择的时间转换为 Date 对象
      const selectedDate = new Date(value);
      if (selectedDate < currentTime) {
        callback(new Error("选择的时间不能小于当前时间"));
      } else {
        // 验证通过
        callback();
      }
    };

    return {
      id: "",
      baseUrl: "",
      ro: {
        gongsimingcheng: false,
        fuzeren: false,
        gongsifengmian: false,
        lianxifangshi: false,
        yuyueshijian: false,
        yuyueneirong: false,
        yezhuzhanghao: false,
        yezhuxingming: false,
        fangwumingcheng: false,
        louceng: false,
        fangjianhao: false,
        mianji: false,
        fangxing: false,
        weizhi: false,
        sfsh: false,
        shhf: false,
      },
      type: "",
      userTableName: localStorage.getItem("UserTableName"),
      ruleForm: {
        gongsimingcheng: "",
        fuzeren: "",
        gongsifengmian: "",
        lianxifangshi: "",
        yuyueshijian: "",
        yuyueneirong: "",
        yezhuzhanghao: "",
        yezhuxingming: "",
        fangwumingcheng: "",
        louceng: "",
        fangjianhao: "",
        mianji: "",
        fangxing: "",
        weizhi: "",
      },
      fangwumingchengOptions: [],

      rules: {
        gongsimingcheng: [],
        fuzeren: [],
        gongsifengmian: [],
        lianxifangshi: [],
        yuyueshijian: [
          {
            validator: validateTime,
            trigger: "change",
          },
        ],
        yuyueneirong: [],
        yezhuzhanghao: [],
        yezhuxingming: [],
        fangwumingcheng: [
          {
            required: true,
            message: "请选择房源名称",
            trigger: "change",
          },
        ],
        louceng: [
          {
            required: true,
            message: "请输入楼层",
            trigger: "blur",
          },
        ],
        fangjianhao: [
          {
            required: true,
            message: "请输入房间号",
            trigger: "blur",
          },
        ],
        mianji: [
          {
            required: true,
            message: "请输入面积",
            trigger: "blur",
          },
        ],
        fangxing: [
          {
            required: true,
            message: "请输入房型",
            trigger: "blur",
          },
        ],
        weizhi: [
          {
            required: true,
            message: "请输入位置",
            trigger: "blur",
          },
        ],
        sfsh: [],
        shhf: [],
      },
      centerType: false,
    };
  },
  computed: {},
  components: {},
  created() {
    if (this.$route.query.centerType) {
      this.centerType = true;
    }
    //this.bg();
    let type = this.$route.query.type ? this.$route.query.type : "";
    this.init(type);
    this.baseUrl = this.$config.baseUrl;
    this.ruleForm.yuyueshijian = this.getCurDateTime();
  },
  methods: {
    getMakeZero(s) {
      return s < 10 ? "0" + s : s;
    },
    // 下载
    download(file) {
      window.open(`${file}`);
    },
    // 初始化
    init(type) {
      this.type = type;
      if (type == "cross") {
        var obj = JSON.parse(localStorage.getItem("crossObj"));
        for (var o in obj) {
          if (o == "gongsimingcheng") {
            this.ruleForm.gongsimingcheng = obj[o];
            this.ro.gongsimingcheng = true;
            continue;
          }
          if (o == "fuzeren") {
            this.ruleForm.fuzeren = obj[o];
            this.ro.fuzeren = true;
            continue;
          }
          if (o == "gongsifengmian") {
            this.ruleForm.gongsifengmian = obj[o].split(",")[0];
            this.ro.gongsifengmian = true;
            continue;
          }
          if (o == "lianxifangshi") {
            this.ruleForm.lianxifangshi = obj[o];
            this.ro.lianxifangshi = true;
            continue;
          }
          if (o == "yuyueshijian") {
            this.ruleForm.yuyueshijian = obj[o];
            this.ro.yuyueshijian = true;
            continue;
          }
          if (o == "yuyueneirong") {
            this.ruleForm.yuyueneirong = obj[o];
            this.ro.yuyueneirong = true;
            continue;
          }
          if (o == "yezhuzhanghao") {
            this.ruleForm.yezhuzhanghao = obj[o];
            this.ro.yezhuzhanghao = true;
            continue;
          }
          if (o == "yezhuxingming") {
            this.ruleForm.yezhuxingming = obj[o];
            this.ro.yezhuxingming = true;
            continue;
          }
          if (o == "fangwumingcheng") {
            this.ruleForm.fangwumingcheng = obj[o];
            this.ro.fangwumingcheng = true;
            continue;
          }
          if (o == "louceng") {
            this.ruleForm.louceng = obj[o];
            this.ro.louceng = true;
            continue;
          }
          if (o == "fangjianhao") {
            this.ruleForm.fangjianhao = obj[o];
            this.ro.fangjianhao = true;
            continue;
          }
          if (o == "mianji") {
            this.ruleForm.mianji = obj[o];
            this.ro.mianji = true;
            continue;
          }
          if (o == "fangxing") {
            this.ruleForm.fangxing = obj[o];
            this.ro.fangxing = true;
            continue;
          }
          if (o == "weizhi") {
            this.ruleForm.weizhi = obj[o];
            this.ro.weizhi = true;
            continue;
          }
        }
      } else if (type == "edit") {
        this.info();
      }
      // 获取用户信息
      this.$http
        .get(this.userTableName + "/session", { emulateJSON: true })
        .then((res) => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if (
              (json.yezhuzhanghao != "" && json.yezhuzhanghao) ||
              json.yezhuzhanghao == 0
            ) {
              this.ruleForm.yezhuzhanghao = json.yezhuzhanghao;
            }
            if (
              (json.yezhuxingming != "" && json.yezhuxingming) ||
              json.yezhuxingming == 0
            ) {
              this.ruleForm.yezhuxingming = json.yezhuxingming;
            }
          }
        });
      this.$http
        .get("option/fangwuxinxi/fangwumingcheng", { emulateJSON: true })
        .then((res) => {
          if (res.data.code == 0) {
            this.fangwumingchengOptions = res.data.data;
          }
        });

      if (
        localStorage.getItem("raffleType") &&
        localStorage.getItem("raffleType") != null
      ) {
        localStorage.removeItem("raffleType");
        setTimeout(() => {
          this.onSubmit();
        }, 300);
      }
    },
    // 下二随
    fangwumingchengChange() {
      this.$http
        .get(
          "follow/fangwuxinxi/fangwumingcheng?columnValue=" +
            this.ruleForm.fangwumingcheng,
          { emulateJSON: true }
        )
        .then((res) => {
          if (res.data.code == 0) {
            if (res.data.data.louceng) {
              this.ruleForm.louceng = res.data.data.louceng;
            }
            if (res.data.data.fangjianhao) {
              this.ruleForm.fangjianhao = res.data.data.fangjianhao;
            }
            if (res.data.data.mianji) {
              this.ruleForm.mianji = res.data.data.mianji;
            }
            if (res.data.data.fangxing) {
              this.ruleForm.fangxing = res.data.data.fangxing;
            }
            if (res.data.data.weizhi) {
              this.ruleForm.weizhi = res.data.data.weizhi;
            }
          }
        });
    },

    // 多级联动参数
    // 多级联动参数
    info() {
      this.$http
        .get(`yuyuexinxi/detail/${this.$route.query.id}`, { emulateJSON: true })
        .then((res) => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
    },
    // 提交
    onSubmit() {
      //更新跨表属性
      var crossuserid;
      var crossrefid;
      var crossoptnum;
      this.$refs["ruleForm"].validate((valid) => {
        if (valid) {
          if (this.type == "cross") {
            var statusColumnName = localStorage.getItem("statusColumnName");
            var statusColumnValue = localStorage.getItem("statusColumnValue");
            if (statusColumnName && statusColumnName != "") {
              var obj = JSON.parse(localStorage.getItem("crossObj"));
              if (!statusColumnName.startsWith("[")) {
                for (var o in obj) {
                  if (o == statusColumnName) {
                    obj[o] = statusColumnValue;
                  }
                }
                var table = localStorage.getItem("crossTable");
                this.$http.post(table + "/update", obj).then((res) => {});
              } else {
                crossuserid = Number(localStorage.getItem("frontUserid"));
                crossrefid = obj["id"];
                crossoptnum = localStorage.getItem("statusColumnName");
                crossoptnum = crossoptnum.replace(/\[/, "").replace(/\]/, "");
              }
            }
          }
          if (crossrefid && crossuserid) {
            this.ruleForm.crossuserid = crossuserid;
            this.ruleForm.crossrefid = crossrefid;
            var params = {
              page: 1,
              limit: 10,
              crossuserid: crossuserid,
              crossrefid: crossrefid,
            };
            this.$http
              .get("yuyuexinxi/list", {
                params: params,
              })
              .then((res) => {
                if (res.data.data.total >= crossoptnum) {
                  this.$message({
                    message: localStorage.getItem("tips"),
                    type: "error",
                    duration: 1500,
                  });
                  return false;
                } else {
                  // 跨表计算

                  this.$http
                    .post(
                      `yuyuexinxi/${
                        this.ruleForm.id
                          ? "update"
                          : this.centerType
                          ? "save"
                          : "add"
                      }`,
                      this.ruleForm
                    )
                    .then((res) => {
                      if (res.data.code == 0) {
                        this.$message({
                          message: "操作成功",
                          type: "success",
                          duration: 1500,
                          onClose: () => {
                            this.$router.go(-1);
                          },
                        });
                      } else {
                        this.$message({
                          message: res.data.msg,
                          type: "error",
                          duration: 1500,
                        });
                      }
                    });
                }
              });
          } else {
            this.$http
              .post(
                `yuyuexinxi/${
                  this.ruleForm.id ? "update" : this.centerType ? "save" : "add"
                }`,
                this.ruleForm
              )
              .then((res) => {
                if (res.data.code == 0) {
                  this.$message({
                    message: "操作成功",
                    type: "success",
                    duration: 1500,
                    onClose: () => {
                      this.$router.go(-1);
                    },
                  });
                } else {
                  this.$message({
                    message: res.data.msg,
                    type: "error",
                    duration: 1500,
                  });
                }
              });
          }
        }
      });
    },
    // 获取uuid
    getUUID() {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.$router.go(-1);
    },
    gongsifengmianUploadChange(fileUrls) {
      this.ruleForm.gongsifengmian = fileUrls.replace(
        new RegExp(this.$config.baseUrl, "g"),
        ""
      );
    },
  },
};
</script>
<style rel="stylesheet/scss" lang="scss" scoped>
.el-date-editor.el-input {
  width: auto;
}

.add-update-preview .el-form-item ::v-deep .el-form-item__label {
  padding: 0 10px 0 0;
  color: #666;
  font-weight: 500;
  width: 180px;
  font-size: 14px;
  line-height: 40px;
  text-align: right;
}

.add-update-preview .el-form-item ::v-deep .el-form-item__content {
  margin-left: 180px;
}

.add-update-preview .el-input ::v-deep .el-input__inner {
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 0 12px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: #666;
  background: #fff;
  width: 400px;
  font-size: 14px;
  height: 40px;
}
.add-update-preview .el-input-number ::v-deep .el-input__inner {
  text-align: left;
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 0 12px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: #666;
  background: #fff;
  width: 400px;
  font-size: 14px;
  height: 40px;
}
.add-update-preview .el-input-number ::v-deep .el-input-number__decrease {
  display: none;
}
.add-update-preview .el-input-number ::v-deep .el-input-number__increase {
  display: none;
}

.add-update-preview .el-select ::v-deep .el-input__inner {
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 0 10px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: #666;
  background: #fff;
  width: 200px;
  font-size: 14px;
  height: 40px;
}

.add-update-preview .el-date-editor ::v-deep .el-input__inner {
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 0 10px 0 30px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: #666;
  background: #fff;
  width: 200px;
  font-size: 14px;
  height: 40px;
}

.add-update-preview ::v-deep .el-upload--picture-card {
  background: transparent;
  border: 0;
  border-radius: 0;
  width: auto;
  height: auto;
  line-height: initial;
  vertical-align: middle;
}

.add-update-preview ::v-deep .upload .upload-img {
  border: 1px solid #ddd;
  cursor: pointer;
  border-radius: 6px;
  color: #999;
  background: #fff;
  width: 200px;
  font-size: 32px;
  line-height: 100px;
  text-align: center;
  height: 100px;
}

.add-update-preview ::v-deep .el-upload-list .el-upload-list__item {
  border: 1px solid #ddd;
  cursor: pointer;
  border-radius: 6px;
  color: #999;
  background: #fff;
  width: 200px;
  font-size: 32px;
  line-height: 100px;
  text-align: center;
  height: 100px;
}

.add-update-preview ::v-deep .el-upload .el-icon-plus {
  border: 1px solid #ddd;
  cursor: pointer;
  border-radius: 6px;
  color: #999;
  background: #fff;
  width: 200px;
  font-size: 32px;
  line-height: 100px;
  text-align: center;
  height: 100px;
}

.add-update-preview .el-textarea ::v-deep .el-textarea__inner {
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 12px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: #666;
  background: #fff;
  width: 400px;
  font-size: 14px;
  height: 120px;
}
</style>
