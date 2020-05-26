package com.peter.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StatusEnum {

  WORK(1, "工作"),
  REST(0, "休息");

  @EnumValue
  private Integer code;
  private String msg;

  StatusEnum(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
