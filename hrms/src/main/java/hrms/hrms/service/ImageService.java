package hrms.hrms.service;

import hrms.hrms.dto.request.CreateImageRequest;
import hrms.hrms.dto.request.UpdateImageRequest;
import hrms.hrms.model.Image;
import hrms.hrms.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class ImageService {

    private final ImageRepository imageRepository;

    protected Image createImage(CreateImageRequest request) {
        Image image = Image.builder()
                .url(request.getUrl())
                .build();
        return imageRepository.save(image);
    }

    protected Image updateImage(UpdateImageRequest request) {
        Image image = imageRepository.findById(request.getId()).orElseThrow();
        image.setUrl(request.getUrl());
        return imageRepository.save(image);
    }
}
