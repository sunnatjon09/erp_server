package uteam.b1_project_erp_education.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import uteam.b1_project_erp_education.entity.template.AbsNameEntity;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@MappedSuperclass
public class Course extends AbsNameEntity {
    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private Integer duration;

    @Column(length = 10000)
    private String description;


}


