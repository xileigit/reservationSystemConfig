package com.leilei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Comment implements Serializable {
    private Integer id;

    private Integer uid;

    private Integer mid;

    private String content;

    private Date create_date;

}