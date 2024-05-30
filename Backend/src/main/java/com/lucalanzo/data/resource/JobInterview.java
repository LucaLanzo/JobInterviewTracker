package com.lucalanzo.data.resource;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Entity
@Document(collection="jobinterviews")
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
    private ApplicationStatus status = ApplicationStatus.APPLIED;
}
