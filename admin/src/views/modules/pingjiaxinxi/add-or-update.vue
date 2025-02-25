<template>
  <div
    class="addEdit-block"
    :style="{
      padding: '0px 0px 30px',
      fontSize: '14px',
      color: '#000',
      background: 'none',
    }"
  >
    <el-form
      :style="{
        border: '0px solid rgba(255,255,255,1)',
        padding: '30px 0 10px',
        borderRadius: '0 0 8px 8px',
        alignItems: 'flex-start',
        flexWrap: 'wrap',
        background: 'rgba(255,255,255,0)',
        display: 'flex',
        fontSize: 'inherit',
      }"
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="150px"
    >
      <template>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          class="input"
          v-if="type != 'info'"
          label="装修公司名称"
          prop="gongsimingcheng"
        >
          <el-input
            v-model="ruleForm.gongsimingcheng"
            placeholder="装修公司名称"
            clearable
            :readonly="ro.gongsimingcheng"
          ></el-input>
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          v-else
          class="input"
          label="装修公司名称"
          prop="gongsimingcheng"
        >
          <el-input
            v-model="ruleForm.gongsimingcheng"
            placeholder="装修公司名称"
            readonly
          ></el-input>
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          class="input"
          v-if="type != 'info'"
          label="负责人"
          prop="fuzeren"
        >
          <el-input
            v-model="ruleForm.fuzeren"
            placeholder="负责人"
            clearable
            :readonly="ro.fuzeren"
          ></el-input>
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          v-else
          class="input"
          label="负责人"
          prop="fuzeren"
        >
          <el-input
            v-model="ruleForm.fuzeren"
            placeholder="负责人"
            readonly
          ></el-input>
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          class="upload"
          v-if="type != 'info' && !ro.tupian"
          label="图片"
          prop="tupian"
        >
          <file-upload
            tip="点击上传图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.tupian ? ruleForm.tupian : ''"
            @change="tupianUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          class="upload"
          v-else-if="ruleForm.tupian"
          label="图片"
          prop="tupian"
        >
          <img
            v-if="ruleForm.tupian.substring(0, 4) == 'http'"
            class="upload-img"
            style="margin-right: 20px"
            v-bind:key="index"
            :src="ruleForm.tupian.split(',')[0]"
            width="100"
            height="100"
          />
          <img
            v-else
            class="upload-img"
            style="margin-right: 20px"
            v-bind:key="index"
            v-for="(item, index) in ruleForm.tupian.split(',')"
            :src="$base.url + item"
            width="100"
            height="100"
          />
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          class="input"
          v-if="type != 'info'"
          label="业主账号"
          prop="yezhuzhanghao"
        >
          <el-input
            v-model="ruleForm.yezhuzhanghao"
            placeholder="业主账号"
            clearable
            :readonly="ro.yezhuzhanghao"
          ></el-input>
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          v-else
          class="input"
          label="业主账号"
          prop="yezhuzhanghao"
        >
          <el-input
            v-model="ruleForm.yezhuzhanghao"
            placeholder="业主账号"
            readonly
          ></el-input>
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          class="input"
          v-if="type != 'info'"
          label="业主姓名"
          prop="yezhuxingming"
        >
          <el-input
            v-model="ruleForm.yezhuxingming"
            placeholder="业主姓名"
            clearable
            :readonly="ro.yezhuxingming"
          ></el-input>
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          v-else
          class="input"
          label="业主姓名"
          prop="yezhuxingming"
        >
          <el-input
            v-model="ruleForm.yezhuxingming"
            placeholder="业主姓名"
            readonly
          ></el-input>
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          class="select"
          v-if="type != 'info'"
          label="服务态度"
          prop="fuwutaidu"
        >
          <el-select
            :disabled="ro.fuwutaidu"
            v-model="ruleForm.fuwutaidu"
            placeholder="请选择服务态度"
          >
            <el-option
              v-for="(item, index) in fuwutaiduOptions"
              v-bind:key="index"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          v-else
          class="input"
          label="服务态度"
          prop="fuwutaidu"
        >
          <el-input
            v-model="ruleForm.fuwutaidu"
            placeholder="服务态度"
            readonly
          ></el-input>
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          class="date"
          v-if="type != 'info'"
          label="评价日期"
          prop="pingjiariqi"
        >
          <el-date-picker
            format="yyyy 年 MM 月 dd 日"
            value-format="yyyy-MM-dd"
            v-model="ruleForm.pingjiariqi"
            type="date"
            :readonly="ro.pingjiariqi"
            placeholder="评价日期"
          ></el-date-picker>
        </el-form-item>
        <el-form-item
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          class="input"
          v-else-if="ruleForm.pingjiariqi"
          label="评价日期"
          prop="pingjiariqi"
        >
          <el-input
            v-model="ruleForm.pingjiariqi"
            placeholder="评价日期"
            readonly
          ></el-input>
        </el-form-item>
      </template>
      <el-form-item
        :style="{
          width: '48%',
          margin: '0 0 30px 0',
          fontSize: 'inherit',
          color: 'inherit',
        }"
        v-if="type != 'info'"
        label="评价内容"
        prop="pingjianeirong"
      >
        <editor
          style="min-width: 200px; max-width: 600px"
          v-model="ruleForm.pingjianeirong"
          class="editor"
          action="file/upload"
        >
        </editor>
      </el-form-item>
      <el-form-item
        :style="{
          width: '48%',
          margin: '0 0 30px 0',
          fontSize: 'inherit',
          color: 'inherit',
        }"
        v-else-if="ruleForm.pingjianeirong"
        label="评价内容"
        prop="pingjianeirong"
      >
        <span
          :style="{
            padding: '0 20px',
            color: 'inherit',
            background: '#fff',
            display: 'inline-block',
            width: '80%',
            fontSize: '14px',
            lineHeight: '40px',
            fontWeight: '500',
          }"
          v-html="ruleForm.pingjianeirong"
        ></span>
      </el-form-item>
      <el-form-item
        :style="{
          padding: '0 10px',
          margin: '30px 0',
          alignItems: 'center',
          textAlign: 'center',
          display: 'flex',
          width: '100%',
          perspective: '320px',
          '-webkitPerspective': '320px',
          fontSize: '48px',
          justifyContent: 'flex-end',
        }"
        class="btn"
      >
        <el-button
          class="btn3"
          v-if="type != 'info'"
          type="success"
          @click="onSubmit"
        >
          <span
            class="icon iconfont icon-tijiao16"
            :style="{
              margin: '0 2px',
              fontSize: '18px',
              color: 'inherit',
              display: 'none',
            }"
          ></span>
          提交
        </el-button>
        <el-button
          class="btn4"
          v-if="type != 'info'"
          type="success"
          @click="back()"
        >
          <span
            class="icon iconfont icon-quxiao09"
            :style="{
              margin: '0 2px',
              fontSize: '18px',
              color: 'inherit',
              display: 'none',
            }"
          ></span>
          取消
        </el-button>
        <el-button
          class="btn5"
          v-if="type == 'info'"
          type="success"
          @click="back()"
        >
          <span
            class="icon iconfont icon-fanhui01"
            :style="{
              margin: '0 2px',
              fontSize: '18px',
              color: 'inherit',
              display: 'none',
            }"
          ></span>
          返回
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import {
  isNumber,
  isIntNumer,
  isEmail,
  isPhone,
  isMobile,
  isURL,
  checkIdCard,
} from "@/utils/validate";
export default {
  data() {
    let self = this;
    var validateIdCard = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
      id: "",
      type: "",

      ro: {
        gongsimingcheng: false,
        fuzeren: false,
        tupian: false,
        yezhuzhanghao: false,
        yezhuxingming: false,
        fuwutaidu: false,
        pingjiariqi: false,
        pingjianeirong: false,
      },

      ruleForm: {
        gongsimingcheng: "",
        fuzeren: "",
        tupian: "",
        yezhuzhanghao: "",
        yezhuxingming: "",
        fuwutaidu: "",
        pingjiariqi: "",
        pingjianeirong: "",
      },

      fuwutaiduOptions: [],

      rules: {
        gongsimingcheng: [],
        fuzeren: [],
        tupian: [],
        yezhuzhanghao: [],
        yezhuxingming: [],
        fuwutaidu: [],
        pingjiariqi: [],
        pingjianeirong: [],
      },
    };
  },
  props: ["parent"],
  computed: {},
  components: {},
  created() {
    this.ruleForm.pingjiariqi = this.getCurDate();
  },
  methods: {
    // 下载
    download(file) {
      window.open(`${file}`);
    },
    // 初始化
    init(id, type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if (this.type == "info" || this.type == "else") {
        this.info(id);
      } else if (this.type == "logistics") {
        this.logistics = false;
        this.info(id);
      } else if (this.type == "cross") {
        var obj = this.$storage.getObj("crossObj");
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
          if (o == "tupian") {
            this.ruleForm.tupian = obj[o];
            this.ro.tupian = true;
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
          if (o == "fuwutaidu") {
            this.ruleForm.fuwutaidu = obj[o];
            this.ro.fuwutaidu = true;
            continue;
          }
          if (o == "pingjiariqi") {
            this.ruleForm.pingjiariqi = obj[o];
            this.ro.pingjiariqi = true;
            continue;
          }
          if (o == "pingjianeirong") {
            this.ruleForm.pingjianeirong = obj[o];
            this.ro.pingjianeirong = true;
            continue;
          }
        }
      }

      // 获取用户信息
      this.$http({
        url: `${this.$storage.get("sessionTable")}/session`,
        method: "get",
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });

      this.fuwutaiduOptions = "非常满意,满意,一般,不满意".split(",");
    },
    // 多级联动参数

    info(id) {
      this.$http({
        url: `pingjiaxinxi/info/${id}`,
        method: "get",
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
          //解决前台上传图片后台不显示的问题
          let reg = new RegExp("../../../upload", "g"); //g代表全部
          this.ruleForm.pingjianeirong = this.ruleForm.pingjianeirong.replace(
            reg,
            "../../../springbootlqyk36m6/upload"
          );
        } else {
          this.$message.error(data.msg);
        }
      });
    },

    // 提交
    onSubmit() {
      if (this.ruleForm.tupian != null) {
        this.ruleForm.tupian = this.ruleForm.tupian.replace(
          new RegExp(this.$base.url, "g"),
          ""
        );
      }

      var objcross = this.$storage.getObj("crossObj");
      //更新跨表属性
      var crossuserid;
      var crossrefid;
      var crossoptnum;
      if (this.type == "cross") {
        var statusColumnName = this.$storage.get("statusColumnName");
        var statusColumnValue = this.$storage.get("statusColumnValue");
        if (statusColumnName != "") {
          var obj = this.$storage.getObj("crossObj");
          if (statusColumnName && !statusColumnName.startsWith("[")) {
            for (var o in obj) {
              if (o == statusColumnName) {
                obj[o] = statusColumnValue;
              }
            }
            var table = this.$storage.get("crossTable");
            this.$http({
              url: `${table}/update`,
              method: "post",
              data: obj,
            }).then(({ data }) => {});
          } else {
            crossuserid = this.$storage.get("userid");
            crossrefid = obj["id"];
            crossoptnum = this.$storage.get("statusColumnName");
            crossoptnum = crossoptnum.replace(/\[/, "").replace(/\]/, "");
          }
        }
      }
      this.$refs["ruleForm"].validate((valid) => {
        if (valid) {
          if (crossrefid && crossuserid) {
            this.ruleForm.crossuserid = crossuserid;
            this.ruleForm.crossrefid = crossrefid;
            let params = {
              page: 1,
              limit: 10,
              crossuserid: this.ruleForm.crossuserid,
              crossrefid: this.ruleForm.crossrefid,
            };
            this.$http({
              url: "pingjiaxinxi/page",
              method: "get",
              params: params,
            }).then(({ data }) => {
              if (data && data.code === 0) {
                if (data.data.total >= crossoptnum) {
                  this.$message.error(this.$storage.get("tips"));
                  return false;
                } else {
                  this.$http({
                    url: `pingjiaxinxi/${
                      !this.ruleForm.id ? "save" : "update"
                    }`,
                    method: "post",
                    data: this.ruleForm,
                  }).then(({ data }) => {
                    if (data && data.code === 0) {
                      this.$message({
                        message: "操作成功",
                        type: "success",
                        duration: 1500,
                        onClose: () => {
                          this.parent.showFlag = true;
                          this.parent.addOrUpdateFlag = false;
                          this.parent.pingjiaxinxiCrossAddOrUpdateFlag = false;
                          this.parent.search();
                          this.parent.contentStyleChange();
                        },
                      });
                    } else {
                      this.$message.error(data.msg);
                    }
                  });
                }
              } else {
              }
            });
          } else {
            this.$http({
              url: `pingjiaxinxi/${!this.ruleForm.id ? "save" : "update"}`,
              method: "post",
              data: this.ruleForm,
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.$message({
                  message: "操作成功",
                  type: "success",
                  duration: 1500,
                  onClose: () => {
                    this.parent.showFlag = true;
                    this.parent.addOrUpdateFlag = false;
                    this.parent.pingjiaxinxiCrossAddOrUpdateFlag = false;
                    this.parent.search();
                    this.parent.contentStyleChange();
                  },
                });
              } else {
                this.$message.error(data.msg);
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
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.pingjiaxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    tupianUploadChange(fileUrls) {
      this.ruleForm.tupian = fileUrls;
    },
  },
};
</script>
<style lang="scss" scoped>
.amap-wrapper {
  width: 100%;
  height: 500px;
}

.search-box {
  position: absolute;
}

.el-date-editor.el-input {
  width: auto;
}

.add-update-preview .el-form-item ::v-deep .el-form-item__label {
  padding: 0 10px 0 0;
  color: #999;
  font-weight: 500;
  display: inline-block;
  width: 150px;
  font-size: inherit;
  line-height: 40px;
  text-align: right;
}

.add-update-preview .el-form-item ::v-deep .el-form-item__content {
  margin-left: 150px;
}

.add-update-preview .el-input ::v-deep .el-input__inner {
  border: 0px solid #000;
  border-radius: 0px;
  padding: 0 12px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: inherit;
  background: #fff;
  width: auto;
  font-size: 14px;
  min-width: 350px;
  height: 36px;
}
.add-update-preview .el-input-number ::v-deep .el-input__inner {
  text-align: left;
  border: 0px solid #000;
  border-radius: 0px;
  padding: 0 12px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: inherit;
  background: #fff;
  width: auto;
  font-size: 14px;
  min-width: 350px;
  height: 36px;
}
.add-update-preview .el-input-number ::v-deep .el-input-number__decrease {
  display: none;
}
.add-update-preview .el-input-number ::v-deep .el-input-number__increase {
  display: none;
}

.add-update-preview .el-select ::v-deep .el-input__inner {
  border: 0px solid #000;
  border-radius: 0px;
  padding: 0 10px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: inherit;
  background: #fff;
  width: auto;
  font-size: 14px;
  min-width: 350px;
  height: 36px;
}

.add-update-preview .el-date-editor ::v-deep .el-input__inner {
  border: 0px solid #000;
  border-radius: 0px;
  padding: 0 10px 0 30px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: inherit;
  background: #fff;
  width: auto;
  font-size: 14px;
  min-width: 350px;
  height: 36px;
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
  border: 0px solid #000;
  cursor: pointer;
  border-radius: 0px;
  color: inherit;
  background: #fff;
  object-fit: cover;
  width: 180px;
  font-size: 32px;
  line-height: 90px;
  text-align: center;
  height: 90px;
}

.add-update-preview ::v-deep .el-upload-list .el-upload-list__item {
  border: 0px solid #000;
  cursor: pointer;
  border-radius: 0px;
  color: inherit;
  background: #fff;
  object-fit: cover;
  width: 180px;
  font-size: 32px;
  line-height: 90px;
  text-align: center;
  height: 90px;
}

.add-update-preview ::v-deep .el-upload .el-icon-plus {
  border: 0px solid #000;
  cursor: pointer;
  border-radius: 0px;
  color: inherit;
  background: #fff;
  object-fit: cover;
  width: 180px;
  font-size: 32px;
  line-height: 90px;
  text-align: center;
  height: 90px;
}

.add-update-preview .el-textarea ::v-deep .el-textarea__inner {
  border: 0px solid #000;
  border-radius: 0px;
  padding: 12px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: inherit;
  background: #fff;
  width: auto;
  font-size: 14px;
  min-width: 350px;
  height: 120px;
}

.add-update-preview .btn .btn1 {
  border: 0px solid rgba(126, 96, 16, 0.2);
  cursor: pointer;
  padding: 0 30px;
  margin: 0px 20px 0 0;
  color: #fff;
  display: inline-block;
  font-size: 14px;
  line-height: 24px;
  border-radius: 4px;
  outline: none;
  background: #62779c;
  width: auto;
  height: 40px;
}

.add-update-preview .btn .btn1:hover {
  transform: scale(0.9);
  opacity: 0.8;
}

.add-update-preview .btn .btn2 {
  border: 0px solid rgba(126, 96, 16, 0.2);
  cursor: pointer;
  border-radius: 4px;
  padding: 0 30px;
  margin: 0px 20px 0 0;
  outline: none;
  color: #fff;
  background: #62779c;
  width: auto;
  font-size: 14px;
  line-height: 24px;
  height: 40px;
}

.add-update-preview .btn .btn2:hover {
  transform: scale(0.9);
  opacity: 0.8;
}

.add-update-preview .btn .btn3 {
  border: 0px solid rgba(126, 96, 16, 0.2);
  cursor: pointer;
  border-radius: 4px;
  padding: 0 30px;
  margin: 0px 20px 0 0;
  outline: none;
  color: #fff;
  background: #62779c;
  width: auto;
  font-size: 16px;
  line-height: 24px;
  height: 40px;
}

.add-update-preview .btn .btn3:hover {
  transform: scale(0.9);
  opacity: 0.8;
}

.add-update-preview .btn .btn4 {
  border: 0px solid rgba(126, 96, 16, 0.2);
  cursor: pointer;
  border-radius: 4px;
  padding: 0 30px;
  margin: 0px 20px 0 0;
  outline: none;
  color: #fff;
  background: #62779c;
  width: auto;
  font-size: 16px;
  line-height: 24px;
  height: 40px;
}

.add-update-preview .btn .btn4:hover {
  transform: scale(0.9);
  opacity: 0.8;
}

.add-update-preview .btn .btn5 {
  border: 0px solid rgba(126, 96, 16, 0.2);
  cursor: pointer;
  border-radius: 4px;
  padding: 0 30px;
  margin: 0px 20px 0 0;
  outline: none;
  color: #fff;
  background: #62779c;
  width: auto;
  font-size: 16px;
  line-height: 24px;
  height: 40px;
}

.add-update-preview .btn .btn5:hover {
  transform: scale(0.9);
  opacity: 0.8;
}
</style>
