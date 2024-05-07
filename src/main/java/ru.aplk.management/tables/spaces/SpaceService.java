package ru.aplk.management.tables.spaces;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aplk.management.additions.ServiceFunctions;
import ru.aplk.management.additions.types.ResponseWithStatus;
import ru.aplk.management.additions.types.StatusCode;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceService {
    private final SpaceRepository departmentRepository;
    private final ServiceFunctions serviceFunctions;

    public ResponseWithStatus<List<Space>> findAll(){
        return ResponseWithStatus.create(200, departmentRepository.findAll());
    }
    public List<Space> findAllWeb(){
        return departmentRepository.findAll();
    }

    public ResponseWithStatus<Space> findById(Long id){
        return serviceFunctions.findBy(id, departmentRepository::findById);
    }

    public StatusCode save(Space education, HttpServletRequest request){
        return serviceFunctions.saveWithAuth(
                education,
                education.getName(),
                departmentRepository::findByName,
                departmentRepository::save,
                request
        );
    }

}
