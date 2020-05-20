package com.leilei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

import static javax.print.attribute.standard.MediaPrintableArea.MM;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Ordert implements Serializable {
    private Integer id;

    private Integer uid;

    private Integer mid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date create_time;

    private Date update_time;

    private Integer state;



}