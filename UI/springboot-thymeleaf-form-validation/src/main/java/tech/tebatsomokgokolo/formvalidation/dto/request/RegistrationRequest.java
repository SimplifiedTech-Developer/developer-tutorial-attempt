package tech.tebatsomokgokolo.formvalidation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    @NotNull(message = "Name Cannot Be Null")
    @Size(min = 2, max = 10, message = "Name Length Should Be Between 2 to 10")
    private String name;

    @NotEmpty(message = "Email field should not be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Email should be valid")
    private String email;

    @Pattern(regexp = "[7-9][0-9]{9}", message = "Invalid Mobile Number.")
    @Size(min = 10, max = 10, message = "Number Of Digits Should Be 10")
    private String mobile;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private int age;

    @AssertTrue(message = "Only Candidates that are Currently Working Allowed.")
    private boolean working;
}
