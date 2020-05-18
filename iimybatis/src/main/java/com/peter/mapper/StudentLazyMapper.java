package com.peter.mapper;

import com.peter.model.Customer;
import com.peter.model.Student;

public interface StudentLazyMapper {
  Student findById(long id);
  Student findLazyById(long id);
}
