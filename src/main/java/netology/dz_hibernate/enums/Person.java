package netology.dz_hibernate.enums;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private Integer age;
    private String phoneNumber;
    @Column(nullable = false)
    private String cityOfLiving;

}
