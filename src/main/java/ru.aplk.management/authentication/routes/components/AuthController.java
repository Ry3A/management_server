package ru.aplk.management.authentication.routes.components;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aplk.management.authentication.routes.dto.AuthRequestDTO;
import ru.aplk.management.authentication.routes.dto.AuthResponseDTO;
import ru.aplk.management.authentication.routes.dto.RegisterRequestDTO;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/registerIns")
    public ResponseEntity<AuthResponseDTO> register(
            @RequestBody RegisterRequestDTO registerData
    ) {
        AuthResponseDTO response = authService.register(registerData);
        return ResponseEntity.status(response.getStatus()).body(response);
    }


    @PostMapping("/loginIns")
    public ResponseEntity<AuthResponseDTO> login(
            @RequestBody AuthRequestDTO authData
    ) {
        return ResponseEntity.ok(authService.login(authData));
    }
}
