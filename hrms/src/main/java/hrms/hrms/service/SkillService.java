package hrms.hrms.service;

import hrms.hrms.dto.request.CreateSkillRequest;
import hrms.hrms.model.CV;
import hrms.hrms.model.Skill;
import hrms.hrms.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class SkillService {

    private final SkillRepository skillRepository;
    private final CVService cvService;
    protected List<Skill> createSkill(List<CreateSkillRequest> requests, CV cv) {
        for (CreateSkillRequest skill : requests) {
             Skill skillToSave = Skill.builder()
                    .name(skill.getName())
                    .level(skill.getLevel())
                     .cv(cv)
                    .build();
            skillRepository.save(skillToSave);
        } return skillRepository.findAll();
    }
}
