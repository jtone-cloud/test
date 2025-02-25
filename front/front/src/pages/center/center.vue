<template>
  <div
    class="center-preview"
    :style="{
      padding: '0 7%',
      margin: '20px auto 40px',
      flexWrap: 'wrap',
      background: '#fff',
      display: 'flex',
      width: '100%',
      position: 'relative',
      justifyContent: 'space-between',
    }"
  >
    <div
      class="title"
      :style="{
        margin: '10px 0',
        color: '#fff',
        textAlign: 'center',
        background: '#333',
        width: '100%',
        fontSize: '20px',
        lineHeight: '54px',
      }"
    >
      {{ title }}
    </div>

    <div
      class="info"
      :style="{
        padding: '10px',
        boxShadow: '0 0px 0px rgba(0, 0, 0, 0.3)',
        margin: '20px 3% 0 0',
        borderColor: '#eee',
        borderRadius: '0px',
        background: '#ffffff',
        borderWidth: '4px 2px 1px',
        width: '25%',
        borderStyle: 'solid',
        height: 'auto',
      }"
    >
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          color: '#fff',
          borderWidth: '0 0 1px 0',
          background: '#F5BB00',
          width: '100%',
          lineHeight: '44px',
          fontSize: '15px',
          borderStyle: 'solid',
          height: '44px',
        }"
      >
        个人信息
      </div>
      <div
        :style="{
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          width: '90%',
          fontSize: 0,
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yezhu'"
      >
        <el-image
          :style="{
            margin: '10px auto',
            borderColor: '#efefef',
            objectFit: 'cover',
            borderRadius: '100%',
            borderWidth: '0 0 1px 0',
            display: 'block',
            width: '80px',
            borderStyle: 'solid',
            height: '80px',
          }"
          :src="
            sessionForm.touxiang
              ? baseUrl + sessionForm.touxiang
              : require('@/assets/avator.png')
          "
          fit="cover"
        ></el-image>
      </div>
      <div
        :style="{
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          width: '90%',
          fontSize: 0,
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'gongsi'"
      >
        <el-image
          :style="{
            margin: '10px auto',
            borderColor: '#efefef',
            objectFit: 'cover',
            borderRadius: '100%',
            borderWidth: '0 0 1px 0',
            display: 'block',
            width: '80px',
            borderStyle: 'solid',
            height: '80px',
          }"
          :src="
            sessionForm.gongsifengmian
              ? baseUrl + sessionForm.gongsifengmian
              : require('@/assets/avator.png')
          "
          fit="cover"
        ></el-image>
      </div>
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          display: 'flex',
          width: '90%',
          lineHeight: '40px',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yezhu'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ color: '#333', padding: '0 5px', fontSize: '14px' }"
        ></span>
        <div :style="{ color: '#333', fontSize: '14px' }">业主账号</div>
        <div
          :style="{
            fontSize: '14px',
            color: '#333',
            textAlign: 'right',
            flex: 1,
          }"
        >
          {{ sessionForm.yezhuzhanghao }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          display: 'flex',
          width: '90%',
          lineHeight: '40px',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yezhu'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ color: '#333', padding: '0 5px', fontSize: '14px' }"
        ></span>
        <div :style="{ color: '#333', fontSize: '14px' }">业主姓名</div>
        <div
          :style="{
            fontSize: '14px',
            color: '#333',
            textAlign: 'right',
            flex: 1,
          }"
        >
          {{ sessionForm.yezhuxingming }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          display: 'flex',
          width: '90%',
          lineHeight: '40px',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yezhu'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ color: '#333', padding: '0 5px', fontSize: '14px' }"
        ></span>
        <div :style="{ color: '#333', fontSize: '14px' }">性别</div>
        <div
          :style="{
            fontSize: '14px',
            color: '#333',
            textAlign: 'right',
            flex: 1,
          }"
        >
          {{ sessionForm.xingbie }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          display: 'flex',
          width: '90%',
          lineHeight: '40px',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yezhu'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ color: '#333', padding: '0 5px', fontSize: '14px' }"
        ></span>
        <div :style="{ color: '#333', fontSize: '14px' }">联系方式</div>
        <div
          :style="{
            fontSize: '14px',
            color: '#333',
            textAlign: 'right',
            flex: 1,
          }"
        >
          {{ sessionForm.lianxifangshi }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          display: 'flex',
          width: '90%',
          lineHeight: '40px',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yezhu'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ color: '#333', padding: '0 5px', fontSize: '14px' }"
        ></span>
        <div :style="{ color: '#333', fontSize: '14px' }">密保问题</div>
        <div
          :style="{
            fontSize: '14px',
            color: '#333',
            textAlign: 'right',
            flex: 1,
          }"
        >
          {{ sessionForm.pquestion }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          display: 'flex',
          width: '90%',
          lineHeight: '40px',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'yezhu'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ color: '#333', padding: '0 5px', fontSize: '14px' }"
        ></span>
        <div :style="{ color: '#333', fontSize: '14px' }">密保答案</div>
        <div
          :style="{
            fontSize: '14px',
            color: '#333',
            textAlign: 'right',
            flex: 1,
          }"
        >
          {{ sessionForm.panswer }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          display: 'flex',
          width: '90%',
          lineHeight: '40px',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'gongsi'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ color: '#333', padding: '0 5px', fontSize: '14px' }"
        ></span>
        <div :style="{ color: '#333', fontSize: '14px' }">装修公司名称</div>
        <div
          :style="{
            fontSize: '14px',
            color: '#333',
            textAlign: 'right',
            flex: 1,
          }"
        >
          {{ sessionForm.gongsimingcheng }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          display: 'flex',
          width: '90%',
          lineHeight: '40px',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'gongsi'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ color: '#333', padding: '0 5px', fontSize: '14px' }"
        ></span>
        <div :style="{ color: '#333', fontSize: '14px' }">负责人</div>
        <div
          :style="{
            fontSize: '14px',
            color: '#333',
            textAlign: 'right',
            flex: 1,
          }"
        >
          {{ sessionForm.fuzeren }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          display: 'flex',
          width: '90%',
          lineHeight: '40px',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'gongsi'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ color: '#333', padding: '0 5px', fontSize: '14px' }"
        ></span>
        <div :style="{ color: '#333', fontSize: '14px' }">联系方式</div>
        <div
          :style="{
            fontSize: '14px',
            color: '#333',
            textAlign: 'right',
            flex: 1,
          }"
        >
          {{ sessionForm.lianxifangshi }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          display: 'flex',
          width: '90%',
          lineHeight: '40px',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'gongsi'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ color: '#333', padding: '0 5px', fontSize: '14px' }"
        ></span>
        <div :style="{ color: '#333', fontSize: '14px' }">装修公司邮箱</div>
        <div
          :style="{
            fontSize: '14px',
            color: '#333',
            textAlign: 'right',
            flex: 1,
          }"
        >
          {{ sessionForm.gongsiyouxiang }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          display: 'flex',
          width: '90%',
          lineHeight: '40px',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'gongsi'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ color: '#333', padding: '0 5px', fontSize: '14px' }"
        ></span>
        <div :style="{ color: '#333', fontSize: '14px' }">装修公司地址</div>
        <div
          :style="{
            fontSize: '14px',
            color: '#333',
            textAlign: 'right',
            flex: 1,
          }"
        >
          {{ sessionForm.gongsidizhi }}
        </div>
      </div>
      <div
        :style="{
          padding: '0 20px',
          borderColor: '#efefef',
          margin: '0 auto',
          borderWidth: '0 0 1px 0',
          display: 'flex',
          width: '90%',
          lineHeight: '40px',
          borderStyle: 'solid',
          height: 'auto',
        }"
        v-if="userTableName == 'gongsi'"
      >
        <span
          class="icon iconfont icon-shouye-zhihui"
          :style="{ color: '#333', padding: '0 5px', fontSize: '14px' }"
        ></span>
        <div :style="{ color: '#333', fontSize: '14px' }">创立时间</div>
        <div
          :style="{
            fontSize: '14px',
            color: '#333',
            textAlign: 'right',
            flex: 1,
          }"
        >
          {{ sessionForm.chuanglishijian }}
        </div>
      </div>
    </div>

    <el-tabs
      tab-position="left"
      :style="{
        width: '72%',
        margin: '20px 0 0',
        flexWrap: 'wrap',
        background: '#fff',
        flex: '1',
        display: 'flex',
      }"
      @tab-click="handleClick"
    >
      <el-tab-pane label="个人中心">
        <el-form
          class="center-preview-pv"
          ref="sessionForm"
          :model="sessionForm"
          :rules="rules"
          label-width="180px"
        >
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'yezhu'"
            label="业主账号"
            prop="yezhuzhanghao"
          >
            <el-input
              v-model="sessionForm.yezhuzhanghao"
              placeholder="业主账号"
              readonly
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'yezhu'"
            label="业主姓名"
            prop="yezhuxingming"
          >
            <el-input
              v-model="sessionForm.yezhuxingming"
              placeholder="业主姓名"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'yezhu'"
            label="性别"
          >
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别">
              <el-option
                v-for="(item, index) in dynamicProp.xingbie"
                :key="index"
                :label="item"
                :value="item"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'yezhu'"
            label="联系方式"
            prop="lianxifangshi"
          >
            <el-input
              v-model="sessionForm.lianxifangshi"
              placeholder="联系方式"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'yezhu'"
            label="头像"
          >
            <file-upload
              tip="点击上传头像"
              action="file/upload"
              :limit="1"
              :multiple="true"
              :fileUrls="sessionForm.touxiang ? sessionForm.touxiang : ''"
              @change="yezhutouxiangHandleAvatarSuccess"
            ></file-upload>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'yezhu'"
            label="密保问题"
            prop="pquestion"
          >
            <el-input
              v-model="sessionForm.pquestion"
              placeholder="密保问题"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'yezhu'"
            label="密保答案"
            prop="panswer"
          >
            <el-input
              v-model="sessionForm.panswer"
              placeholder="密保答案"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'gongsi'"
            label="装修公司名称"
            prop="gongsimingcheng"
          >
            <el-input
              v-model="sessionForm.gongsimingcheng"
              placeholder="装修公司名称"
              readonly
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'gongsi'"
            label="负责人"
            prop="fuzeren"
          >
            <el-input
              v-model="sessionForm.fuzeren"
              placeholder="负责人"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'gongsi'"
            label="装修公司封面"
          >
            <file-upload
              tip="点击上传装修公司封面"
              action="file/upload"
              :limit="1"
              :multiple="true"
              :fileUrls="
                sessionForm.gongsifengmian ? sessionForm.gongsifengmian : ''
              "
              @change="gongsigongsifengmianHandleAvatarSuccess"
            ></file-upload>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'gongsi'"
            label="联系方式"
            prop="lianxifangshi"
          >
            <el-input
              v-model="sessionForm.lianxifangshi"
              placeholder="联系方式"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'gongsi'"
            label="装修公司邮箱"
            prop="gongsiyouxiang"
          >
            <el-input
              v-model="sessionForm.gongsiyouxiang"
              placeholder="装修公司邮箱"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'gongsi'"
            label="装修公司地址"
            prop="gongsidizhi"
          >
            <el-input
              v-model="sessionForm.gongsidizhi"
              placeholder="装修公司地址"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'gongsi'"
            label="创立时间"
          >
            <el-date-picker
              v-model="sessionForm.chuanglishijian"
              type="date"
              placeholder="创立时间"
            >
            </el-date-picker>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'gongsi'"
            label="设计团队"
            prop="shejituandui"
          >
            <el-input
              v-model="sessionForm.shejituandui"
              placeholder="设计团队"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            v-if="userTableName == 'gongsi'"
            label="装修公司简介"
          >
            <editor
              :style="{
                minHeight: '250px',
                border: '0',
                boxShadow: '0 0 0px rgba(64, 158, 255, .5)',
                outline: 'none',
                color: '#333',
                borderRadius: '4px',
                width: '100%',
                lineHeight: '32px',
                fontSize: '14px',
              }"
              v-model="sessionForm.gongsijianjie"
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
              @click="onSubmit('sessionForm')"
              >更新信息</el-button
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
              type="danger"
              @click="logout"
              >退出登录</el-button
            >
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="修改密码">
        <el-form
          class="center-preview-pv"
          ref="passwordForm"
          :model="passwordForm"
          :rules="passwordRules"
          label-width="180px"
        >
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            label="原密码"
            prop="password"
          >
            <el-input
              type="password"
              v-model="passwordForm.password"
              placeholder="原密码"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            label="新密码"
            prop="newpassword"
          >
            <el-input
              type="password"
              v-model="passwordForm.newpassword"
              placeholder="新密码"
            ></el-input>
          </el-form-item>
          <el-form-item
            :style="{ padding: '10px', margin: '0 0 10px', background: '#fff' }"
            label="确认密码"
            prop="repassword"
          >
            <el-input
              type="password"
              v-model="passwordForm.repassword"
              placeholder="确认密码"
            ></el-input>
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
              @click="updatePassword"
              >修改密码</el-button
            >
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane
        v-for="(item, index) in menuList"
        :key="index"
        v-if="hasBack(item.menu)"
        :label="item.child[0].menu"
        :name="item.child[0].tableName"
      ></el-tab-pane>
      <el-tab-pane label="我的发布"></el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import config from "@/config/config";
