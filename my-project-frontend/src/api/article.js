import { get, put, del, post } from '@/net'
import { ElMessage } from 'element-plus'

export const articleCategoryList = categorys => {
    get(
        '/api/category',
        result => (categorys.value = result),
        message => ElMessage.warning(message)
    )
}
