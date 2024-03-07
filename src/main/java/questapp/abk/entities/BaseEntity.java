package questapp.abk.entities;

import jakarta.persistence.*;
import lombok.Data;
import questapp.abk.constraints.CommonConstraint;

import java.time.LocalDate;

@MappedSuperclass
@Data
public class BaseEntity {
    @TableGenerator(
            name = "yourTableGenerator",
            allocationSize = 1,
            initialValue = 0 )
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;

    @Column(name = CommonConstraint.COLUMN_CREATE_DATE)
    LocalDate createDate;

    @Column(name = CommonConstraint.COLUMN_UPDATE_DATE)
    LocalDate updateDate;
}
