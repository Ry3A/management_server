package ru.aplk.management.tables.positions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aplk.management.additions.ServiceFunctions;
import ru.aplk.management.additions.types.ResponseWithStatus;
import ru.aplk.management.additions.types.StatusCode;
import ru.aplk.management.tables.departments.Department;
import ru.aplk.management.tables.departments.DepartmentRepository;
import ru.aplk.management.tables.languages.Language;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    private final ServiceFunctions serviceFunctions;
    private final DepartmentRepository departmentRepository;


    private PositionIsFull isFull(List<Object[]> entitiesArr) {
        Object[] entities = entitiesArr.get(0);
        Position position = (Position) entities[0];
        Department department = (Department) entities[1];

        return PositionIsFull.builder()
                .id(position.getId())
                .name(position.getName())
                .department(department)
                .build();
    }
    public boolean notFull(Position position) {
       if(!departmentRepository.existsById(position.getDepartmentId())){
           return true;
       }
       return false;
    }

    public ResponseWithStatus<List<Position>> findAll(){
        return ResponseWithStatus.create(200, positionRepository.findAll());
    }
    public List<Position> findAllWeb(){
        return positionRepository.findAll();
    }


    public ResponseWithStatus<List<Position>> findAllByDepartmentId(Long departmentId){
        return ResponseWithStatus.create(200, positionRepository.findAllByDepartmentId(departmentId));
    }


    public ResponseWithStatus<PositionIsFull> findById(Long id){
        return serviceFunctions.findByWithJoin(
                id,
                positionRepository::findByIdWithJoin,
                this::isFull
        );
    }

    public ResponseWithStatus<PositionIsFull> findByName(String title){
        return serviceFunctions.findByWithJoin(
                title,
                positionRepository::findByNameWithJoin,
                this::isFull
        );
    }

    public StatusCode save(Position position, HttpServletRequest request){
        return serviceFunctions.saveWithCheckFieldsWithAuth(
                position,
                this::notFull,
                positionRepository::save,
                request
        );
    }

}
