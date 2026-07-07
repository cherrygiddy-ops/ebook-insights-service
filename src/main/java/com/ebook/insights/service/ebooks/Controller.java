package com.ebook.insights.service.ebooks;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/ebook-insights/ebooks")
public class Controller {

    private final Service ebookService;


    @PostMapping("/upload")
    public Ebook uploadEbook(@RequestParam("file") MultipartFile file,
                             @RequestParam("title") String title,
                             @RequestParam("publisherId") Long publisherId,
                             @RequestParam("author") String author) throws IOException {
        return ebookService.uploadEbook(file, title, publisherId, author);
    }


    @GetMapping
    public List<Ebook> getAllEbooks() {
        return ebookService.getAllEbooks();
    }

    @GetMapping("/publisher/{publisherId}")
    public List<Ebook> getEbooksByPublisher(@PathVariable Long publisherId) {
        return ebookService.getEbooksByPublisher(publisherId);
    }

    @GetMapping("/{id}")
    public Ebook getEbookById(@PathVariable String id) {
        return ebookService.getEbookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEbook(@PathVariable String id) {
        ebookService.deleteEbook(id);
    }
}
