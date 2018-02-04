package com.agileboard.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
@NoArgsConstructor
@Document
public class User implements UserDetails {
    @Id
    private ObjectId id;
    private String username; //email
    private String password;
    private String name;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private List<Role> authorities;
    private List<ObjectId> tickets;

    public User(ObjectId id, String username, String password, String name, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, List<Role> authorities, List<ObjectId> tickets) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.authorities = authorities;
        this.tickets = tickets;
    }
}