import menu from "@/config/menu";
import Vue from "vue";
export default {
  //数据集合
  data() {
    return {
      title: "个人中心",
      baseUrl: config.baseUrl,
      sessionForm: {},
      passwordForm: {},
      passwordRules: {
        password: [
          {
            required: true,
            message: "密码不能为空",
            trigger: "blur",
          },
        ],
        newpassword: [
          {
            required: true,
            message: "新密码不能为空",
            trigger: "blur",
          },
        ],
        repassword: [
          {
            required: true,
            message: "确认密码不能为空",
            trigger: "blur",
          },
        ],
      },
      rules: {},
      menuList: [],
      disabled: false,
      uploadUrl: config.baseUrl + "file/upload",
      imageUrl: "",
      headers: { Token: localStorage.getItem("frontToken") },
      userTableName: localStorage.getItem("UserTableName"),
      dynamicProp: {},
    };
  },
  created() {
    let menus = menu.list();
    for (let x in menus) {
      if (menus[x].tableName == this.userTableName) {
        this.menuList = menus[x].backMenu;
      }
    }
    if ("yezhu" == this.userTableName) {
      this.$set(this.sessionForm, "yezhuzhanghao", null);
    }
    if ("yezhu" == this.userTableName) {
      this.$set(this.sessionForm, "mima", null);
    }
    if ("yezhu" == this.userTableName) {
      this.$set(this.sessionForm, "yezhuxingming", null);
    }
    if ("yezhu" == this.userTableName) {
      this.$set(this.sessionForm, "xingbie", null);
    }
    if ("yezhu" == this.userTableName) {
      this.$set(this.sessionForm, "lianxifangshi", null);
    }
    if ("yezhu" == this.userTableName) {
      this.$set(this.sessionForm, "touxiang", null);
    }
    if ("yezhu" == this.userTableName) {
      this.$set(this.sessionForm, "pquestion", null);
    }
    if ("yezhu" == this.userTableName) {
      this.$set(this.sessionForm, "panswer", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "gongsimingcheng", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "mima", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "fuzeren", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "gongsifengmian", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "lianxifangshi", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "gongsiyouxiang", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "gongsidizhi", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "chuanglishijian", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "shejituandui", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "gongsijianjie", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "sfsh", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "shhf", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "clicktime", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "clicknum", null);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.sessionForm, "storeupnum", null);
    }

    if ("yezhu" == this.userTableName) {
      this.$set(this.rules, "yezhuzhanghao", [
        { required: true, message: "请输入业主账号", trigger: "blur" },
      ]);
    }
    if ("yezhu" == this.userTableName) {
      this.$set(this.rules, "mima", [
        { required: true, message: "请输入密码", trigger: "blur" },
      ]);
    }
    if ("yezhu" == this.userTableName) {
      this.$set(this.rules, "yezhuxingming", [
        { required: true, message: "请输入业主姓名", trigger: "blur" },
      ]);
    }
    if ("yezhu" == this.userTableName) {
      this.$set(this.rules, "lianxifangshi", [
        {
          required: false,
          validator: this.$validate.isMobile,
          trigger: "blur",
        },
      ]);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.rules, "gongsimingcheng", [
        { required: true, message: "请输入装修公司名称", trigger: "blur" },
      ]);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.rules, "mima", [
        { required: true, message: "请输入密码", trigger: "blur" },
      ]);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.rules, "gongsiyouxiang", [
        { required: false, validator: this.$validate.isEmail, trigger: "blur" },
      ]);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.rules, "clicknum", [
        {
          required: false,
          validator: this.$validate.isIntNumer,
          trigger: "blur",
        },
      ]);
    }
    if ("gongsi" == this.userTableName) {
      this.$set(this.rules, "storeupnum", [
        {
          required: false,
          validator: this.$validate.isIntNumer,
          trigger: "blur",
        },
      ]);
    }

    this.init();
    this.sessionForm = JSON.parse(localStorage.getItem("sessionForm"));
  },
  //方法集合
  methods: {
    init() {
      if ("yezhu" == this.userTableName) {
        this.dynamicProp.xingbie = "男,女".split(",");
      }
    },
    setSession() {
      localStorage.setItem("sessionForm", JSON.stringify(this.sessionForm));
    },
    onSubmit(formName) {
      if (`yezhu` == this.userTableName && this.sessionForm.touxiang != null) {
        this.sessionForm.touxiang = this.sessionForm.touxiang.replace(
          new RegExp(this.$config.baseUrl, "g"),
          ""
        );
      }
      if (
        `gongsi` == this.userTableName &&
        this.sessionForm.gongsifengmian != null
      ) {
        this.sessionForm.gongsifengmian =
          this.sessionForm.gongsifengmian.replace(
            new RegExp(this.$config.baseUrl, "g"),
            ""
          );
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http
            .post(this.userTableName + "/update", this.sessionForm)
            .then((res) => {
              if (res.data.code == 0) {
                this.setSession();
                this.$message({
                  message: "更新成功",
                  type: "success",
                  duration: 1500,
                });
              }
            });
        } else {
          return false;
        }
      });
    },
    yezhutouxiangHandleAvatarSuccess(fileUrls) {
      this.sessionForm.touxiang = fileUrls;
    },
    gongsigongsifengmianHandleAvatarSuccess(fileUrls) {
      this.sessionForm.gongsifengmian = fileUrls;
    },
    handleClick(tab, event) {
      switch (event.target.outerText) {
        case "个人中心":
          tab.$router.push("/index/center");
          break;
        case "修改密码":
          this.passwordForm = {
            password: "",
            newpassword: "",
            repassword: "",
          };
          this.$forceUpdate();
          break;
        case "我的发布":
          tab.$router.push("/index/myForumList");
          break;
        case "我的收藏":
          localStorage.setItem("storeupType", 1);
          tab.$router.push("/index/storeup");
          break;
        default:
          tab.$router.push(`/index/${tab.name}?centerType=1`);
      }

      this.title = event.target.outerText;
    },
    async updatePassword() {
      this.$refs["passwordForm"].validate(async (valid) => {
        if (valid) {
          var password = "";
          if (this.sessionForm.mima) {
            password = this.sessionForm.mima;
          } else if (this.sessionForm.password) {
            password = this.sessionForm.password;
          }
          if (this.passwordForm.password != password) {
            this.$message.error("原密码错误");
            return;
          }
          if (this.passwordForm.newpassword != this.passwordForm.repassword) {
            this.$message.error("两次密码输入不一致");
            return;
          }
          if (this.userTableName == "yezhu") {
          }
          this.sessionForm.password = this.passwordForm.newpassword;
          this.sessionForm.mima = this.passwordForm.newpassword;
          this.$http
            .post(`${this.userTableName}/update`, this.sessionForm)
            .then(({ data }) => {
              if (data && data.code === 0) {
                this.$message({
                  message: "修改密码成功,下次登录系统生效",
                  type: "success",
                  duration: 1500,
                  onClose: () => {},
                });
                this.setSession();
              } else {
                this.$message.error(data.msg);
              }
            });
        }
      });
    },
    logout() {
      localStorage.clear();
      Vue.http.headers.common["Token"] = "";
      this.$router.push("/index/home");
      this.activeIndex = "0";
      localStorage.setItem("keyPath", this.activeIndex);
      this.$forceUpdate();
      this.$message({
        message: "登出成功",
        type: "success",
        duration: 1500,
      });
    },
    hasBack(name) {
      switch (name) {
        case "我的收藏管理":
          return false;
          break;
        default:
          return true;
      }
    },
  },
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.center-preview {
  .el-tabs {
    & ::v-deep .el-tabs__header {
      .el-tabs__nav {
        overflow: auto;
      }
      ::-webkit-scrollbar {
        -webkit-appearance: none;
        width: 6px;
        height: 6px;
      }
      ::-webkit-scrollbar-track {
        background: rgba(0, 0, 0, 0.1);
        border-radius: 0;
      }
      ::-webkit-scrollbar-thumb {
        cursor: pointer;
        border-radius: 5px;
        background: rgba(0, 0, 0, 0.15);
        transition: color 0.2s ease;
      }
      ::-webkit-scrollbar-thumb:hover {
        background: rgba(0, 0, 0, 0.3);
      }
      .el-tabs__nav-wrap {
        margin: 0;

        &::after {
          content: none;
        }
      }

      .el-tabs__active-bar {
        display: none !important;
      }
    }

    .center-preview-pv {
      .el-date-editor.el-input {
        width: auto;
      }

      .balance {
        .el-input {
          width: auto;
        }
      }
    }
  }
}

