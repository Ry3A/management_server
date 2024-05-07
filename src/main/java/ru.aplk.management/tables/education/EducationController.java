package ru.aplk.management.tables.education;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aplk.management.additions.ControllerFunctions;
import ru.aplk.management.additions.types.ResponseWithStatus;
import ru.aplk.management.additions.types.StatusCode;

import java.util.List;

@RestController
@RequestMapping("/education")
@RequiredArgsConstructor
public class EducationController {
    private final ControllerFunctions controllerFunctions;
    private final EducationService educationService;

    @GetMapping
    public ResponseEntity<ResponseWithStatus<List<Education>>> findAll(){
        return ResponseEntity.ok(educationService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWithStatus<Education>> findById(@PathVariable Long id){
        return controllerFunctions.responseWithStatus(id, educationService::findById);
    }

    @PostMapping
    public ResponseEntity<StatusCode> save(@RequestBody Education education, HttpServletRequest request){
        return controllerFunctions.statusCode(education, educationService::save, request);
    }
}
