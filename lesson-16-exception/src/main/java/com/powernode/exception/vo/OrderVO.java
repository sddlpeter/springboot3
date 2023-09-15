package com.powernode.exception.vo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class OrderVO {
    @NotBlank(message = "订单名不能为空")
    private String name;

    @NotNull(message = "商品必须由数量")
    @Range(min=1, max = 99, message = "一个订单的商品数量{min}--{max}")
    private Integer amount;

    @NotNull(message = "用户不能为空")
    @Min(value = 1, message = "从1开始")
    Integer userId;

}
