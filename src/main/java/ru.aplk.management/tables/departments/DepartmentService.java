package ru.aplk.management.tables.departments;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aplk.management.additions.ServiceFunctions;
import ru.aplk.management.additions.types.ResponseWithStatus;
import ru.aplk.management.additions.types.StatusCode;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ServiceFunctions serviceFunctions;

    public ResponseWithStatus<List<Department>> findAll(){
        return ResponseWithStatus.create(200, departmentRepository.findAll());
    }
    public List<Department> findAllWeb(){
        return departmentRepository.findAll();
    }

    public ResponseWithStatus<Department> findById(Long id){
        return serviceFunctions.findBy(id, departmentRepository::findById);
    }

    public StatusCode save(Department education, HttpServletRequest request){
        return serviceFunctions.saveWithAuth(
                education,
                education.getName(),
                departmentRepository::findByName,
                departmentRepository::save,
                request
        );
    }

}
