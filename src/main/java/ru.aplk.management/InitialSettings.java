package ru.aplk.management;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.aplk.management.authentication.routes.components.AuthService;
import ru.aplk.management.authentication.routes.dto.RegisterRequestDTO;
import ru.aplk.management.users.Role;

@Component
public class InitialSettings {
    public InitialSettings(
            @Value("${admin.firstname}") String adminFirstname,
            @Value("${admin.lastname}") String adminLastname,
            @Value("${admin.email}") String adminEmail,
            @Value("${admin.password}") String adminPassword,
            AuthService authService
    ) {
        authService.register(
                RegisterRequestDTO.builder()
                        .firstname(adminFirstname)
                        .lastname(adminLastname)
                        .email(adminEmail)
                        .password(adminPassword)
                        .build(),
                Role.ADMIN
        );
    }
}
