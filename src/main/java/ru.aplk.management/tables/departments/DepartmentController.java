package ru.aplk.management.tables.departments;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aplk.management.additions.ControllerFunctions;
import ru.aplk.management.additions.types.ResponseWithStatus;
import ru.aplk.management.additions.types.StatusCode;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final ControllerFunctions controllerFunctions;
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<ResponseWithStatus<List<Department>>> findAll(){
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWithStatus<Department>> findById(@PathVariable Long id){
        return controllerFunctions.responseWithStatus(id, departmentService::findById);
    }

    @PostMapping
    public ResponseEntity<StatusCode> save(@RequestBody Department education, HttpServletRequest request){
        return controllerFunctions.statusCode(education, departmentService::save, request);
    }
}
