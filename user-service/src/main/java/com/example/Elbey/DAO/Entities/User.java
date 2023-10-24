package com.example.Elbey.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idUser;

    String firstName;
    String lasttName;
    String password;
    String verifPassword;
    long phone;
    String email;
    String profession;
    long cin;
    int ancienneteEmploi;
    String typeContratEmploi ;
    int proprietaire;
    float salaire=800;
    Date dateNaissance=new Date();
    boolean historiqueCredit;
    boolean active;

    @ManyToOne
    Role roles;


}
