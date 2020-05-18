package com.peter.mapper;

import com.peter.model.Customer;

public interface CustomerMapper {
  Customer findById(long id);
}
