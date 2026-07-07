package com.ebook.insights.service.ebooks;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ebooks")
public class Ebook {
    @Id
    private String id;

    private String title;
    private Long publisherId;   // reference to Postgres publisher
    private List<String> tags;
    private List<Chapter> chapters;
    private Instant createdAt;
    private String author;
    private String description;
    private String filePath;
}

