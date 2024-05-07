package ru.aplk.management.tables.user_audit;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aplk.management.additions.ServiceFunctions;
import ru.aplk.management.additions.types.ResponseWithStatus;
import ru.aplk.management.additions.types.StatusCode;
import ru.aplk.management.tables.languages.Language;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAuditService {
    private final UserAuditRepository userAuditRepository;
    private final ServiceFunctions serviceFunctions;

    public ResponseWithStatus<List<UserAudit>> findAll(){
        return ResponseWithStatus.create(200, userAuditRepository.findAll());
    }

    public List<UserAudit> findAllWeb(){
        return userAuditRepository.findAll();
    }


    public ResponseWithStatus<UserAudit> findById(Long id){
        return serviceFunctions.findBy(id, userAuditRepository::findById);
    }

    public StatusCode save(UserAudit userAudit, HttpServletRequest request){
        return serviceFunctions.saveWithAuth(
                userAudit,
                userAudit.getName(),
                userAuditRepository::findByName,
                userAuditRepository::save,
                request
        );
    }

}
