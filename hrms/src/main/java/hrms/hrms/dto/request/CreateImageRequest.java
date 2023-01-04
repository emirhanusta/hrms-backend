package hrms.hrms.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateImageRequest {
    @NotBlank
    private String url;
}
