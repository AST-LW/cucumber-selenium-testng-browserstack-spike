package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterNewUserModel {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String confirmPassword;
    private String gender;
}
