<script setup>
import { useDark, useToggle } from '@vueuse/core'
import { ElConfigProvider } from 'element-plus'
import zhCn from 'element-plus/es/locale/lang/zh-cn'

useDark({
    selector: 'html',
    attribute: 'class',
    valueDark: 'dark',
    valueLight: 'light',
})

useDark({
    onChanged(dark) {
        useToggle(dark)
    },
})
</script>

<template>
    <header>
        <div class="wrapper">
            <el-config-provider :locale="zhCn">
                <router-view />
            </el-config-provider>
        </div>
    </header>
</template>

<style scoped>
header {
    line-height: 1.5;
}
</style>
