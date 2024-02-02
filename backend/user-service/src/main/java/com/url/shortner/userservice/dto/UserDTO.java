package com.url.shortner.userservice.dto;

import com.url.shortner.userservice.utils.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank(message = Constants.USERNAME_BLANK)
    private String username;


    @Pattern(regexp = Constants.EMAIL_PATTERN, message = Constants.EMAIL_INVALID)
    private String email;

    @Pattern(regexp = Constants.PASSWORD_PATTERN, message = Constants.PASSWORD_INVALID)
    private String password;
}
