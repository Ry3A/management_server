package ru.aplk.management.tables.education;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aplk.management.additions.ServiceFunctions;
import ru.aplk.management.additions.types.ResponseWithStatus;
import ru.aplk.management.additions.types.StatusCode;
import ru.aplk.management.tables.departments.Department;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationService {
    private final EducationRepository educationRepository;
    private final ServiceFunctions serviceFunctions;

    public ResponseWithStatus<List<Education>> findAll(){
        return ResponseWithStatus.create(200, educationRepository.findAll());
    }
    public List<Education> findAllWeb(){
        return educationRepository.findAll();
    }

    public ResponseWithStatus<Education> findById(Long id){
        return serviceFunctions.findBy(id, educationRepository::findById);
    }

    public StatusCode save(Education education, HttpServletRequest request){
        return serviceFunctions.saveWithAuth(
                education,
                education.getName(),
                educationRepository::findByName,
                educationRepository::save,
                request
        );
    }

}
