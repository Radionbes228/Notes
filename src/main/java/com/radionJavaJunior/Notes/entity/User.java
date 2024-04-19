package com.radionJavaJunior.Notes.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_user")
public class User {
    @Id
    private Long id;

    private String name;
    private String password;
    private String roles;
}
