package com.powernode.problem.config;

import com.powernode.problem.model.BookRecord;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Setter
@Getter
@ConfigurationProperties(prefix = "product")
public class BookContainer {
    private List<BookRecord> books;
}
