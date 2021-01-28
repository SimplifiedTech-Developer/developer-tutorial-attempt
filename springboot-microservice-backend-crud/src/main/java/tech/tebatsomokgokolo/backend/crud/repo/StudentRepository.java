package tech.tebatsomokgokolo.backend.crud.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.tebatsomokgokolo.backend.crud.model.*;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByName(String name);
}