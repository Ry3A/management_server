package ru.aplk.management.tables.user_audit;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aplk.management.additions.ControllerFunctions;
import ru.aplk.management.additions.types.ResponseWithStatus;
import ru.aplk.management.additions.types.StatusCode;

import java.util.List;

@RestController
@RequestMapping("/user_audit")
@RequiredArgsConstructor
public class UserAuditController {
    private final ControllerFunctions controllerFunctions;
    private final UserAuditService userAuditService;

    @GetMapping
    public ResponseEntity<ResponseWithStatus<List<UserAudit>>> findAll(){
        return ResponseEntity.ok(userAuditService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWithStatus<UserAudit>> findById(@PathVariable Long id){
        return controllerFunctions.responseWithStatus(id, userAuditService::findById);
    }

    @PostMapping
    public ResponseEntity<StatusCode> save(@RequestBody UserAudit education, HttpServletRequest request){
        return controllerFunctions.statusCode(education, userAuditService::save, request);
    }
}
