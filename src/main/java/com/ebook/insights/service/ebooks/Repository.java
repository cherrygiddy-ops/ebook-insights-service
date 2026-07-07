package com.ebook.insights.service.ebooks;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface Repository extends MongoRepository<Ebook, String> {
    List<Ebook> findByPublisherId(Long publisherId);
}

