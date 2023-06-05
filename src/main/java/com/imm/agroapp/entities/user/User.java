package com.imm.agroapp.entities.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    private ObjectId id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private String roles;
    private List<Integer> localitzacions;
    private List<Integer> variables;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(roles.split(", ")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<Integer> getLocalitzacions() {
        return localitzacions;
    }

    public void setLocalitzacions(List<Integer> localitzacions) {
        this.localitzacions = localitzacions;
    }

    public List<Integer> getVariables() {
        return variables;
    }

    public void setVariables(List<Integer> variables) {
        this.variables = variables;
    }
}
