package com.ebook.insights.service.ebooks;

import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {

    private final Repository ebookRepository;

    public Ebook uploadEbook(MultipartFile file, String title, Long publisherId, String author) throws IOException {
        // Save file to local folder
        String uploadDir = "uploads/ebooks/";
        Path path = Paths.get(uploadDir + file.getOriginalFilename());
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());

        // Save metadata in MongoDB
        Ebook ebook = new Ebook();
        ebook.setTitle(title);
        ebook.setPublisherId(publisherId);
        ebook.setAuthor(author);
        ebook.setFilePath(path.toString());

        return ebookRepository.save(ebook);
    }


    public List<Ebook> getAllEbooks() {
        return ebookRepository.findAll();
    }

    public List<Ebook> getEbooksByPublisher(Long publisherId) {
        return ebookRepository.findByPublisherId(publisherId);
    }

    public Ebook getEbookById(String id) {
        return ebookRepository.findById(id).orElse(null);
    }

    public void deleteEbook(String id) {
        ebookRepository.deleteById(id);
    }
}

