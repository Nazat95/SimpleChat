package com.fatin.chatapp.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "hostUsers")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany (mappedBy = "hostUsers")
    private List <Users> users = new ArrayList<>();

    public Role(String name, List<Users> users) {
        this.name = name;
        this.users = users;
    }
    public Role (String name){
        this.name = name;
    }
}
