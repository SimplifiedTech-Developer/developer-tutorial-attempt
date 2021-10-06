package za.co.telkom.keycloak.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.telkom.keycloak.dto.request.Student;
import za.co.telkom.keycloak.dto.response.CommonResponse;
import za.co.telkom.keycloak.enums.CommonEnum;
import za.co.telkom.keycloak.service.StudentService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/students/")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> post(@RequestBody Student student) {

        try {
            log.info("StudentController : Started Creating Student {}", student.toString());
            Student studentCreated = service.create(student);
            log.info("StudentController : Completed Creating Student {}", student.toString());
            return new ResponseEntity<>(studentCreated, HttpStatus.OK);
        } catch (Exception e) {
            log.error(CommonEnum.ERROR_MESSAGE.getValue(), e.getMessage());
            CommonResponse commonResponse = logException(e);
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> get(@PathVariable(name = "id") Long id) {

        try {
            log.info("Started Getting Student");
            Student student = service.findById(id);
            log.info("Completed Getting Student");
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            log.error(CommonEnum.ERROR_MESSAGE.getValue(), e.getMessage());
            CommonResponse commonResponse = logException(e);
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> put(@PathVariable("id") long id, @Valid @RequestBody Student student) {

        try {
            log.info("Started Updating Student {}", student.toString());
            Student studentUpdate = service.updateById(id);
            log.info("Completed Updating Student {}", student.toString());
            return new ResponseEntity<>(studentUpdate, HttpStatus.OK);
        } catch (Exception e) {
            log.error(CommonEnum.ERROR_MESSAGE.getValue(), e.getMessage());
            CommonResponse commonResponse = logException(e);
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {

        try {
            log.info("Started Deleting Student");
            service.deleteByID(id);
            CommonResponse commonResponse = buildSuccessResponse(CommonEnum.SUCCESS_DELETE.getValue().concat(String.valueOf(id)));
            log.info("Completed Deleting Student");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            CommonResponse commonResponse = logException(e);
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private CommonResponse buildSuccessResponse(String message) {
        return CommonResponse.builder()
                .success(Boolean.TRUE)
                .message(message)
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .type(CommonEnum.SUCCESS.getValue())
                .build();
    }

    private CommonResponse logException(Exception e) {
        return CommonResponse.builder()
                .success(Boolean.FALSE)
                .message(e.getMessage())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .type(CommonEnum.EXCEPTION.getValue())
                .build();
    }
}
