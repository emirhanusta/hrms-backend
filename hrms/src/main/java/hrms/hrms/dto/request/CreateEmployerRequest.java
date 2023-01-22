package hrms.hrms.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class CreateEmployerRequest {

    @Email
    private String mailAddress;
    @NotBlank
    private String password;
    @NotBlank
    @Pattern(regexp = "^[0-9]{11}$", message = "Phone number must be 11 digits")
    private String phoneNumber;
    @NotBlank
    private String companyName;

    private String website;

}
