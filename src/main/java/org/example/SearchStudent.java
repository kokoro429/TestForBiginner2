package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchStudent {

  private List<Student> students;

  //生徒名で検索。部分検索もできる。
  public List<Student> searchStudentByName(List<Student> students, String studentName) {
    List<Student> result = students.stream()
        .filter(student -> student.getStudentName().contains(studentName))
        .collect(Collectors.toList());
    return result;
  }


}
