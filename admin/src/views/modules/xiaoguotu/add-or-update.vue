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
          label="标题"
          prop="biaoti"
        >
          <el-input
            v-model="ruleForm.biaoti"
            placeholder="标题"
            clearable
            :readonly="ro.biaoti"
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
          label="标题"
          prop="biaoti"
        >
          <el-input
            v-model="ruleForm.biaoti"
            placeholder="标题"
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
          label="空间"
          prop="kongjian"
        >
          <el-select
            :disabled="ro.kongjian"
            v-model="ruleForm.kongjian"
            placeholder="请选择空间"
          >
            <el-option
              v-for="(item, index) in kongjianOptions"
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
          label="空间"
          prop="kongjian"
        >
          <el-input
            v-model="ruleForm.kongjian"
            placeholder="空间"
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
          label="风格"
          prop="fengge"
        >
          <el-select
            :disabled="ro.fengge"
            v-model="ruleForm.fengge"
            placeholder="请选择风格"
          >
            <el-option
              v-for="(item, index) in fenggeOptions"
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
          label="风格"
          prop="fengge"
        >
          <el-input
            v-model="ruleForm.fengge"
            placeholder="风格"
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
          label="颜色"
          prop="yanse"
        >
          <el-select
            :disabled="ro.yanse"
            v-model="ruleForm.yanse"
            placeholder="请选择颜色"
          >
            <el-option
              v-for="(item, index) in yanseOptions"
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
          label="颜色"
          prop="yanse"
        >
          <el-input
            v-model="ruleForm.yanse"
            placeholder="颜色"
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
          v-if="type != 'info' && !ro.xiaoguotu"
          label="效果图"
          prop="xiaoguotu"
        >
          <file-upload
            tip="点击上传效果图"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.xiaoguotu ? ruleForm.xiaoguotu : ''"
            @change="xiaoguotuUploadChange"
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
          v-else-if="ruleForm.xiaoguotu"
          label="效果图"
          prop="xiaoguotu"
        >
          <img
            v-if="ruleForm.xiaoguotu.substring(0, 4) == 'http'"
            class="upload-img"
            style="margin-right: 20px"
            v-bind:key="index"
            :src="ruleForm.xiaoguotu.split(',')[0]"
            width="100"
            height="100"
          />
          <img
            v-else
            class="upload-img"
            style="margin-right: 20px"
            v-bind:key="index"
            v-for="(item, index) in ruleForm.xiaoguotu.split(',')"
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
          class="date"
          v-if="type != 'info'"
          label="发布时间"
          prop="fabushijian"
        >
          <el-date-picker
            format="yyyy 年 MM 月 dd 日"
            value-format="yyyy-MM-dd"
            v-model="ruleForm.fabushijian"
            type="date"
            :readonly="ro.fabushijian"
            placeholder="发布时间"
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
          v-else-if="ruleForm.fabushijian"
          label="发布时间"
          prop="fabushijian"
        >
          <el-input
            v-model="ruleForm.fabushijian"
            placeholder="发布时间"
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
        label="家具布置"
        prop="jiajubuzhi"
      >
        <el-input
          style="min-width: 200px; max-width: 600px"
          type="textarea"
          :rows="8"
          placeholder="家具布置"
          v-model="ruleForm.jiajubuzhi"
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
        v-else-if="ruleForm.jiajubuzhi"
        label="家具布置"
        prop="jiajubuzhi"
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
          >{{ ruleForm.jiajubuzhi }}</span
        >
      </el-form-item>
      <el-form-item
        :style="{
          width: '48%',
          margin: '0 0 30px 0',
          fontSize: 'inherit',
          color: 'inherit',
        }"
        class="textarea"
        v-if="type != 'info'"
        label="材料说明"
        prop="cailiaoshuoming"
      >
        <el-input
          style="min-width: 200px; max-width: 600px"
          type="textarea"
          :rows="8"
          placeholder="材料说明"
          v-model="ruleForm.cailiaoshuoming"
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
        v-else-if="ruleForm.cailiaoshuoming"
        label="材料说明"
        prop="cailiaoshuoming"
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
          >{{ ruleForm.cailiaoshuoming }}</span
        >
      </el-form-item>
      <el-form-item
        :style="{
          width: '48%',
          margin: '0 0 30px 0',
          fontSize: 'inherit',
          color: 'inherit',
        }"
        class="textarea"
        v-if="type != 'info'"
        label="装饰细节"
        prop="zhuangshixijie"
      >
        <el-input
          style="min-width: 200px; max-width: 600px"
          type="textarea"
          :rows="8"
          placeholder="装饰细节"
          v-model="ruleForm.zhuangshixijie"
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
        v-else-if="ruleForm.zhuangshixijie"
        label="装饰细节"
        prop="zhuangshixijie"
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
          >{{ ruleForm.zhuangshixijie }}</span
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
        label="详情"
        prop="xiangqing"
      >
        <editor
          style="min-width: 200px; max-width: 600px"
          v-model="ruleForm.xiangqing"
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
        v-else-if="ruleForm.xiangqing"
        label="详情"
        prop="xiangqing"
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
          v-html="ruleForm.xiangqing"
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
        biaoti: false,
        kongjian: false,
        fengge: false,
        yanse: false,
        xiaoguotu: false,
        jiajubuzhi: false,
        cailiaoshuoming: false,
        zhuangshixijie: false,
        xiangqing: false,
        fabushijian: false,
        gongsimingcheng: false,
        fuzeren: false,
        sfsh: false,
        shhf: false,
        clicktime: false,
        clicknum: false,
        storeupnum: false,
      },

      ruleForm: {
        biaoti: "",
        kongjian: "",
        fengge: "",
        yanse: "",
        xiaoguotu: "",
        jiajubuzhi: "",
        cailiaoshuoming: "",
        zhuangshixijie: "",
        xiangqing: "",
        fabushijian: "",
        gongsimingcheng: "",
        fuzeren: "",
        shhf: "",
        clicktime: "",
      },

      kongjianOptions: [],
      fenggeOptions: [],
      yanseOptions: [],

      rules: {
        biaoti: [],
        kongjian: [],
        fengge: [],
        yanse: [],
        xiaoguotu: [],
        jiajubuzhi: [],
        cailiaoshuoming: [],
        zhuangshixijie: [],
        xiangqing: [],
        fabushijian: [],
        gongsimingcheng: [],
        fuzeren: [],
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
    this.ruleForm.fabushijian = this.getCurDate();
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
          if (o == "biaoti") {
            this.ruleForm.biaoti = obj[o];
            this.ro.biaoti = true;
            continue;
          }
          if (o == "kongjian") {
            this.ruleForm.kongjian = obj[o];
            this.ro.kongjian = true;
            continue;
          }
          if (o == "fengge") {
            this.ruleForm.fengge = obj[o];
            this.ro.fengge = true;
            continue;
          }
          if (o == "yanse") {
            this.ruleForm.yanse = obj[o];
            this.ro.yanse = true;
            continue;
          }
          if (o == "xiaoguotu") {
            this.ruleForm.xiaoguotu = obj[o];
            this.ro.xiaoguotu = true;
            continue;
          }
          if (o == "jiajubuzhi") {
            this.ruleForm.jiajubuzhi = obj[o];
            this.ro.jiajubuzhi = true;
            continue;
          }
          if (o == "cailiaoshuoming") {
            this.ruleForm.cailiaoshuoming = obj[o];
            this.ro.cailiaoshuoming = true;
            continue;
          }
          if (o == "zhuangshixijie") {
            this.ruleForm.zhuangshixijie = obj[o];
            this.ro.zhuangshixijie = true;
            continue;
          }
          if (o == "xiangqing") {
            this.ruleForm.xiangqing = obj[o];
            this.ro.xiangqing = true;
            continue;
          }
          if (o == "fabushijian") {
            this.ruleForm.fabushijian = obj[o];
            this.ro.fabushijian = true;
            continue;
          }
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
          if (
            ((json.gongsimingcheng != "" && json.gongsimingcheng) ||
              json.gongsimingcheng == 0) &&
            this.$storage.get("role") != "管理员"
          ) {
            this.ruleForm.gongsimingcheng = json.gongsimingcheng;
            this.ro.gongsimingcheng = true;
          }
          if (
            ((json.fuzeren != "" && json.fuzeren) || json.fuzeren == 0) &&
            this.$storage.get("role") != "管理员"
          ) {
            this.ruleForm.fuzeren = json.fuzeren;
            this.ro.fuzeren = true;
          }
        } else {
          this.$message.error(data.msg);
        }
      });

      this.kongjianOptions = "客厅,餐厅,主卧,次卧,卫生间,阳台".split(",");
      this.fenggeOptions = "田园风,欧式,中式,简约,其他".split(",");
      this.yanseOptions = "白色,灰色,蓝色,粉色,原木色".split(",");
    },
    // 多级联动参数

    info(id) {
      this.$http({
        url: `xiaoguotu/info/${id}`,
        method: "get",
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
          //解决前台上传图片后台不显示的问题
          let reg = new RegExp("../../../upload", "g"); //g代表全部
          this.ruleForm.xiangqing = this.ruleForm.xiangqing.replace(
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
      if (this.ruleForm.xiaoguotu != null) {
        this.ruleForm.xiaoguotu = this.ruleForm.xiaoguotu.replace(
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
              url: "xiaoguotu/page",
              method: "get",
              params: params,
            }).then(({ data }) => {
              if (data && data.code === 0) {
                if (data.data.total >= crossoptnum) {
                  this.$message.error(this.$storage.get("tips"));
                  return false;
                } else {
                  this.$http({
                    url: `xiaoguotu/${!this.ruleForm.id ? "save" : "update"}`,
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
                          this.parent.xiaoguotuCrossAddOrUpdateFlag = false;
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
              url: `xiaoguotu/${!this.ruleForm.id ? "save" : "update"}`,
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
                    this.parent.xiaoguotuCrossAddOrUpdateFlag = false;
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
      this.parent.xiaoguotuCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    xiaoguotuUploadChange(fileUrls) {
      this.ruleForm.xiaoguotu = fileUrls;
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
