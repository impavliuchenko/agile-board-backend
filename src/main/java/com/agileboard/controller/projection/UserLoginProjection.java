package com.agileboard.controller.projection;

import lombok.Data;

@Data
public class UserLoginProjection {
    private String email;
    private String password;
}
