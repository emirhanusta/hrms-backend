package hrms.hrms.service;

import hrms.hrms.dto.request.CreateLanguageRequest;
import hrms.hrms.model.CV;
import hrms.hrms.model.Language;
import hrms.hrms.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final CVService cvService;
    protected List<Language> createLanguage(List<CreateLanguageRequest> languages, CV cv) {

        for (CreateLanguageRequest languageDto : languages) {
            Language language = Language.builder()
                    .name(languageDto.getName())
                    .level(languageDto.getLevel())
                    .cv(cv)
                    .build();
            languageRepository.save(language);
        }
        return languageRepository.findAll();
    }
}

