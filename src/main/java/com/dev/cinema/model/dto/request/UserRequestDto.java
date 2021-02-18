package com.dev.cinema.model.dto.request;

import com.dev.cinema.annotaion.ValidPassword;
import jakarta.validation.constraints.Min;

@ValidPassword.List({
        @ValidPassword(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "Passwords do not match!"
        )
})
public class UserRequestDto {

    private String email;
    @Min(6)
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
