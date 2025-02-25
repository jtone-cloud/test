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
          label="密码"
          prop="mima"
        >
          <el-input
            v-model="ruleForm.mima"
            placeholder="密码"
            clearable
            :readonly="ro.mima"
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
          label="密码"
          prop="mima"
        >
          <el-input
            v-model="ruleForm.mima"
            placeholder="密码"
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
          v-if="type != 'info' && !ro.gongsifengmian"
          label="装修公司封面"
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
          :style="{
            width: '48%',
            margin: '0 0 30px 0',
            fontSize: 'inherit',
            color: 'inherit',
          }"
          class="upload"
          v-else-if="ruleForm.gongsifengmian"
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
          label="联系方式"
          prop="lianxifangshi"
        >
          <el-input
            v-model="ruleForm.lianxifangshi"
            placeholder="联系方式"
            clearable
            :readonly="ro.lianxifangshi"
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
          label="联系方式"
          prop="lianxifangshi"
        >
          <el-input
            v-model="ruleForm.lianxifangshi"
            placeholder="联系方式"
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
          label="装修公司邮箱"
          prop="gongsiyouxiang"
        >
          <el-input
            v-model="ruleForm.gongsiyouxiang"
            placeholder="装修公司邮箱"
            clearable
            :readonly="ro.gongsiyouxiang"
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
          label="装修公司邮箱"
          prop="gongsiyouxiang"
        >
          <el-input
            v-model="ruleForm.gongsiyouxiang"
            placeholder="装修公司邮箱"
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
          label="装修公司地址"
          prop="gongsidizhi"
        >
          <el-input
            v-model="ruleForm.gongsidizhi"
            placeholder="装修公司地址"
            clearable
            :readonly="ro.gongsidizhi"
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
          label="装修公司地址"
          prop="gongsidizhi"
        >
          <el-input
            v-model="ruleForm.gongsidizhi"
            placeholder="装修公司地址"
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
          label="创立时间"
          prop="chuanglishijian"
        >
          <el-date-picker
            format="yyyy 年 MM 月 dd 日"
            value-format="yyyy-MM-dd"
            v-model="ruleForm.chuanglishijian"
            type="date"
            :readonly="ro.chuanglishijian"
            placeholder="创立时间"
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
          v-else-if="ruleForm.chuanglishijian"
          label="创立时间"
          prop="chuanglishijian"
        >
          <el-input
            v-model="ruleForm.chuanglishijian"
            placeholder="创立时间"
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
        class="textarea"
        v-if="type != 'info'"
        label="设计团队"
        prop="shejituandui"
      >
        <el-input
          style="min-width: 200px; max-width: 600px"
          type="textarea"
          :rows="8"
          placeholder="设计团队"
          v-model="ruleForm.shejituandui"
        >
        </el-input>
      </el-form-item>
      <el-form-item
        :style="{
          width: '48%',
          margin: '0 0 30px 0',
          fontSize: 'inherit',
          color: 'inherit',
        }"
        v-else-if="ruleForm.shejituandui"
        label="设计团队"
        prop="shejituandui"
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
          >{{ ruleForm.shejituandui }}</span
        >
      </el-form-item>
      <el-form-item
        :style="{
          width: '48%',
          margin: '0 0 30px 0',
          fontSize: 'inherit',
          color: 'inherit',
        }"
        v-if="type != 'info'"
        label="装修公司简介"
        prop="gongsijianjie"
      >
        <editor
          style="min-width: 200px; max-width: 600px"
          v-model="ruleForm.gongsijianjie"
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
        v-else-if="ruleForm.gongsijianjie"
        label="装修公司简介"
        prop="gongsijianjie"
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
          v-html="ruleForm.gongsijianjie"
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
        shhf: "",
        clicktime: "",
      },

      rules: {
        gongsimingcheng: [
          { required: true, message: "装修公司名称不能为空", trigger: "blur" },
        ],
        mima: [{ required: true, message: "密码不能为空", trigger: "blur" }],
        fuzeren: [],
        gongsifengmian: [],
        lianxifangshi: [],
        gongsiyouxiang: [{ validator: validateEmail, trigger: "blur" }],
        gongsidizhi: [],
        chuanglishijian: [],
        shejituandui: [],
        gongsijianjie: [],
        sfsh: [],
        shhf: [],
        clicktime: [],
        clicknum: [{ validator: validateIntNumber, trigger: "blur" }],
        storeupnum: [{ validator: validateIntNumber, trigger: "blur" }],
      },
    };
  },
  props: ["parent"],
  computed: {},
  components: {},
  created() {
    this.ruleForm.chuanglishijian = this.getCurDate();
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
            this.ruleForm.gongsifengmian = obj[o];
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
    },
    // 多级联动参数

    info(id) {
      this.$http({
        url: `gongsi/info/${id}`,
        method: "get",
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
          //解决前台上传图片后台不显示的问题
          let reg = new RegExp("../../../upload", "g"); //g代表全部
          this.ruleForm.gongsijianjie = this.ruleForm.gongsijianjie.replace(
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
      if (this.ruleForm.gongsifengmian != null) {
        this.ruleForm.gongsifengmian = this.ruleForm.gongsifengmian.replace(
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
              url: "gongsi/page",
              method: "get",
              params: params,
            }).then(({ data }) => {
              if (data && data.code === 0) {
                if (data.data.total >= crossoptnum) {
                  this.$message.error(this.$storage.get("tips"));
                  return false;
                } else {
                  this.$http({
                    url: `gongsi/${!this.ruleForm.id ? "save" : "update"}`,
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
                          this.parent.gongsiCrossAddOrUpdateFlag = false;
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
              url: `gongsi/${!this.ruleForm.id ? "save" : "update"}`,
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
                    this.parent.gongsiCrossAddOrUpdateFlag = false;
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
      this.parent.gongsiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    gongsifengmianUploadChange(fileUrls) {
      this.ruleForm.gongsifengmian = fileUrls;
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
