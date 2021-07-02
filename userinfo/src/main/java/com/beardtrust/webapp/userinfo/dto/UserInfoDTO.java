/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beardtrust.webapp.userinfo.dto;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Nathanael <Nathanael.Grier at your.org>
 */
@Data
public class UserInfoDTO {

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, message = "Username is too short")
    private String username;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private String firstName;
    private String lastName;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private String password;
    @NotNull
    @Size(min = 4, max = 4, message = "Role names are exactly four characters in length")
    private String role;

}
