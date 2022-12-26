package hrms.hrms.service;

import hrms.hrms.dto.request.CreateSkillRequest;
import hrms.hrms.dto.request.UpdateSkillRequest;
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

    protected List<Skill> createSkill(List<CreateSkillRequest> requests) {
        for (CreateSkillRequest skill : requests) {
             Skill skillToSave = Skill.builder()
                    .name(skill.getName())
                    .level(skill.getLevel())
                    .build();
            skillRepository.save(skillToSave);
        } return skillRepository.findAll();
    }

    protected List<Skill> updateSkill(List<UpdateSkillRequest> skills) {

        for (UpdateSkillRequest skill : skills) {
            Skill skillToUpdate = skillRepository.findById(skill.getId()).orElseThrow();
            skillToUpdate.setName(skill.getName());
            skillToUpdate.setLevel(skill.getLevel());
            skillRepository.save(skillToUpdate);
        } return skillRepository.findAll();
    }
}
