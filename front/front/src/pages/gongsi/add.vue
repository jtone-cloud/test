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
        label="密码"
        prop="mima"
      >
        <el-input
          v-model="ruleForm.mima"
          placeholder="密码"
          clearable
          :disabled="false || ro.mima"
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
          :disabled="false || ro.lianxifangshi"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="装修公司邮箱"
        prop="gongsiyouxiang"
      >
        <el-input
          v-model="ruleForm.gongsiyouxiang"
          placeholder="装修公司邮箱"
          clearable
          :disabled="false || ro.gongsiyouxiang"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="装修公司地址"
        prop="gongsidizhi"
      >
        <el-input
          v-model="ruleForm.gongsidizhi"
          placeholder="装修公司地址"
          clearable
          :disabled="false || ro.gongsidizhi"
        ></el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="创立时间"
        prop="chuanglishijian"
      >
        <el-date-picker
          :disabled="false || ro.chuanglishijian"
          format="yyyy 年 MM 月 dd 日"
          value-format="yyyy-MM-dd"
          v-model="ruleForm.chuanglishijian"
          type="date"
          placeholder="创立时间"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="设计团队"
        prop="shejituandui"
      >
        <el-input
          type="textarea"
          :rows="8"
          placeholder="设计团队"
          v-model="ruleForm.shejituandui"
        >
        </el-input>
      </el-form-item>
      <el-form-item
        :style="{ padding: '10px', margin: '0 0 10px', background: 'none' }"
        label="装修公司简介"
        prop="gongsijianjie"
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
          v-model="ruleForm.gongsijianjie"
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
    let self = this;
    return {
      id: "",
      baseUrl: "",
      ro: {
        gongsimingcheng: false,
        mima: false,
        fuzeren: false,
        gongsifengmian: false,
        lianxifangshi: false,
        gongsiyouxiang: false,
        gongsidizhi: false,
        chuanglishijian: false,
        shejituandui: false,
        gongsijianjie: false,
        sfsh: false,
        shhf: false,
        clicktime: false,
        clicknum: false,
        storeupnum: false,
      },
      type: "",
      userTableName: localStorage.getItem("UserTableName"),
      ruleForm: {
        gongsimingcheng: "",
        mima: "",
        fuzeren: "",
        gongsifengmian: "",
        lianxifangshi: "",
        gongsiyouxiang: "",
        gongsidizhi: "",
        chuanglishijian: "",
        shejituandui: "",
        gongsijianjie: "",
        clicktime: "",
        clicknum: "",
        storeupnum: "",
      },

      rules: {
        gongsimingcheng: [
          { required: true, message: "装修公司名称不能为空", trigger: "blur" },
        ],
        mima: [{ required: true, message: "密码不能为空", trigger: "blur" }],
        fuzeren: [],
        gongsifengmian: [],
        lianxifangshi: [],
        gongsiyouxiang: [
          { validator: this.$validate.isEmail, trigger: "blur" },
        ],
        gongsidizhi: [],
        chuanglishijian: [],
        shejituandui: [],
        gongsijianjie: [],
        sfsh: [],
        shhf: [],
        clicktime: [],
        clicknum: [{ validator: this.$validate.isIntNumer, trigger: "blur" }],
        storeupnum: [{ validator: this.$validate.isIntNumer, trigger: "blur" }],
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
    this.ruleForm.chuanglishijian = this.getCurDate();
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
          if (o == "mima") {
            this.ruleForm.mima = obj[o];
            this.ro.mima = true;
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
          if (o == "gongsiyouxiang") {
            this.ruleForm.gongsiyouxiang = obj[o];
            this.ro.gongsiyouxiang = true;
            continue;
          }
          if (o == "gongsidizhi") {
            this.ruleForm.gongsidizhi = obj[o];
            this.ro.gongsidizhi = true;
            continue;
          }
          if (o == "chuanglishijian") {
            this.ruleForm.chuanglishijian = obj[o];
            this.ro.chuanglishijian = true;
            continue;
          }
          if (o == "shejituandui") {
            this.ruleForm.shejituandui = obj[o];
            this.ro.shejituandui = true;
            continue;
          }
          if (o == "gongsijianjie") {
            this.ruleForm.gongsijianjie = obj[o];
            this.ro.gongsijianjie = true;
            continue;
          }
          if (o == "clicktime") {
            this.ruleForm.clicktime = obj[o];
            this.ro.clicktime = true;
            continue;
          }
          if (o == "clicknum") {
            this.ruleForm.clicknum = obj[o];
            this.ro.clicknum = true;
            continue;
          }
          if (o == "storeupnum") {
            this.ruleForm.storeupnum = obj[o];
            this.ro.storeupnum = true;
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

    // 多级联动参数
    // 多级联动参数
    info() {
      this.$http
        .get(`gongsi/detail/${this.$route.query.id}`, { emulateJSON: true })
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
              .get("gongsi/list", {
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
                      `gongsi/${
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
                `gongsi/${
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
