package uteam.b1_project_erp_education.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uteam.b1_project_erp_education.entity.enums.MonthlySalaryType;
import uteam.b1_project_erp_education.entity.template.AbsEntity;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Users extends AbsEntity implements UserDetails {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    private Date birthDate;

    private String phoneNumber;
    private String personPhoneNumber;

    @Enumerated(EnumType.STRING)
    private MonthlySalaryType monthlySalaryType;

    private double percent;

    private double salary;

    private String email;

    private String userName;

    private String password;

    private String photoId;

    @ManyToMany
    private Set<Role> roles;

    private boolean enabled = true;
    private boolean credentialsNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean accountNonExpired = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() { //Xisob muddati
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() { //Xisob bloklanganmi
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() { //Xisob vaqti tugaganini bildiradi
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() { //Xisob ishlashi yoki yo'qligini tekshiradi
        return enabled;
    }
}
