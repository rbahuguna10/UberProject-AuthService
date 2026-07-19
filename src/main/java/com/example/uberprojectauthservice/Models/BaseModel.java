package com.example.uberprojectauthservice.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class) // So that Spring Data JPA can handle 'createdAt' & 'updatedAt' automatically
@MappedSuperclass
@Getter
@Setter
// This class consist of those bare minimum properties that any other class will require:
public abstract class BaseModel { // abstract because we do not want anyone to create an object of this class
    @Id // This annotation defines the variable as a primary key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY means auto-increment
    protected Long id;

    @Column(nullable = false) // To set 'createdAt' as not null
    @Temporal(TemporalType.TIMESTAMP) // To automate 'createdAt',this annotation tells spring about the format of object to be stored
    @CreatedDate // This annotation tells spring to only handle it for object creation
    protected Date createdAt;

    @Column(nullable = false) // To set 'updatedAt' as not null
    @Temporal(TemporalType.TIMESTAMP) // To automate 'updatedAtAt',this annotation tells spring about the format of object to be stored
    @LastModifiedDate // This annotation tells spring to only handle it for object update
    protected Date updatedAt;
}
