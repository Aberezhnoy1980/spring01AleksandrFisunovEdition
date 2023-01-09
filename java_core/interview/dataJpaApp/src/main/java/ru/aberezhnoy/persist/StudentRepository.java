package ru.aberezhnoy.persist;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import ru.aberezhnoy.persist.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    Page<Student> findAll(@Nullable Specification<Student> spec, Pageable pageable);

    @Query("select s " +
            "from Student s " +
            "where (s.name like :pattern or :pattern is null) and " +
            " (s.age >= :minAge or :minAge is null) and " +
            " (s.age <= :maxAge or :maxAge is null)")
    List<Student> findByFilter(@Param("pattern") String pattern,
                               @Param("minAge") int minAge,
                               @Param("maxAge") int maxAge);
}
