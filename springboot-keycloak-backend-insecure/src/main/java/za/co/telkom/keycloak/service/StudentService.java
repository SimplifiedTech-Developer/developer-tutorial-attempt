package za.co.telkom.keycloak.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import za.co.telkom.keycloak.dto.request.Student;

@Service
@Slf4j
public class StudentService {

    public Student create(Student student) {
        log.info("StudentService Created The Student");
        return student;
    }

    public Student findById(Long id) {
        log.info("StudentService Found Student Id -> {}", id);
        return Student.builder()
                .id(id)
                .build();
    }

    public Student updateById(Long id) {
        log.info("StudentService Updated Student Id -> {}", id);
        return Student.builder()
                .id(id)
                .build();
    }

    public Boolean deleteByID(Long id) {
        log.info("StudentService Deleted Student Id : {}", id);
        return Boolean.TRUE;
    }
}
