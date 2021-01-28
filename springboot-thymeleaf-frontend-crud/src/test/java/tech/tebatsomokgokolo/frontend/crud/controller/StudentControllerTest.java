package tech.tebatsomokgokolo.frontend.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import tech.tebatsomokgokolo.frontend.crud.dto.request.Student;

@Slf4j
public class StudentControllerTest {
    private String studentUrl = "http://localhost:8001/v1/api/students/";

    @Test
    public void testRestCalls() {

    }

    private Student buildStudentRequest(String email) {
        return Student.builder()
                .email(email)
                .name("Tebatso")
                .phoneNo(8336000207L)
                .build();
    }
}