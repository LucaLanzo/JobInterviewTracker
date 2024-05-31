package com.lucalanzo.resource;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;

@Document
@Data
public class JobInterview {
    @Id
    @EqualsAndHashCode.Exclude
    private String id; // will be mapped to _id in Mongo

    @NotEmpty
    private String company;

    @Indexed
    @NotEmpty
    private String position;

    private Date dateApplied = new java.util.Date();

    @Field(targetType = FieldType.STRING)
    private ApplicationStatus status = ApplicationStatus.APPLIED;
}
