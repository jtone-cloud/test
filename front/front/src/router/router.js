import VueRouter from "vue-router";

//引入组件
import Index from "../pages";
import Home from "../pages/home/home";
import Login from "../pages/login/login";
import Register from "../pages/register/register";
import Center from "../pages/center/center";
import Forum from "../pages/forum/list";
import ForumAdd from "../pages/forum/add";
import ForumDetail from "../pages/forum/detail";
import MyForumList from "../pages/forum/myForumList";
import Storeup from "../pages/storeup/list";
import News from "../pages/news/news-list";
import NewsDetail from "../pages/news/news-detail";
import payList from "../pages/pay";

import yezhuList from "../pages/yezhu/list";
import yezhuDetail from "../pages/yezhu/detail";
import yezhuAdd from "../pages/yezhu/add";
import gongsiList from "../pages/gongsi/list";
import gongsiDetail from "../pages/gongsi/detail";
import gongsiAdd from "../pages/gongsi/add";
import fenleiList from "../pages/fenlei/list";
import fenleiDetail from "../pages/fenlei/detail";
import fenleiAdd from "../pages/fenlei/add";
import zhuangxiugonglveList from "../pages/zhuangxiugonglve/list";
import zhuangxiugonglveDetail from "../pages/zhuangxiugonglve/detail";
import zhuangxiugonglveAdd from "../pages/zhuangxiugonglve/add";
import xiaoguotuList from "../pages/xiaoguotu/list";
import xiaoguotuDetail from "../pages/xiaoguotu/detail";
import xiaoguotuAdd from "../pages/xiaoguotu/add";
import fangwuxinxiList from "../pages/fangwuxinxi/list";
import fangwuxinxiDetail from "../pages/fangwuxinxi/detail";
import fangwuxinxiAdd from "../pages/fangwuxinxi/add";
import yuyuexinxiList from "../pages/yuyuexinxi/list";
import yuyuexinxiDetail from "../pages/yuyuexinxi/detail";
import yuyuexinxiAdd from "../pages/yuyuexinxi/add";
import fangwushejiList from "../pages/fangwusheji/list";
import fangwushejiDetail from "../pages/fangwusheji/detail";
import fangwushejiAdd from "../pages/fangwusheji/add";
import zhuangxiuwentiList from "../pages/zhuangxiuwenti/list";
import zhuangxiuwentiDetail from "../pages/zhuangxiuwenti/detail";
import zhuangxiuwentiAdd from "../pages/zhuangxiuwenti/add";
import xiangmujinduList from "../pages/xiangmujindu/list";
import xiangmujinduDetail from "../pages/xiangmujindu/detail";
import xiangmujinduAdd from "../pages/xiangmujindu/add";
import pingjiaxinxiList from "../pages/pingjiaxinxi/list";
import pingjiaxinxiDetail from "../pages/pingjiaxinxi/detail";
import pingjiaxinxiAdd from "../pages/pingjiaxinxi/add";
import liuyanxinxiList from "../pages/liuyanxinxi/list";
import liuyanxinxiDetail from "../pages/liuyanxinxi/detail";
import liuyanxinxiAdd from "../pages/liuyanxinxi/add";
import newstypeList from "../pages/newstype/list";
import newstypeDetail from "../pages/newstype/detail";
import newstypeAdd from "../pages/newstype/add";
import aboutusList from "../pages/aboutus/list";
import aboutusDetail from "../pages/aboutus/detail";
import aboutusAdd from "../pages/aboutus/add";
import systemintroList from "../pages/systemintro/list";
import systemintroDetail from "../pages/systemintro/detail";
import systemintroAdd from "../pages/systemintro/add";

const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch((err) => err);
};

