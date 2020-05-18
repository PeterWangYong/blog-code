package com.peter.mapper;

import com.peter.model.Goods;

public interface GoodsMapper {
  Goods findById(long id);
}
