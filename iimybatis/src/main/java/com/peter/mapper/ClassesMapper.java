package com.peter.mapper;

import com.peter.model.Student;

import java.util.List;

public interface ClassesMapper {
  List<Student> findById(long id);
}
