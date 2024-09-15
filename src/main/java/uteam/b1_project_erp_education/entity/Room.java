package uteam.b1_project_erp_education.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import uteam.b1_project_erp_education.entity.template.AbsNameEntity;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room extends AbsNameEntity {
    @Column(nullable = false)
    private Integer pupilSize;
}
