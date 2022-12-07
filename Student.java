package com.example.writtenexam;

import java.util.Objects;

/**
 * @projectName: written-exam
 * @package: com.example.writtenexam
 * @className: Student
 * @author: dubo
 * @description: TODO
 * @date: 2022/12/7 11:02
 * @version: 1.0
 */
public class Student {

    String name;
    String serial;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(serial, student.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial);
    }
}
