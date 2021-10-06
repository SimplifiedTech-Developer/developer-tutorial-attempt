package tech.tebatsomokgokolo.frontend.crud.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.tebatsomokgokolo.frontend.crud.dto.request.Student;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class StudentService {
    @Value("${endpoints.student.url}")
    private String studentUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<Student> getAll() {
        log.info("Started Getting All Students");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(studentUrl, String.class);
        Type collectionType = new TypeToken<List<Student>>() {
        }.getType();
        List<Student> students = new Gson().fromJson(responseEntity.getBody(), collectionType);
        log.info("Completed Getting All Students");
        return students;
    }

    public void addStudent(Student student) {
        log.info("Started Adding Student : {}", new Gson().toJson(student));
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(studentUrl, student, String.class);
        log.info("Completed Adding Student : {} ", responseEntity.getBody());
    }

    public void updateStudent(long id, Student student) {
        log.info("Started Updating Student : {}", new Gson().toJson(student));
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Student> entity = new HttpEntity<>(student, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(studentUrl.concat(String.valueOf(id)), HttpMethod.PUT, entity, String.class);
        log.info("Completed Updating Student : {} ", responseEntity.getBody());
    }

    public void deleteStudent(long id) {
        log.info("Started Deleting Student : {}", id);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(studentUrl.concat(String.valueOf(id)), HttpMethod.DELETE, entity, String.class);
        log.info("Completed Deleting Student : {} ", responseEntity.getBody());
    }

    public Student getStudentById(long id) {
        log.info("Started Getting Student By Id : {}", id);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(studentUrl.concat(String.valueOf(id)), String.class);
        log.info("Completed Getting Student By Id : {}", id);
        return new Gson().fromJson(responseEntity.getBody(), Student.class);
    }
}
