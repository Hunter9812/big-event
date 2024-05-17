import { createRouter, createWebHistory } from 'vue-router'
import { unauthorized } from '@/net'

const router = createRouter({
    mode: 'history', //默认属性
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'welcome',
            component: () => import('@/views/WelcomeView.vue'),
            children: [
                {
                    path: '',
                    name: 'welcome-login',
                    component: () => import('@/views/welcome/LoginPage.vue'),
                },
                {
                    path: 'register',
                    name: 'welcome-register',
                    component: () => import('@/views/welcome/RegisterPage.vue'),
                },
                {
                    path: 'forget',
                    name: 'welcome-forget',
                    component: () => import('@/views/welcome/ForgetPage.vue'),
                },
            ],
        },
        {
            path: '/index',
            name: 'index',
            redirect: '/index/article-category',
            component: () => import('@/views/IndexView.vue'),
            children: [
                {
                    path: 'article-category',
                    name: 'article-category',
                    component: () =>
                        import('@/views/article/ArticleCategory.vue'),
                },
                {
                    path: 'article-manage',
                    name: 'article-manage',
                    component: () =>
                        import('@/views/article/ArticleManage.vue'),
                },
                {
                    path: 'user-info',
                    name: 'user-info',
                    component: () => import('@/views/user/UserInfo.vue'),
                },
                {
                    path: 'user-avatar',
                    name: 'user-avatar',
                    component: () => import('@/views/user/UserAvatar.vue'),
                },
                {
                    path: 'user-resetPassword',
                    name: 'user-resetPassword',
                    component: () =>
                        import('@/views/user/UserResetPassword.vue'),
                },
            ],
        },
    ],
})
// 导航守卫
router.beforeEach((to, from, next) => {
    // 判断是否需要登录权限
    const isUnauthorized = unauthorized()
    if (to.name.startsWith('welcome') && !isUnauthorized) {
        // 当用户登录时访问welcome(/)会跳转到/index
        next('/index')
    } else if (to.fullPath.startsWith('/index') && isUnauthorized) {
        next('/')
    } else {
        next()
    }
})

export default router
