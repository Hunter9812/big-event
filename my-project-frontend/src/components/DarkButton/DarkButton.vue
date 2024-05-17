<script setup>
import { useDark, useToggle } from '@vueuse/core'

import { Moon, Sunny } from '@element-plus/icons-vue'

const isDark = useDark({
    selector: 'html',
    attribute: 'class',
    valueDark: 'dark',
    valueLight: 'light',
})
const toggleDark = useToggle(isDark)
</script>

<template>
    <button class="toggle-button" @click="toggleDark()">
        <span v-if="isDark">
            <Sunny class="icon" />
            切换明亮模式
        </span>
        <span v-else>
            <Moon class="icon" />
            切换黑暗模式
        </span>
    </button>
</template>

<style scoped>
.toggle-button {
    padding: 8px 12px;
    border-radius: 4px;
    border: none;
    background-color: #f0f0f0;
    color: #333;
    cursor: pointer;
    display: flex;
    align-items: center;
    gap: 8px;
}

.icon {
    width: 16px;
    height: 16px;
}
</style>
