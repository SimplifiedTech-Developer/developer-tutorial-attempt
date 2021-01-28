package tech.tebatsomokgokolo.frontend.crud.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private long id;
    private String name;
    private String email;
    private long phoneNo;
}
