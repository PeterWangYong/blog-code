package com.peter.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;

public enum StatusEnum2 implements IEnum {

  WORK(1, "工作"),
  REST(0, "休息");

  private Integer code;
  private String msg;

  StatusEnum2(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public Serializable getValue() {
    return this.code;
  }
}
