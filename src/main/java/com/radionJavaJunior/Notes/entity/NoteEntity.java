package com.radionJavaJunior.Notes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.Instant;

@Entity
@Table(name = "note")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String title;

    private String description;
    private Instant createAt;
    private Instant updateAt;
}
