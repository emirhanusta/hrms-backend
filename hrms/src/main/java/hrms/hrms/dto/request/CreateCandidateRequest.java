package hrms.hrms.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.validation.constraints.*;
import java.util.Date;

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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
    @NotNull
    @Pattern(regexp = "^[0-9]{11}$", message = "Phone number must be 11 digits")
    private String  phoneNumber;

}
