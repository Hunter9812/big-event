<template>
    <div style="width: 100vw; height: 100vh; overflow: hidden; display: flex">
        <div class="welcome_bg" style="flex: 1">
            <!-- <el-image
                style="width: 100%; height: 100%"
                fit="cover"
                src="https://img1.baidu.com/it/u=4097856652,4033702227&fm=253&fmt=auto&app=120&f=JPEG?w=1422&h=800"
            /> -->
        </div>
        <div class="welcome-title">
            <div style="font-size: 30px; font-weight: bold">
                欢迎来到我们的大事件平台
            </div>
            <div style="margin-top: 10px">
                在这里你可以了解到陈旧知识的Java知识，并与Java之父密切交流。
            </div>
        </div>
        <div class="right-card">
            <div style="display: flex; justify-content: flex-end">
                <DarkButton />
            </div>
            <router-view v-slot="{ Component }">
                <transition name="el-fade-in-linear" mode="out-in">
                    <component :is="Component" style="height: 100%" />
                </transition>
            </router-view>
        </div>
    </div>
</template>

<script setup>
import DarkButton from '@/components/DarkButton/DarkButton.vue'
</script>

<style scoped>
.welcome_bg {
    /*
    no-repeat: 设置背景图像不重复显示。
    xx% center: 设置背景图像在水平方向上距离容器右边缘的百分比为xx%，在垂直方向上居中对齐。
    240px: 设置背景图像的宽度为240像素。
  */
    background: url('@/assets/logo2.png') no-repeat 20% 30% / 320px auto,
        url('@/assets/login_bg.jpg') no-repeat center / cover;
    /* border-radius: 0 20px 20px 0; */
}
.right-card {
    width: 400px;
    z-index: 1;
    background-color: var(--el-bg-color);
}

.welcome-title {
    position: absolute;
    bottom: 30px;
    left: 30px;
    color: rgb(0, 0, 0);
    text-shadow: 0 0 10px white;
}
</style>