.center-preview .el-tabs ::v-deep .el-tabs__header {
  padding: 0;
  margin: 0;
  background: #fff;
  width: 100%;
  border-color: #eee;
  border-width: 0 0 1px;
  position: relative;
  float: left;
  border-style: solid;
  height: auto;
}

.center-preview .el-tabs ::v-deep .el-tabs__header .el-tabs__item {
  padding: 0 10px;
  margin: 0 10px 10px 0;
  color: #fff;
  font-weight: 500;
  display: block;
  font-size: 14px;
  line-height: 40px;
  float: left;
  background: #333;
  width: auto;
  position: relative;
  text-align: center;
  height: 40px;
}

.center-preview .el-tabs ::v-deep .el-tabs__header .el-tabs__item:hover {
  padding: 0 10px;
  color: #fff;
  background: #f5bb00;
  font-weight: 500;
  font-size: 14px;
  line-height: 40px;
  position: relative;
  text-align: center;
  height: 40px;
}

.center-preview .el-tabs ::v-deep .el-tabs__header .el-tabs__item.is-active {
  padding: 0 10px;
  margin: 0 10px 10px 0;
  color: #fff;
  font-weight: 500;
  display: block;
  font-size: 14px;
  line-height: 40px;
  float: left;
  background: #f5bb00;
  width: auto;
  position: relative;
  text-align: center;
  height: 40px;
}

