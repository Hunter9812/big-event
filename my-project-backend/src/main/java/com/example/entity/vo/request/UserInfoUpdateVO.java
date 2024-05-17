package com.example.entity.vo.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserInfoUpdateVO {
//    @NotEmpty
//    @Pattern(regexp = "^\\S{1,10}")
    private String username;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}")
    private String nickname;
    @NotNull
    private String biography;
}
