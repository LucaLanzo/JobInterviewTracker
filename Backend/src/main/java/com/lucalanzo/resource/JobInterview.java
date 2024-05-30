package com.lucalanzo.resource;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.sql.Date;


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

    @NotNull
    private Date dateApplied;

    @NotEmpty
    @Field(targetType = FieldType.INT32)
    private ApplicationStatus status = ApplicationStatus.APPLIED;
}
