package org.example;

public class Student {
  String studentName;
  int studentScore;

  public Student(String studentName, int studentScore) {
    this.studentName = studentName;
    this.studentScore = studentScore;
  }

  public String getStudentName(){
    return studentName;
  }

  public int getStudentScore(){
    return studentScore;
  }

  public void setStudentScore(int studentScore){
    this.studentScore = studentScore;
  }

  @Override
  public String toString(){
    return "生徒名：" + studentName +
        "点数：" + studentScore;
  }


}
