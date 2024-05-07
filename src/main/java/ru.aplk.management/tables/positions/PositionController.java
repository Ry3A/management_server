package ru.aplk.management.tables.positions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aplk.management.additions.ControllerFunctions;
import ru.aplk.management.additions.types.ResponseWithStatus;
import ru.aplk.management.additions.types.StatusCode;

import java.util.List;

@RestController
@RequestMapping("/position")
@RequiredArgsConstructor
public class PositionController {
    private final ControllerFunctions controllerFunctions;
    private final PositionService positionService;

    @GetMapping
    public ResponseEntity<ResponseWithStatus<List<Position>>> findAll(){
        return ResponseEntity.ok(positionService.findAll());
    }

    @GetMapping(params = "departmentId")
    public ResponseEntity<ResponseWithStatus<List<Position>>> findAllByDepartmentId(@Param("departmentId") Long departmentId){
        return ResponseEntity.ok(positionService.findAllByDepartmentId(departmentId));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWithStatus<PositionIsFull>> findById(@PathVariable Long id){
        return controllerFunctions.responseWithStatus(id, positionService::findById);
    }

    @PostMapping
    public ResponseEntity<StatusCode> save(@RequestBody Position position, HttpServletRequest request){
        return controllerFunctions.statusCode(position, positionService::save, request);
    }

}
