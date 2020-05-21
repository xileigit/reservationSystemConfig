package com.leilei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderVo implements Serializable {
    private Integer id;
    private String uname;
    private String mname;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date create_time;

    private Date update_time;

    private Integer state;
}
