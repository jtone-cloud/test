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
          class="date"
          v-if="type != 'info'"
          label="预约时间"
          prop="yuyueshijian"
        >
          <el-date-picker
            value-format="yyyy-MM-dd HH:mm:ss"
            v-model="ruleForm.yuyueshijian"
            type="datetime"
            :readonly="ro.yuyueshijian"
            placeholder="预约时间"
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
          v-else-if="ruleForm.yuyueshijian"
          label="预约时间"
          prop="yuyueshijian"
        >
          <el-input
            v-model="ruleForm.yuyueshijian"
            placeholder="预约时间"
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
          label="房屋名称"
          prop="fangwumingcheng"
        >
          <el-select
            :disabled="ro.fangwumingcheng"
            @change="fangwumingchengChange"
            v-model="ruleForm.fangwumingcheng"
            placeholder="请选择房屋名称"
          >
            <el-option
              v-for="(item, index) in fangwumingchengOptions"
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
          class="input"
          v-else-if="ruleForm.fangwumingcheng"
          label="房屋名称"
          prop="fangwumingcheng"
        >
          <el-input
            v-model="ruleForm.fangwumingcheng"
            placeholder="房屋名称"
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
          label="楼层"
          prop="louceng"
        >
          <el-input
            v-model="ruleForm.louceng"
            placeholder="楼层"
            clearable
            :readonly="ro.louceng"
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
          label="楼层"
          prop="louceng"
        >
          <el-input
            v-model="ruleForm.louceng"
            placeholder="楼层"
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
          label="房间号"
          prop="fangjianhao"
        >
          <el-input
            v-model="ruleForm.fangjianhao"
            placeholder="房间号"
            clearable
            :readonly="ro.fangjianhao"
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
          label="房间号"
          prop="fangjianhao"
        >
          <el-input
            v-model="ruleForm.fangjianhao"
            placeholder="房间号"
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
          label="面积"
          prop="mianji"
        >
          <el-input
            v-model="ruleForm.mianji"
            placeholder="面积"
            clearable
            :readonly="ro.mianji"
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
          label="面积"
          prop="mianji"
        >
          <el-input
            v-model="ruleForm.mianji"
            placeholder="面积"
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
          label="房型"
          prop="fangxing"
        >
          <el-input
            v-model="ruleForm.fangxing"
            placeholder="房型"
            clearable
            :readonly="ro.fangxing"
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
          label="房型"
          prop="fangxing"
        >
          <el-input
            v-model="ruleForm.fangxing"
            placeholder="房型"
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
          label="位置"
          prop="weizhi"
        >
          <el-input
            v-model="ruleForm.weizhi"
            placeholder="位置"
            clearable
            :readonly="ro.weizhi"
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
          label="位置"
          prop="weizhi"
        >
          <el-input
            v-model="ruleForm.weizhi"
            placeholder="位置"
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
        label="预约内容"
        prop="yuyueneirong"
      >
        <editor
          style="min-width: 200px; max-width: 600px"
          v-model="ruleForm.yuyueneirong"
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
        v-else-if="ruleForm.yuyueneirong"
        label="预约内容"
        prop="yuyueneirong"
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
          v-html="ruleForm.yuyueneirong"
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
        shhf: "",
      },

      fangwumingchengOptions: [],

      rules: {
        gongsimingcheng: [],
        fuzeren: [],
        gongsifengmian: [],
        lianxifangshi: [],
        yuyueshijian: [],
        yuyueneirong: [],
        yezhuzhanghao: [],
        yezhuxingming: [],
        fangwumingcheng: [],
        louceng: [],
        fangjianhao: [],
        mianji: [],
        fangxing: [],
        weizhi: [],
        sfsh: [],
        shhf: [],
      },
    };
  },
  props: ["parent"],
  computed: {},
  components: {},
  created() {
    this.ruleForm.yuyueshijian = this.getCurDateTime();
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
      }

      // 获取用户信息
      this.$http({
        url: `${this.$storage.get("sessionTable")}/session`,
        method: "get",
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
          if (
            ((json.yezhuzhanghao != "" && json.yezhuzhanghao) ||
              json.yezhuzhanghao == 0) &&
            this.$storage.get("role") != "管理员"
          ) {
            this.ruleForm.yezhuzhanghao = json.yezhuzhanghao;
            this.ro.yezhuzhanghao = true;
          }
          if (
            ((json.yezhuxingming != "" && json.yezhuxingming) ||
              json.yezhuxingming == 0) &&
            this.$storage.get("role") != "管理员"
          ) {
            this.ruleForm.yezhuxingming = json.yezhuxingming;
            this.ro.yezhuxingming = true;
          }
        } else {
          this.$message.error(data.msg);
        }
      });

      this.$http({
        url: `option/fangwuxinxi/fangwumingcheng`,
        method: "get",
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.fangwumingchengOptions = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 下二随
    fangwumingchengChange() {
      this.$http({
        url:
          `follow/fangwuxinxi/fangwumingcheng?columnValue=` +
          this.ruleForm.fangwumingcheng,
        method: "get",
      }).then(({ data }) => {
        if (data && data.code === 0) {
          if (data.data.louceng) {
            this.ruleForm.louceng = data.data.louceng;
          }
          if (data.data.fangjianhao) {
            this.ruleForm.fangjianhao = data.data.fangjianhao;
          }
          if (data.data.mianji) {
            this.ruleForm.mianji = data.data.mianji;
          }
          if (data.data.fangxing) {
            this.ruleForm.fangxing = data.data.fangxing;
          }
          if (data.data.weizhi) {
            this.ruleForm.weizhi = data.data.weizhi;
          }
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 多级联动参数

    info(id) {
      this.$http({
        url: `yuyuexinxi/info/${id}`,
        method: "get",
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
          //解决前台上传图片后台不显示的问题
          let reg = new RegExp("../../../upload", "g"); //g代表全部
          this.ruleForm.yuyueneirong = this.ruleForm.yuyueneirong.replace(
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
              url: "yuyuexinxi/page",
              method: "get",
              params: params,
            }).then(({ data }) => {
              if (data && data.code === 0) {
                if (data.data.total >= crossoptnum) {
                  this.$message.error(this.$storage.get("tips"));
                  return false;
                } else {
                  this.$http({
                    url: `yuyuexinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                          this.parent.yuyuexinxiCrossAddOrUpdateFlag = false;
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
              url: `yuyuexinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                    this.parent.yuyuexinxiCrossAddOrUpdateFlag = false;
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
      this.parent.yuyuexinxiCrossAddOrUpdateFlag = false;
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
