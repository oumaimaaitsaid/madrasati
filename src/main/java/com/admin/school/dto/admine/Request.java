package com.admin.school.dto.admine;

import com.admin.school.enums.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @NotNull(message = "Le nom est obligatoire")
    @Size(min = 5, max = 15, message = "Le nom doit avoir entre 5 et 15 caractères")
    private String username;

    @NotNull(message = "L'email est obligatoire")
    @Size(min = 5, max = 20, message = "L'email doit avoir entre 5 et 20 caractères")
    private String email;

    @NotNull(message = "Le role est obligatoire")
    @Size(min = 5, max = 10, message = "Le role doit avoir entre 5 et 10 caractères")
    private Role role;
}
