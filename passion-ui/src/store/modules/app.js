//应用内的全局性配置，主题色，导航栏伸缩状态等

export default {
    state: {
        appName: "Passion Platform", //应用名称
        themeColor: "#14889a",  //主题颜色
        oldThemeColor: "#14889a", //上次主题颜色
        collapse: false, //导航栏收缩状态
        menuRouterLoaded: false //菜单和路由是否已加载完成
    },
    getters: {
        collapse(state){
            return state.collapse //对应着上面的state
        }
    },
    mutations: {
        onCollapse(state){  // 改变收缩状态
            state.collapse = !state.collapse
        },
        setThemeColor(state, themeColor){  // 改变主题颜色
            state.oldThemeColor = state.themeColor
            state.themeColor = themeColor
        },
        menuRouteLoaded(state, menuRouteLoaded){  // 改变菜单和路由的加载状态
            state.menuRouteLoaded = menuRouteLoaded;
        }
    },
    actions: {
    }
}