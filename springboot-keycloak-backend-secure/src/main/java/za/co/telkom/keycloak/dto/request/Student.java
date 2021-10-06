package za.co.telkom.keycloak.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Student {
    private Long id;
    private String name;
}
