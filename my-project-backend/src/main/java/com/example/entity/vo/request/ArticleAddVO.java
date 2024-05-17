package com.example.entity.vo.request;

import com.example.anno.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Data
public class ArticleAddVO {
    @Length(min = 1, max = 10)
    private String title;
    @NotEmpty
    private String content;
    @URL
    private String coverImg;
    @State
    private String state;
    @NotNull
    private Integer categoryId;
}
