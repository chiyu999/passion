/*
 * @Author: chixiaoyu 
 * @Date: 2023-05-10 21:08:06 
 * @Last Modified by: chixiaoyu
 * @Last Modified time: 2023-05-10 23:33:27
 */
export default {
    state: {
        // 主入口标签页
        mainTabs: [],
        // 当前标签页名
        mainTabsActiveName: ''
    },
    mutations: {
        updateMainTabs(state, tabs) {
            state.mainTabs = tabs
        },
        updateMainTabsActiveName(state, name) {
            state.mainTabsActiveName = name
        }
    }
}
