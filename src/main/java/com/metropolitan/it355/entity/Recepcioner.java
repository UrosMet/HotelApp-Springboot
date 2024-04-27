package com.metropolitan.it355.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recepcioner")
public class Recepcioner implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Recepcionera", nullable = false)
    private Integer id;

    @Column(name = "Ime", length = 50)
    private String ime;

    @Column(name = "Prezime", length = 50)
    private String prezime;

    @Column(name = "Korisnicko_Ime", length = 50)
    private String korisnickoIme;

    @Column(name = "Lozinka", length = 255)
    private String lozinka;


    @Column(name = "Role", nullable = false)
    private String role = "USER";

    @JsonIgnore
    private static final Map<String, List<String>> rolePermissions = Map.of(
            "USER", Arrays.asList("READ_ONLY"),
            "ADMIN", Arrays.asList("FULL_ACCESS")
    );
    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = rolePermissions.get(role).stream().map(
                permission -> new SimpleGrantedAuthority(permission)
        ).collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @JsonIgnore
    @Override
    public String getPassword() {
        return this.getLozinka();
    }

    /**
     * Returns the username used to authenticate the user. Cannot return
     * <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @JsonIgnore
    @Override
    public String getUsername() {
        return this.getKorisnickoIme();
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}