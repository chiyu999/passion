// 请求接口汇总模块，聚合所有模块api
// 此模块是一个聚合模块，回合modules目录下的所有子模块api

import * as login from './modules/login'
import * as user from './modules/user'
import * as dept from './modules/dept'
import * as role from './modules/role'
import * as menu from './modules/menu'
import * as dict from './modules/dict'
import * as config from './modules/config'
import * as log from './modules/log'
import * as loginlog from './modules/loginlog'

//默认全部导出
export default {
    login, user, dept, role, menu, dict, config, log, loginlog
}