package com.fatin.chatapp.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hostUsers")
public class HostUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @ManyToMany (mappedBy = "hostUsers")
    private List <Users> users = new ArrayList<>();

    public HostUsers(String username, List<Users> users) {
        this.username = username;
        this.users = users;
    }
}
