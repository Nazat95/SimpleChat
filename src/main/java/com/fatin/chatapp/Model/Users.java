package com.fatin.chatapp.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String username;
    @Column (nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    public Users(String username, String name, String email, String password, List<Role> hostUsers) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.hostUsers = hostUsers;
    }

    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> hostUsers = new ArrayList<>();

}
