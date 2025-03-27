import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import liuyan from '@/views/modules/liuyan/list'
    import xiangmu from '@/views/modules/xiangmu/list'
    import xiangmuCollection from '@/views/modules/xiangmuCollection/list'
    import xiangmuLiuyan from '@/views/modules/xiangmuLiuyan/list'
    import xiangmuYuyue from '@/views/modules/xiangmuYuyue/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yuangong from '@/views/modules/yuangong/list'
    import zhengce from '@/views/modules/zhengce/list'
    import zhengceCollection from '@/views/modules/zhengceCollection/list'
    import zhengceLiuyan from '@/views/modules/zhengceLiuyan/list'
    import config from '@/views/modules/config/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryXiangmu from '@/views/modules/dictionaryXiangmu/list'
    import dictionaryXiangmuCollection from '@/views/modules/dictionaryXiangmuCollection/list'
    import dictionaryXiangmuYuyueYesno from '@/views/modules/dictionaryXiangmuYuyueYesno/list'
    import dictionaryZhengce from '@/views/modules/dictionaryZhengce/list'
    import dictionaryZhengceCollection from '@/views/modules/dictionaryZhengceCollection/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryXiangmu',
        name: '保险类型',
        component: dictionaryXiangmu
    }
    ,{
        path: '/dictionaryXiangmuCollection',
        name: '收藏表类型',
        component: dictionaryXiangmuCollection
    }
    ,{
        path: '/dictionaryXiangmuYuyueYesno',
        name: '报名状态',
        component: dictionaryXiangmuYuyueYesno
    }
    ,{
        path: '/dictionaryZhengce',
        name: '养老政策类型',
        component: dictionaryZhengce
    }
    ,{
        path: '/dictionaryZhengceCollection',
        name: '收藏表类型',
        component: dictionaryZhengceCollection
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告资讯',
        component: gonggao
      }
    ,{
        path: '/liuyan',
        name: '留言板',
        component: liuyan
      }
    ,{
        path: '/xiangmu',
        name: '项目',
        component: xiangmu
      }
    ,{
        path: '/xiangmuCollection',
        name: '项目收藏',
        component: xiangmuCollection
      }
    ,{
        path: '/xiangmuLiuyan',
        name: '项目留言',
        component: xiangmuLiuyan
      }
    ,{
        path: '/xiangmuYuyue',
        name: '保险参保',
        component: xiangmuYuyue
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/yuangong',
        name: '员工',
        component: yuangong
      }
    ,{
        path: '/zhengce',
        name: '养老政策',
        component: zhengce
      }
    ,{
        path: '/zhengceCollection',
        name: '养老政策收藏',
        component: zhengceCollection
      }
    ,{
        path: '/zhengceLiuyan',
        name: '养老政策留言',
        component: zhengceLiuyan
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
