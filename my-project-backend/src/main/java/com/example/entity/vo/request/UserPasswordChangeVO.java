package com.example.entity.vo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserPasswordChangeVO {
    @Length(min = 6, max = 20)
    private String oldPassword;
    @Length(min = 6, max = 20)
    private String newPassword;
    @Length(min = 6, max = 20)
    private String rePassword;
}
