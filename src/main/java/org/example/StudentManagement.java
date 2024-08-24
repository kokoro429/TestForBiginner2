package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class StudentManagement {

  private List<Student> students;
  private Scanner scanner;
  private SearchStudent searchStudent;

  public StudentManagement() {
    this.students = new ArrayList<>();
    this.scanner = new Scanner(System.in);
    this.searchStudent = new SearchStudent();
  }

  //学生情報の追加
  public void addStudent() {
    System.out.println("学生の名前を入力してください:");
    String studentName = scanner.nextLine();
    System.out.println(studentName + "の点数を入力してください:");
    Integer studentScore = scanner.nextInt();
    scanner.nextLine();

    students.add(new Student(studentName, studentScore));
    System.out.println("学生が追加されました。");
  }

  //学生情報を削除
  public void deleteStudent() {
    System.out.println("削除したい学生の名前を入力してください。");
    String studentName = scanner.nextLine();
    List<Student> foundStudent = searchStudent.searchStudentByName(students, studentName);

    if (foundStudent.isEmpty()) {
      System.out.println("学生が見つかりませんでした。");
    } else {
      students.removeAll(foundStudent);
      System.out.println("削除されました。");
    }
  }

  //点数を更新
  public void updateStudentScore() {
    System.out.println("点数を更新したい学生の名前を入力してください。");
    String studentName = scanner.nextLine();
    List<Student> foundStudent = searchStudent.searchStudentByName(students, studentName);

    if (foundStudent.isEmpty()) {
      System.out.println("学生が見つかりません。");
    } else {
      for (Student student : foundStudent) {
        System.out.println(student.getStudentName() + "の新しい点数を入力してください。");
        int newScore = scanner.nextInt();
        student.setStudentScore(newScore);
        System.out.println("点数が更新されました。");
      }
    }
  }

  //平均点を計算
  public void averageScore() {
    if (students.isEmpty()) {
      System.out.println("学生がいません。");
    }

    OptionalDouble average = students.stream()
        .mapToInt(Student::getStudentScore)
        .average();

    if (average.isPresent()) {
      System.out.println("平均点：" + average.getAsDouble() + "点");
    } else {
      System.out.println("平均点が計算出来ませんでした。");
    }
  }

  //全学生の情報を表示
  public void displayAllStudents() {
    if (students.isEmpty()) {
      System.out.println("学生がいません。");
    } else {
      System.out.println("学生一覧");
      students.forEach(student ->
          System.out.println(student.getStudentName() + ":" + student.getStudentScore() + "点"));
    }
  }
}
