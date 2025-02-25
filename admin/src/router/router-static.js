import Vue from "vue";
//配置路由
import VueRouter from "vue-router";
Vue.use(VueRouter);
//1.创建组件
import Index from "@/views/index";
import Home from "@/views/home";
import Login from "@/views/login";
import NotFound from "@/views/404";
import UpdatePassword from "@/views/update-password";
import pay from "@/views/pay";
import register from "@/views/register";
import center from "@/views/center";
import news from "@/views/modules/news/list";
import aboutus from "@/views/modules/aboutus/list";
import yezhu from "@/views/modules/yezhu/list";
import pingjiaxinxi from "@/views/modules/pingjiaxinxi/list";
import gongsi from "@/views/modules/gongsi/list";
import yuyuexinxi from "@/views/modules/yuyuexinxi/list";
import liuyanxinxi from "@/views/modules/liuyanxinxi/list";
import fenlei from "@/views/modules/fenlei/list";
import fangwuxinxi from "@/views/modules/fangwuxinxi/list";
import forum from "@/views/modules/forum/list";
import xiangmujindu from "@/views/modules/xiangmujindu/list";
import systemintro from "@/views/modules/systemintro/list";
import fangwusheji from "@/views/modules/fangwusheji/list";
import xiaoguotu from "@/views/modules/xiaoguotu/list";
import zhuangxiugonglve from "@/views/modules/zhuangxiugonglve/list";
import config from "@/views/modules/config/list";
import zhuangxiuwenti from "@/views/modules/zhuangxiuwenti/list";
import newstype from "@/views/modules/newstype/list";

//2.配置路由   注意：名字
export const routes = [
  {
    path: "/",
    name: "系统首页",
    component: Index,
    children: [
      {
        // 这里不设置值，是把main作为默认页面
        path: "/",
        name: "系统首页",
        component: Home,
        meta: { icon: "", title: "center", affix: true },
      },
      {
        path: "/updatePassword",
        name: "修改密码",
        component: UpdatePassword,
        meta: { icon: "", title: "updatePassword" },
      },
      {
        path: "/pay",
        name: "支付",
        component: pay,
        meta: { icon: "", title: "pay" },
      },
      {
        path: "/center",
        name: "个人信息",
        component: center,
        meta: { icon: "", title: "center" },
      },
      {
        path: "/news",
        name: "公告信息",
        component: news,
      },
      {
        path: "/aboutus",
        name: "关于我们",
        component: aboutus,
      },
      {
        path: "/yezhu",
        name: "业主",
        component: yezhu,
      },
      {
        path: "/pingjiaxinxi",
        name: "评价信息",
        component: pingjiaxinxi,
      },
      {
        path: "/gongsi",
        name: "装修公司",
        component: gongsi,
      },
      {
        path: "/yuyuexinxi",
        name: "预约信息",
        component: yuyuexinxi,
      },
      {
        path: "/liuyanxinxi",
        name: "留言信息",
        component: liuyanxinxi,
      },
      {
        path: "/fenlei",
        name: "分类",
        component: fenlei,
      },
      {
        path: "/fangwuxinxi",
        name: "房屋信息",
        component: fangwuxinxi,
      },
      {
        path: "/forum",
        name: "装修交流",
        component: forum,
      },
      {
        path: "/xiangmujindu",
        name: "项目进度",
        component: xiangmujindu,
      },
      {
        path: "/systemintro",
        name: "系统简介",
        component: systemintro,
      },
      {
        path: "/fangwusheji",
        name: "房屋设计",
        component: fangwusheji,
      },
      {
        path: "/xiaoguotu",
        name: "效果图",
        component: xiaoguotu,
      },
      {
        path: "/zhuangxiugonglve",
        name: "装修攻略",
        component: zhuangxiugonglve,
      },
      {
        path: "/config",
        name: "轮播图管理",
        component: config,
      },
      {
        path: "/zhuangxiuwenti",
        name: "装修问题",
        component: zhuangxiuwenti,
      },
      {
        path: "/newstype",
        name: "公告信息分类",
        component: newstype,
      },
    ],
  },
  {
    path: "/login",
    name: "login",
    component: Login,
    meta: { icon: "", title: "login" },
  },
  {
    path: "/register",
    name: "register",
    component: register,
    meta: { icon: "", title: "register" },
  },
  {
    path: "*",
    component: NotFound,
  },
];
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: "hash",
  /*hash模式改为history*/
  routes, // （缩写）相当于 routes: routes
});
const originalPush = VueRouter.prototype.push;
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch((err) => err);
};
export default router;
