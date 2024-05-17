package com.example.controller;

import com.example.entity.RestBean;
import com.example.entity.dto.Account;
import com.example.entity.vo.request.UserPasswordChangeVO;
import com.example.entity.vo.request.UserInfoUpdateVO;
import com.example.entity.vo.response.UserInfoVO;
import com.example.service.AccountService;
import com.example.utils.Const;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.function.Supplier;

@Validated
@RestController
@RequestMapping("/api/user")
@Tag(name = "用户信息相关", description = "包括获取、更新用户信息的操作。")
public class UserController {

    @Resource
    private AccountService accountService;

    @GetMapping("/info")
    @Operation(summary = "获取用户详细信息")
    public RestBean<UserInfoVO> userInfo(HttpServletRequest request) {
        Account account = accountService.getById((Serializable) request.getAttribute(Const.ATTR_USER_ID));
        return RestBean.success(account.asViewObject(UserInfoVO.class));
    }

    @PostMapping("/update")
    public RestBean<Void> update(@RequestBody @Valid UserInfoUpdateVO vo,
                                 HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute(Const.ATTR_USER_ID);
        return this.messageHandle(() ->
                accountService.updateAccount(vo, id));
    }

    @PatchMapping("/updateAvatar")
    public RestBean<Void> updateAvatar(
            @RequestParam @URL String avatarUrl,
            HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute(Const.ATTR_USER_ID);
        return this.messageHandle(() ->
                accountService.updateAvatar(avatarUrl, id));
    }

    @PatchMapping("/updatePassword")
    public RestBean<Void> updatePassword(
            @RequestBody @Valid UserPasswordChangeVO vo,
            HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute(Const.ATTR_USER_ID);
        return this.messageHandle(() ->
                accountService.updatePassword(vo, id));
    }

    private <T> RestBean<T> messageHandle(Supplier<String> action) {
        String message = action.get();
        return message == null ? RestBean.success() : RestBean.failure(400, message);
    }
}