//配置路由
export default new VueRouter({
  routes: [
    {
      path: "/",
      redirect: "/index/home",
    },
    {
      path: "/index",
      component: Index,
      children: [
        {
          path: "home",
          component: Home,
        },
        {
          path: "center",
          component: Center,
        },
        {
          path: "pay",
          component: payList,
        },
        {
          path: "forum",
          component: Forum,
        },
        {
          path: "forumAdd",
          component: ForumAdd,
        },
        {
          path: "forumDetail",
          component: ForumDetail,
        },
        {
          path: "myForumList",
          component: MyForumList,
        },
        {
          path: "storeup",
          component: Storeup,
        },
        {
          path: "news",
          component: News,
        },
        {
          path: "newsDetail",
          component: NewsDetail,
        },
        {
          path: "yezhu",
          component: yezhuList,
        },
        {
          path: "yezhuDetail",
          component: yezhuDetail,
        },
        {
          path: "yezhuAdd",
          component: yezhuAdd,
        },
        {
          path: "gongsi",
          component: gongsiList,
        },
        {
          path: "gongsiDetail",
          component: gongsiDetail,
        },
        {
          path: "gongsiAdd",
          component: gongsiAdd,
        },
        {
          path: "fenlei",
          component: fenleiList,
        },
        {
          path: "fenleiDetail",
          component: fenleiDetail,
        },
        {
          path: "fenleiAdd",
          component: fenleiAdd,
        },
        {
          path: "zhuangxiugonglve",
          component: zhuangxiugonglveList,
        },
        {
          path: "zhuangxiugonglveDetail",
          component: zhuangxiugonglveDetail,
        },
        {
          path: "zhuangxiugonglveAdd",
          component: zhuangxiugonglveAdd,
        },
        {
          path: "xiaoguotu",
          component: xiaoguotuList,
        },
        {
          path: "xiaoguotuDetail",
          component: xiaoguotuDetail,
        },
        {
          path: "xiaoguotuAdd",
          component: xiaoguotuAdd,
        },
        {
          path: "fangwuxinxi",
          component: fangwuxinxiList,
        },
        {
          path: "fangwuxinxiDetail",
          component: fangwuxinxiDetail,
        },
        {
          path: "fangwuxinxiAdd",
          component: fangwuxinxiAdd,
        },
        {
          path: "yuyuexinxi",
          component: yuyuexinxiList,
        },
        {
          path: "yuyuexinxiDetail",
          component: yuyuexinxiDetail,
        },
        {
          path: "yuyuexinxiAdd",
          component: yuyuexinxiAdd,
        },
        {
          path: "fangwusheji",
          component: fangwushejiList,
        },
        {
          path: "fangwushejiDetail",
          component: fangwushejiDetail,
        },
        {
          path: "fangwushejiAdd",
          component: fangwushejiAdd,
        },
        {
          path: "zhuangxiuwenti",
          component: zhuangxiuwentiList,
        },
        {
          path: "zhuangxiuwentiDetail",
          component: zhuangxiuwentiDetail,
        },
        {
          path: "zhuangxiuwentiAdd",
          component: zhuangxiuwentiAdd,
        },
        {
          path: "xiangmujindu",
          component: xiangmujinduList,
        },
        {
          path: "xiangmujinduDetail",
          component: xiangmujinduDetail,
        },
        {
          path: "xiangmujinduAdd",
          component: xiangmujinduAdd,
        },
        {
          path: "pingjiaxinxi",
          component: pingjiaxinxiList,
        },
        {
          path: "pingjiaxinxiDetail",
          component: pingjiaxinxiDetail,
        },
        {
          path: "pingjiaxinxiAdd",
          component: pingjiaxinxiAdd,
        },
        {
          path: "liuyanxinxi",
          component: liuyanxinxiList,
        },
        {
          path: "liuyanxinxiDetail",
          component: liuyanxinxiDetail,
        },
        {
          path: "liuyanxinxiAdd",
          component: liuyanxinxiAdd,
        },
        {
          path: "newstype",
          component: newstypeList,
        },
        {
          path: "newstypeDetail",
          component: newstypeDetail,
        },
        {
          path: "newstypeAdd",
          component: newstypeAdd,
        },
        {
          path: "aboutus",
          component: aboutusList,
        },
        {
          path: "aboutusDetail",
          component: aboutusDetail,
        },
        {
          path: "aboutusAdd",
          component: aboutusAdd,
        },
        {
          path: "systemintro",
          component: systemintroList,
        },
        {
          path: "systemintroDetail",
          component: systemintroDetail,
        },
        {
          path: "systemintroAdd",
          component: systemintroAdd,
        },
      ],
    },
    {
      path: "/login",
      component: Login,
    },
    {
      path: "/register",
      component: Register,
    },
  ],
});
