package ru.aberezhnoy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.aberezhnoy.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