.center-preview .el-tabs ::v-deep .el-tabs__content {
  padding: 0px;
  margin: 20px 0 0;
  background: #fff;
  width: 100%;
}
.center-preview .el-tabs ::v-deep .el-tabs__content .el-tab-pane {
  width: 100%;
}

.center-preview-pv .el-form-item ::v-deep .el-form-item__label {
  padding: 0 10px 0 0;
  color: #666;
  font-weight: 500;
  width: 180px;
  font-size: 14px;
  line-height: 40px;
  text-align: right;
}

.center-preview-pv .el-form-item .el-form-item__content {
  margin-left: 180px;
}

.center-preview-pv .el-input ::v-deep .el-input__inner {
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 0 12px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: #666;
  width: 400px;
  font-size: 14px;
  height: 40px;
}

.center-preview-pv .el-select ::v-deep .el-input__inner {
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 0 12px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: #666;
  width: 400px;
  font-size: 14px;
  height: 40px;
}

.center-preview-pv .el-date-editor ::v-deep .el-input__inner {
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 0 10px 0 30px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: #666;
  width: 200px;
  font-size: 14px;
  height: 40px;
}

.center-preview-pv ::v-deep .avatar-uploader-icon {
  border: 1px solid #ddd;
  cursor: pointer;
  border-radius: 6px;
  color: #999;
  width: 160px;
  font-size: 32px;
  line-height: 80px;
  text-align: center;
  height: 80px;
}

.center-preview-pv .el-form-item.balance ::v-deep .el-input__inner {
  border: 1px solid #ddd;
  border-radius: 4px 0 0 4px;
  padding: 0 12px;
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
  outline: none;
  color: #666;
  display: inline-block;
  width: 200px;
  font-size: 14px;
  height: 40px;
}
</style>
