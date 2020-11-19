package com.greenfox.backendapi.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @CreationTimestamp
//    @Temporal(TemporalType.DATE)
    @Column
//    private Date creation;
    private Instant creation;
    @Column
    private String endpoint;
    @Column
    private String data;

    public Log(String endpoint, String data) {
        this.endpoint = endpoint;
        this.data = data;
        this.creation = Instant.now();
    }
}