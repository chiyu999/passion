/*
 * @Author: chixiaoyu 
 * @Date: 2023-05-10 21:08:06 
 * @Last Modified by: chixiaoyu
 * @Last Modified time: 2023-05-10 21:13:38
 */
export default {
    state: {
        navTree: [],  // 导航菜单树
    },
    getters: {
   
    },
    mutations: {
        setNavTree(state, navTree){  // 设置导航菜单树
            state.navTree = navTree;
        }
    },
    actions: {
        
    }
}