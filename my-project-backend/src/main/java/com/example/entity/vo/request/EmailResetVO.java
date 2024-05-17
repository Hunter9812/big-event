package com.example.entity.vo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 密码重置表单实体
 */
@Data
public class EmailResetVO {
    @Email
    private String email;
    @Length(max = 6, min = 6)
    private String code;
    @Length(min = 6, max = 20)
    private String password;
}
