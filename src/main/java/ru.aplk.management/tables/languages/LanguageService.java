package ru.aplk.management.tables.languages;

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
public class LanguageService {
    private final LanguageRepository languageRepository;
    private final ServiceFunctions serviceFunctions;

    public ResponseWithStatus<List<Language>> findAll(){
        return ResponseWithStatus.create(200, languageRepository.findAll());
    }

    public List<Language> findAllWeb(){
        return languageRepository.findAll();
    }

    public ResponseWithStatus<Language> findById(Long id){
        return serviceFunctions.findBy(id, languageRepository::findById);
    }

    public StatusCode save(Language education, HttpServletRequest request){
        return serviceFunctions.saveWithAuth(
                education,
                education.getName(),
                languageRepository::findByName,
                languageRepository::save,
                request
        );
    }

}
