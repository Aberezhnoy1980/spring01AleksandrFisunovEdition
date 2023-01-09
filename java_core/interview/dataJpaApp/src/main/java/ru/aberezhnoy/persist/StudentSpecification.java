package ru.aberezhnoy.persist;

import org.springframework.data.jpa.domain.Specification;
import ru.aberezhnoy.persist.model.Student;

public final class StudentSpecification {

    public static Specification<Student> nameLike(String pattern) {
        return (root, query, builder) -> builder.like(root.get("name"), "%" + pattern + "%");
    }

    public static Specification<Student> minAgeFilter(int minAge) {
        return (root, query, builder) -> builder.ge(root.get("age"), minAge);
    }

    public static Specification<Student> maxAgeFilter(int maxAge) {
        return (root, query, builder) -> builder.le(root.get("age"), maxAge);
    }
}
