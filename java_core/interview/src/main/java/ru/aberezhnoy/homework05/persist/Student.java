package ru.aberezhnoy.homework05.persist;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private int mark;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return String.format("{ID: %d, name: %s, mark: %d}\n", id, name, mark);
    }

    public static Builder createStudent() {
        return new Builder();
    }

    public static class Builder {
        private Student student;

        public Builder() {
            this.student = new Student();
        }

        public Builder setId(Long id) {
            this.student.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.student.name = name;
            return this;
        }

        public Builder setMark(int mark) {
            this.student.mark = mark;
            return this;
        }

        public Student build() {
            return student;
        }
    }

}
