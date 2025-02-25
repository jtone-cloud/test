const menu = {
  list() {
    return [
      {
        backMenu: [
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-attentionfavor",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "业主",
                menuJump: "列表",
                tableName: "yezhu",
              },
            ],
            menu: "业主管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核", "预约"],
                appFrontIcon: "cuIcon-flashlightopen",
                buttons: ["新增", "查看", "修改", "删除", "审核"],
                menu: "装修公司",
                menuJump: "列表",
                tableName: "gongsi",
              },
            ],
            menu: "装修公司管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-medal",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "分类",
                menuJump: "列表",
                tableName: "fenlei",
              },
            ],
            menu: "分类管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-goods",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "装修攻略",
                menuJump: "列表",
                tableName: "zhuangxiugonglve",
              },
            ],
            menu: "装修攻略管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核"],
                appFrontIcon: "cuIcon-explore",
                buttons: ["查看", "修改", "删除", "审核"],
                menu: "效果图",
                menuJump: "列表",
                tableName: "xiaoguotu",
              },
            ],
            menu: "效果图管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-medal",
                buttons: ["查看", "修改", "删除"],
                menu: "房屋信息",
                menuJump: "列表",
                tableName: "fangwuxinxi",
              },
            ],
            menu: "房屋信息管理",
          },
          {
            child: [
              {
                allButtons: [
                  "新增",
                  "查看",
                  "修改",
                  "删除",
                  "审核",
                  "设计方案",
                ],
                appFrontIcon: "cuIcon-send",
                buttons: ["查看", "修改", "删除"],
                menu: "预约信息",
                menuJump: "列表",
                tableName: "yuyuexinxi",
              },
            ],
            menu: "预约信息管理",
          },
          {
            child: [
              {
                allButtons: [
                  "新增",
                  "查看",
                  "修改",
                  "删除",
                  "支付",
                  "问题",
                  "进度",
                ],
                appFrontIcon: "cuIcon-present",
                buttons: ["查看", "修改", "删除"],
                menu: "房屋设计",
                menuJump: "列表",
                tableName: "fangwusheji",
              },
            ],
            menu: "房屋设计管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核"],
                appFrontIcon: "cuIcon-pic",
                buttons: ["查看", "修改", "删除"],
                menu: "装修问题",
                menuJump: "列表",
                tableName: "zhuangxiuwenti",
              },
            ],
            menu: "装修问题管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "评价"],
                appFrontIcon: "cuIcon-addressbook",
                buttons: ["查看", "修改", "删除"],
                menu: "项目进度",
                menuJump: "列表",
                tableName: "xiangmujindu",
              },
            ],
            menu: "项目进度管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-keyboard",
                buttons: ["查看", "修改", "删除"],
                menu: "评价信息",
                menuJump: "列表",
                tableName: "pingjiaxinxi",
              },
            ],
            menu: "评价信息管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核"],
                appFrontIcon: "cuIcon-wenzi",
                buttons: ["查看", "修改", "删除", "审核"],
                menu: "留言信息",
                menuJump: "列表",
                tableName: "liuyanxinxi",
              },
            ],
            menu: "留言信息管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-group",
                buttons: ["查看", "修改", "删除"],
                menu: "装修交流",
                tableName: "forum",
              },
            ],
            menu: "装修交流",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "公告信息分类",
                tableName: "newstype",
              },
              {
                allButtons: ["查看", "修改"],
                appFrontIcon: "cuIcon-goodsnew",
                buttons: ["查看", "修改"],
                menu: "关于我们",
                tableName: "aboutus",
              },
              {
                allButtons: ["查看", "修改"],
                appFrontIcon: "cuIcon-taxi",
                buttons: ["查看", "修改"],
                menu: "系统简介",
                tableName: "systemintro",
              },
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-send",
                buttons: ["查看", "修改"],
                menu: "轮播图管理",
                tableName: "config",
              },
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "公告信息",
                tableName: "news",
              },
            ],
            menu: "系统管理",
          },
        ],
        frontMenu: [
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核", "预约"],
                appFrontIcon: "cuIcon-album",
                buttons: ["查看", "预约"],
                menu: "装修公司列表",
                menuJump: "列表",
                tableName: "gongsi",
              },
            ],
            menu: "装修公司模块",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-clothes",
                buttons: ["查看"],
                menu: "装修攻略列表",
                menuJump: "列表",
                tableName: "zhuangxiugonglve",
              },
            ],
            menu: "装修攻略模块",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核"],
                appFrontIcon: "cuIcon-similar",
                buttons: ["查看"],
                menu: "效果图列表",
                menuJump: "列表",
                tableName: "xiaoguotu",
              },
            ],
            menu: "效果图模块",
          },
        ],
        hasBackLogin: "是",
        hasBackRegister: "否",
        hasFrontLogin: "否",
        hasFrontRegister: "否",
        roleName: "管理员",
        tableName: "users",
      },
      {
        backMenu: [
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-medal",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "房屋信息",
                menuJump: "列表",
                tableName: "fangwuxinxi",
              },
            ],
            menu: "房屋信息管理",
          },
          {
            child: [
              {
                allButtons: [
                  "新增",
                  "查看",
                  "修改",
                  "删除",
                  "审核",
                  "设计方案",
                ],
                appFrontIcon: "cuIcon-send",
                buttons: ["查看", "删除"],
                menu: "预约信息",
                menuJump: "列表",
                tableName: "yuyuexinxi",
              },
            ],
            menu: "预约信息管理",
          },
          {
            child: [
              {
                allButtons: [
                  "新增",
                  "查看",
                  "修改",
                  "删除",
                  "支付",
                  "问题",
                  "进度",
                ],
                appFrontIcon: "cuIcon-present",
                buttons: ["查看", "支付", "问题"],
                menu: "房屋设计",
                menuJump: "列表",
                tableName: "fangwusheji",
              },
            ],
            menu: "房屋设计管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核"],
                appFrontIcon: "cuIcon-pic",
                buttons: ["查看", "删除"],
                menu: "装修问题",
                menuJump: "列表",
                tableName: "zhuangxiuwenti",
              },
            ],
            menu: "装修问题管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "评价"],
                appFrontIcon: "cuIcon-addressbook",
                buttons: ["查看", "评价"],
                menu: "项目进度",
                menuJump: "列表",
                tableName: "xiangmujindu",
              },
            ],
            menu: "项目进度管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-keyboard",
                buttons: ["查看", "删除"],
                menu: "评价信息",
                menuJump: "列表",
                tableName: "pingjiaxinxi",
              },
            ],
            menu: "评价信息管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核"],
                appFrontIcon: "cuIcon-wenzi",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "留言信息",
                menuJump: "列表",
                tableName: "liuyanxinxi",
              },
            ],
            menu: "留言信息管理",
          },
        ],
        frontMenu: [
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核", "预约"],
                appFrontIcon: "cuIcon-album",
                buttons: ["查看", "预约"],
                menu: "装修公司列表",
                menuJump: "列表",
                tableName: "gongsi",
              },
            ],
            menu: "装修公司模块",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-clothes",
                buttons: ["查看"],
                menu: "装修攻略列表",
                menuJump: "列表",
                tableName: "zhuangxiugonglve",
              },
            ],
            menu: "装修攻略模块",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核"],
                appFrontIcon: "cuIcon-similar",
                buttons: ["查看"],
                menu: "效果图列表",
                menuJump: "列表",
                tableName: "xiaoguotu",
              },
            ],
            menu: "效果图模块",
          },
        ],
        hasBackLogin: "否",
        hasBackRegister: "否",
        hasFrontLogin: "是",
        hasFrontRegister: "是",
        roleName: "业主",
        tableName: "yezhu",
      },
      {
        backMenu: [
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核"],
                appFrontIcon: "cuIcon-explore",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "效果图",
                menuJump: "列表",
                tableName: "xiaoguotu",
              },
            ],
            menu: "效果图管理",
          },
          {
            child: [
              {
                allButtons: [
                  "新增",
                  "查看",
                  "修改",
                  "删除",
                  "审核",
                  "设计方案",
                ],
                appFrontIcon: "cuIcon-send",
                buttons: ["查看", "审核", "设计方案"],
                menu: "预约信息",
                menuJump: "列表",
                tableName: "yuyuexinxi",
              },
            ],
            menu: "预约信息管理",
          },
          {
            child: [
              {
                allButtons: [
                  "新增",
                  "查看",
                  "修改",
                  "删除",
                  "支付",
                  "问题",
                  "进度",
                ],
                appFrontIcon: "cuIcon-present",
                buttons: ["查看", "删除", "进度"],
                menu: "房屋设计",
                menuJump: "列表",
                tableName: "fangwusheji",
              },
            ],
            menu: "房屋设计管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核"],
                appFrontIcon: "cuIcon-pic",
                buttons: ["查看", "审核"],
                menu: "装修问题",
                menuJump: "列表",
                tableName: "zhuangxiuwenti",
              },
            ],
            menu: "装修问题管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "评价"],
                appFrontIcon: "cuIcon-addressbook",
                buttons: ["查看", "删除"],
                menu: "项目进度",
                menuJump: "列表",
                tableName: "xiangmujindu",
              },
            ],
            menu: "项目进度管理",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-keyboard",
                buttons: ["查看"],
                menu: "评价信息",
                menuJump: "列表",
                tableName: "pingjiaxinxi",
              },
            ],
            menu: "评价信息管理",
          },
        ],
        frontMenu: [
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核", "预约"],
                appFrontIcon: "cuIcon-album",
                buttons: ["查看", "预约"],
                menu: "装修公司列表",
                menuJump: "列表",
                tableName: "gongsi",
              },
            ],
            menu: "装修公司模块",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除"],
                appFrontIcon: "cuIcon-clothes",
                buttons: ["查看"],
                menu: "装修攻略列表",
                menuJump: "列表",
                tableName: "zhuangxiugonglve",
              },
            ],
            menu: "装修攻略模块",
          },
          {
            child: [
              {
                allButtons: ["新增", "查看", "修改", "删除", "审核"],
                appFrontIcon: "cuIcon-similar",
                buttons: ["查看"],
                menu: "效果图列表",
                menuJump: "列表",
                tableName: "xiaoguotu",
              },
            ],
            menu: "效果图模块",
          },
        ],
        hasBackLogin: "是",
        hasBackRegister: "是",
        hasFrontLogin: "否",
        hasFrontRegister: "否",
        roleName: "装修公司",
        tableName: "gongsi",
      },
    ];
  },
};
export default menu;
