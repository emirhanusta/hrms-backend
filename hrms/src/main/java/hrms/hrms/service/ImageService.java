package hrms.hrms.service;

import hrms.hrms.dto.request.CreateImageRequest;
import hrms.hrms.model.CV;
import hrms.hrms.model.Image;
import hrms.hrms.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class ImageService {

    private final ImageRepository imageRepository;
    private final CVService cvService;
    public Image createImage(CreateImageRequest request, CV cv) {
        Image image = Image.builder()
                .url(request.getUrl())
                .cv(cv)
                .build();
        return imageRepository.save(image);
    }
}
