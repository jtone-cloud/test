const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootlqyk36m6/",
            name: "springbootlqyk36m6",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootlqyk36m6/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "家居装修管理系统"
        } 
    }
}
export default base
