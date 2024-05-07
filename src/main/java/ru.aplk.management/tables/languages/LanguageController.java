package ru.aplk.management.tables.languages;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aplk.management.additions.ControllerFunctions;
import ru.aplk.management.additions.types.ResponseWithStatus;
import ru.aplk.management.additions.types.StatusCode;

import java.util.List;

@RestController
@RequestMapping("/language")
@RequiredArgsConstructor
public class LanguageController {
    private final ControllerFunctions controllerFunctions;
    private final LanguageService languageService;

    @GetMapping
    public ResponseEntity<ResponseWithStatus<List<Language>>> findAll(){
        return ResponseEntity.ok(languageService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWithStatus<Language>> findById(@PathVariable Long id){
        return controllerFunctions.responseWithStatus(id, languageService::findById);
    }

    @PostMapping
    public ResponseEntity<StatusCode> save(@RequestBody Language education, HttpServletRequest request){
        return controllerFunctions.statusCode(education, languageService::save, request);
    }
}
