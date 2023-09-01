package com.example.pagination.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegistrationRequest {
    @NotBlank
    @Size(min = 4, max = 50)
    private String email;
    @NotBlank
    @Size(min = 6, max = 100)
    private String password;
    @NotBlank
    @Size(min = 6, max = 100)
    private String repeatPassword;
}
