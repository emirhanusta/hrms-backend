package hrms.hrms.dto.request;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class CreateCandidateRequest {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Email
    private String MailAddress;
    @NotBlank
    private String password;
    @NotNull
    private String dateOfBirth;
    @NotNull
    @Pattern(regexp = "^[0-9]{11}$", message = "Phone number must be 11 digits")
    private String  phoneNumber;

}
