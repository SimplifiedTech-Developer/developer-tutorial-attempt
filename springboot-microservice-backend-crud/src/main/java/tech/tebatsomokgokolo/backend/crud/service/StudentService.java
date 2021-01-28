package tech.tebatsomokgokolo.backend.crud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.tebatsomokgokolo.backend.crud.model.Student;
import tech.tebatsomokgokolo.backend.crud.repo.StudentRepository;

@Service
@Slf4j
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student create(Student student) {
        return repository.save(student);
    }

    public Student findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Student Id : ".concat(String.valueOf(id))));
    }

    public Student updateById(Long id, Student student) {
        findById(id);
        return repository.save(student);
    }

    public Iterable<Student> getAll() {
        return repository.findAll();
    }

    public Boolean deleteByID(Long id) {
        Student student = findById(id);
        repository.delete(student);
        return Boolean.TRUE;
    }
}
