<script setup>
import { ref } from 'vue'
import { ElMessage } from 'element-plus'

const pwdData = ref({
    oldPassword: '',
    newPassword: '',
    rePassword: '',
})
import { get, patch } from '@/net'

const updatePwdData = () => {
    patch(
        '/api/user/updatePassword',
        pwdData.value,
        () => {
            ElMessage.success('修改成功')
        },
        message => ElMessage.warning(message)
    )
    pwdData.value = {
        oldPassword: '',
        newPassword: '',
        rePassword: '',
    }
}

const checkRePassword = (rule, value, callback) => {
    if (value === '') {
        callback(new Error('请再次确认密码'))
    } else if (value !== pwdData.value.newPassword) {
        callback(new Error('两次密码不一样'))
    } else {
        callback()
    }
}
const rules = {
    oldPassword: [
        { required: true, message: '请输入旧密码?', trigger: 'blur' },
        { min: 5, max: 16, message: '长度为5-16位', trigger: 'blur' },
    ],
    newPassword: [
        { required: true, message: '请输入新密码', trigger: 'blur' },
        { min: 5, max: 16, message: '长度为5-16位', trigger: 'blur' },
    ],
    rePassword: [
        { required: true, message: '请输入确认新密码', trigger: 'blur' },
        { validator: checkRePassword, trigger: 'blur' },
    ],
}
</script>

<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>重置密码</span>
            </div>
        </template>
        <el-row>
            <el-col :span="12">
                <el-form
                    :model="pwdData"
                    :rules="rules"
                    label-width="100px"
                    size="large"
                >
                    <el-form-item label="旧密码" prop="oldPassword">
                        <el-input
                            v-model="pwdData.oldPassword"
                            type="password"
                            placeholder="请输入旧密码"
                        ></el-input>
                    </el-form-item>
                    <el-form-item label="新密码" prop="newPassword">
                        <el-input
                            v-model="pwdData.newPassword"
                            type="password"
                            placeholder="请输入新密码"
                        ></el-input>
                    </el-form-item>
                    <el-form-item label="确认新密码" prop="rePassword">
                        <el-input
                            v-model="pwdData.rePassword"
                            type="password"
                            placeholder="请输入再次新密码"
                        ></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="updatePwdData"
                            >提交修改</el-button
                        >
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
    </el-card>
</template>
