package com.yemmback.store.security;

import com.yemmback.store.model.User;
import com.yemmback.store.model.colections.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class UserPrincipal implements UserDetails {
    private Long id;

    private String username;

    @Builder.Default
    private Role role = Role.ROLE_USER;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;
    private SimpleGrantedAuthority authoritie ;

    public UserPrincipal(Long id,  String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public UserPrincipal(Long id, String username, Role role, String email, String password, SimpleGrantedAuthority authoritie) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.email = email;
        this.password = password;
        this.authoritie = authoritie;
    }

    public static UserPrincipal create(User user) {

        SimpleGrantedAuthority authoritie  = new SimpleGrantedAuthority(user.getRole().name());

        return new UserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(authoritie)
        );
    }

    public Long getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public SimpleGrantedAuthority getAuthoritie() {
        return authoritie;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
