package hrms.hrms.service;

import hrms.hrms.dto.request.CreateLanguageRequest;
import hrms.hrms.dto.request.UpdateLanguageRequest;
import hrms.hrms.model.Language;
import hrms.hrms.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepository languageRepository;

    protected List<Language> createLanguage(List<CreateLanguageRequest> languages) {

        for (CreateLanguageRequest languageDto : languages) {
            Language language = Language.builder()
                    .name(languageDto.getName())
                    .level(languageDto.getLevel())
                    .build();
            languageRepository.save(language);
        }
        return languageRepository.findAll();
    }

    protected List<Language> updateLanguage(List<UpdateLanguageRequest> languages) {
        for (UpdateLanguageRequest languageDto : languages) {
            Language language = languageRepository.findById(languageDto.getId()).orElseThrow();
            language.setName(languageDto.getName());
            language.setLevel(languageDto.getLevel());
            languageRepository.save(language);
        }
        return languageRepository.findAll();
    }
}

