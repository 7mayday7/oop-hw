package hw5.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private final Long id;
    private String fullName;
    private Integer age;
    private String phoneNumber;
}
