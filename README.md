## 说明

结合了两个学习项目，添加了docker，方便学习和使用。

-   白马程序员的[前后端分离项目（JWT 方案）](https://www.bilibili.com/video/BV1Pz4y1W7TN)
-   黑马程序员的[大事件项目](https://www.bilibili.com/video/BV14z4y1N7pg/)

## [前后端分离项目（JWT 方案）](https://github.com/itbaima-study/SpringBoot-Vue-Template-JWT )

采用 SpringBoot3 + Vue3 编写的前后端分离项目，集成多种技术栈，使用 JWT 校验方案，使用Docker 部署。

---

### 后端功能与技术点

用户注册、用户登录、重置密码等基础功能以及对应接口

-   采用 Mybatis-Plus 作为持久层框架，使用更便捷
-   采用 Redis 存储注册/重置操作验证码，带过期时间控制
-   采用 RabbitMQ 积压短信发送任务，再由监听器统一处理
-   采用 SpringSecurity 作为权限校验框架，手动整合 Jwt 校验方案
-   采用 Redis 进行 IP 地址限流处理，防刷接口
-   视图层对象和数据层对象分离，编写工具方法利用反射快速互相转换
-   错误和异常页面统一采用 JSON 格式返回，前端处理响应更统一
-   手动处理跨域，采用过滤器实现
-   使用 Swagger 作为接口文档自动生成，已自动配置登录相关接口
-   采用过滤器实现对所有请求自动生成雪花 ID 方便线上定位问题
-   针对于多环境进行处理，开发环境和生产环境采用不同的配置
-   日志中包含单次请求完整信息以及对应的雪花 ID，支持文件记录
-   项目整体结构清晰，职责明确，注释全面，开箱即用

### 前端功能与技术点

用户注册、用户登录、重置密码等界面，以及一个简易的主页

-   采用 Vue-Router 作为路由
-   采用 Axios 作为异步请求框架
-   采用 Element-Plus 作为 UI 组件库
-   使用 VueUse 适配深色模式切换
-   使用 unplugin-auto-import 按需引入，减少打包后体积

## [BigEvent - 黑马程序员大事件 SpringBoot 3 + Vue 3 项目](https://github.com/BaichuanTang/BigEvent)

欢迎来到BigEvent项目，这是一个结合了SpringBoot 3和Vue 3的实战课程项目，涵盖了后端到前端的全栈开发流程。

### 课程收获

在这个课程中，我学习并实践了以下技术点：

- **SpringBoot**：框架的核心知识点。
- **Validation**：参数校验框架，学习了如何在实战中进行有效的数据校验。
- **Redis**：缓存技术，用于提高数据处理速度和效率。
- **JWT**：认证技术，确保了用户身份的安全验证。
- **JUnit**：单元测试，保障代码质量和功能正确性。
- **MyBatis**：数据库框架，加深了对ORM和数据库交互的理解。
- **Vue**：前端主流框架，基础知识点的掌握。
- **Axios**：异步函数库，处理HTTP请求。
- **Vue-Router**：Vue的路由管理。
- **Pinia**：状态管理，维护应用的状态。
- **工程化开发**：学习了现代前端工程化的实践和工具使用。

### 项目组成

- **前端项目**：[big-event-frontend](https://github.com/BaichuanTang/BigEvent/tree/main/big-event-frontend)
- **后端项目**：[big-event-backend](https://github.com/BaichuanTang/BigEvent/tree/main/big-event-backend)

### 点评视频

观看点评视频，了解项目的更多细节：[点评视频](https://www.bilibili.com/video/BV1Ga4y1S7jc/)

### 个人点评与优化

通过这个项目，我不仅学到了很多实用的技巧，还对一些代码进行了优化，包括：

- **后端校验**：深入理解了`@Validated`的使用场景和自定义注解校验。
- **登录认证流程**：优化了JWT和Redis结合的认证流程，提高了安全性和效率。
- **全局异常处理**：对黑马程序员的代码进行了优化，增强了异常处理的能力。
- **MyBatis实战**：通过编写XML文件，加深了对SQL语句控制的理解，提高了数据安全性。
- **前端开发体验**：推荐使用WebStorm提高开发效率，优化了代码组织和快捷操作。
- **前端工程化**：清晰讲解了路由、拦截器、状态管理等关键概念，使用了Vue 3的最新语法。

### 实战经验

- **身份验证**：实现了用户ID的核实，确保了操作的合法性。
- **阿里云OSS**：学习了如何设置环境变量，避免敏感信息泄露。
- **前端工具**：体验了前端开发的便捷性，特别是在代码导入和组织方面。
- **图片上传处理**：结合`el-upload`进行了实用的图片上传功能实现。

---

感谢黑马程序员的这个项目，让我在实战中学习到了前后端开发的关键技能，并对我未来的工作和学习打下了坚实的基础。
