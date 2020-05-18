package com.peter.mapper;

import com.peter.model.Student;

public interface StudentMapper {
  Student findById(long id);
}
