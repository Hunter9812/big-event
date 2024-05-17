package com.example.entity.vo.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryPutVO {
    @NotNull
    private Integer id;
    @NotEmpty
    private String categoryName;
    @NotEmpty
    private String categoryAlias;
}
