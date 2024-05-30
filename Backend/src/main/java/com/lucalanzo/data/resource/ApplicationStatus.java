package com.lucalanzo.data.resource;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="status")
@Getter
public enum ApplicationStatus {
    APPLIED,
    INVITED,
    GHOSTED,
    DECLINED
}
