package ru.aplk.management.tables.spaces;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aplk.management.additions.ControllerFunctions;
import ru.aplk.management.additions.types.ResponseWithStatus;
import ru.aplk.management.additions.types.StatusCode;

import java.util.List;

@RestController
@RequestMapping("/space")
@RequiredArgsConstructor
public class SpaceController {
    private final ControllerFunctions controllerFunctions;
    private final SpaceService departmentService;

    @GetMapping
    public ResponseEntity<ResponseWithStatus<List<Space>>> findAll(){
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWithStatus<Space>> findById(@PathVariable Long id){
        return controllerFunctions.responseWithStatus(id, departmentService::findById);
    }

    @PostMapping
    public ResponseEntity<StatusCode> save(@RequestBody Space education, HttpServletRequest request){
        return controllerFunctions.statusCode(education, departmentService::save, request);
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println(321);

    }
}
