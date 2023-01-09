package ru.aberezhnoy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.aberezhnoy.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.age >= :minAge")
    Page<User> findUsersByAgeGreaterThan(int minAge, Pageable pageable);

    @Query("select u from User u where u.age <= :maxAge")
    Page<User> findUsersByAgeLessThan(int maxAge, Pageable pageable);

    @Query("select u from User u where u.age between :minAge and :maxAge")
    Page<User> findUsersByAgeBetweenThan(int minAge, int maxAge, Pageable pageable);

    @Query("select u from User u where u.male = :male")
    Page<User> findUsersByMale(String male, Pageable pageable);

//    Page<User> findAll(@Nullable Integer minAge, @Nullable Integer maxAge, @Nullable String male, Pageable pageable);
}
