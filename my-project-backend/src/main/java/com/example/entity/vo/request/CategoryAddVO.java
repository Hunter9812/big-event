package com.example.entity.vo.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CategoryAddVO {
    @NotEmpty
    private String categoryName;
    @NotEmpty
    private String categoryAlias;
}
