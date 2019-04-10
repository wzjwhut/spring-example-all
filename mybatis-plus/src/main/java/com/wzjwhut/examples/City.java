package com.wzjwhut.examples;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class City {
    @TableId
    private String name;
    private String state;
    private String country;
}