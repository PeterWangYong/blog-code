package com.peter.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.*;
import com.peter.mybatisplus.enums.StatusEnum;
import com.peter.mybatisplus.enums.StatusEnum2;
import lombok.Data;

import java.util.Date;

@Data
public class User {
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String name;
  private Integer age;
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  @Version
  private Integer version;
  private StatusEnum status;
  @TableLogic
  private Integer deleted;
}
