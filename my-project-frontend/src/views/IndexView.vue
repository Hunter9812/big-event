<script setup>
import {
    Management,
    Promotion,
    UserFilled,
    User,
    Crop,
    EditPen,
    SwitchButton,
    CaretBottom,
} from '@element-plus/icons-vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import avatar from '@/assets/default.png'
import { logout } from '@/net'
import router from '@/router'
import DarkButton from '@/components/DarkButton/DarkButton.vue'

const handleCommand = command => {
    if (command === 'logout') {
        //退出登录
        ElMessageBox.confirm('您确认退出登录码？', '温馨提示', {
            confirmButtonText: '确认',
            cancelButtonText: '取消',
            type: 'warning',
        })
            .then(async () => {
                //用户点击了确认
                //跳转到登录页
                logout(() => router.push('/'))
            })
            .catch(() => {
                //用户点击了取消
                ElMessage({
                    type: 'info',
                    message: '您已取消退出',
                })
            })
    } else {
        //路由
        router.push('/index/user-' + command)
    }
}
import { ref } from 'vue'
import { get } from '@/net'
const userInfo = ref({})
const getUserInfo = () => {
    get(
        '/api/user/info',
        data => {
            userInfo.value = data
        },
        message => ElMessage.warning(message)
    )
}
getUserInfo()
</script>

<template>
    <div>
        <el-container class="layout-container">
            <!-- 左侧菜单 -->
            <el-aside width="200px">
                <div class="el-aside__logo"></div>
                <el-menu
                    active-text-color="#ffd04b"
                    background-color="#232323"
                    text-color="#fff"
                    router
                >
                    <el-menu-item index="/index/article-category">
                        <el-icon>
                            <Management />
                        </el-icon>
                        <span>文章分类</span>
                    </el-menu-item>
                    <el-menu-item index="/index/article-manage">
                        <el-icon>
                            <Promotion />
                        </el-icon>
                        <span>文章管理</span>
                    </el-menu-item>
                    <el-sub-menu>
                        <template #title>
                            <el-icon>
                                <UserFilled />
                            </el-icon>
                            <span>个人中心</span>
                        </template>
                        <el-menu-item index="/index/user-info">
                            <el-icon>
                                <User />
                            </el-icon>
                            <span>基本资料</span>
                        </el-menu-item>
                        <el-menu-item index="/index/user-avatar">
                            <el-icon>
                                <Crop />
                            </el-icon>
                            <span>更换头像</span>
                        </el-menu-item>
                        <el-menu-item index="/index/user-resetPassword">
                            <el-icon>
                                <EditPen />
                            </el-icon>
                            <span>重置密码</span>
                        </el-menu-item>
                    </el-sub-menu>
                </el-menu>
            </el-aside>
            <!-- 右侧主区域 -->
            <el-container>
                <!-- 头部区域 -->
                <el-header>
                    <div>
                        白马程序员：<strong>{{ userInfo.nickname }}</strong>
                    </div>
                    <div
                        style="
                            display: flex;
                            justify-content: space-between;
                            align-items: center;
                            width: 15vw;
                        "
                    >
                        <DarkButton />
                        <el-dropdown
                            placement="bottom-end"
                            @command="handleCommand"
                        >
                            <span class="el-dropdown__box">
                                <el-avatar
                                    :src="
                                        userInfo.userPic
                                            ? userInfo.userPic
                                            : avatar
                                    "
                                />
                                <el-icon>
                                    <CaretBottom />
                                </el-icon>
                            </span>
                            <template #dropdown>
                                <el-dropdown-menu>
                                    <el-dropdown-item
                                        command="info"
                                        :icon="User"
                                        >基本资料</el-dropdown-item
                                    >
                                    <el-dropdown-item
                                        command="avatar"
                                        :icon="Crop"
                                        >更换头像</el-dropdown-item
                                    >
                                    <el-dropdown-item
                                        command="resetPassword"
                                        :icon="EditPen"
                                        >重置密码</el-dropdown-item
                                    >
                                    <el-dropdown-item
                                        command="logout"
                                        :icon="SwitchButton"
                                        >退出登录</el-dropdown-item
                                    >
                                </el-dropdown-menu>
                            </template>
                        </el-dropdown>
                    </div>
                </el-header>
                <!-- 中间区域 -->
                <el-main>
                    <div style="width: 1290px; height: 570px">
                        <router-view></router-view>
                    </div>
                </el-main>
                <!-- 底部区域 -->
                <el-footer>大事件 ©2023 Created by itbaima</el-footer>
            </el-container>
        </el-container>
    </div>
</template>

<style lang="scss" scoped>
.layout-container {
    height: 100vh;

    .el-aside {
        background-color: #232323;

        &__logo {
            height: 120px;
            background: url('@/assets/logo.png') no-repeat center / 120px auto;
        }

        .el-menu {
            border-right: none;
        }
    }

    .el-header {
        background-color: var(--el-bg-color);
        display: flex;
        align-items: center;
        justify-content: space-between;

        .el-dropdown__box {
            display: flex;
            align-items: center;

            .el-icon {
                color: #999;
                margin-left: 10px;
            }

            &:active,
            &:focus {
                outline: none;
            }
        }
    }

    .el-footer {
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 14px;
        color: #666;
    }
}
</style>
