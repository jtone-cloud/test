// var webpack = require('webpack');
//vue2
const path = require("path");
// 定义一个函数，用于解析目录路径
function resolve(dir) {
  // 使用path模块的join方法，将当前目录和传入的目录拼接起来
  return path.join(__dirname, dir);
}

// 定义一个函数，用于获取公共路径
function publicPath() {
  // 判断当前环境是否为生产环境
  if (process.env.NODE_ENV == "production") {
    // 如果是生产环境，返回"././"
    return "././";
  } else {
    // 如果不是生产环境，返回"/"
    return "/";
  }
}
// vue.config.js
module.exports = {
  // publicPath:"././",
  publicPath: publicPath(),
  // 国际化配置 使用其它语言，默认情况下中文语言包依旧是被引入的
  configureWebpack: {
    // plugins: [
    //     new webpack.NormalModuleReplacementPlugin(/element-ui[\/\\]lib[\/\\]locale[\/\\]lang[\/\\]zh-CN/, 'element-ui/lib/locale/lang/en')
    // ]
    resolve: {
      modules: ["node_modules"],
      alias: {
        "@": resolve("src"),
      },
    },
  },
  lintOnSave: false,
  devServer: {
    host: "0.0.0.0", //指定使用一个 host。默认是 localhost，这里默认值即可
    port: 8082, //指定端口
    hot: true, // 开启热更新
    https: false, // 是否开启https模式
    // 解决跨域问题
    proxy: {
      // 请求代理服务器
      "/springbootlqyk36m6": {
        //带上api前缀的
        target: "http://localhost:8080/springbootlqyk36m6/", //代理目标地址
        changeOrigin: true,
        secure: false,
        pathRewrite: {
          // 在发出请求后将/api替换为''空值，这样不影响接口请求
          "^/springbootlqyk36m6": "",
        },
      },
    },
  },
  chainWebpack(config) {
    config.module.rule("svg").exclude.add(resolve("src/icons")).end();
    config.module
      .rule("icons")
      .test(/\.svg$/)
      .include.add(resolve("src/icons"))
      .end()
      .use("svg-sprite-loader")
      .loader("svg-sprite-loader")
      .options({
        symbolId: "icon-[name]",
      })
      .end();
  },
};
