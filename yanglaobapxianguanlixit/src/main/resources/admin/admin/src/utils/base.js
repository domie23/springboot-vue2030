const base = {
    get() {
        return {
            url : "http://localhost:8080/yanglaobapxianguanlixit/",
            name: "yanglaobapxianguanlixit",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yanglaobapxianguanlixit/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "养老保险管理系统"
        } 
    }
}
export default base
