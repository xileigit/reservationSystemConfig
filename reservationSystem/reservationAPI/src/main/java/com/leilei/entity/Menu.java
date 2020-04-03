package com.leilei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Menu implements Serializable {
    private Integer id;

    private String name;

    private String image;

    private BigDecimal price;

    private Integer freq;

    private Integer scores;

    private Integer average;

    private Date create_time;

    private Date update_time;

    private String detail;
}