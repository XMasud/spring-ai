package mmrana.com.spring_ai.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dogs")
@Data
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String breed;

    private Integer age;

    @Column(length = 10)
    private String size;

    @Column(length = 20)
    private String temperament;

    private Boolean adopted = false;

    @Column(columnDefinition = "TEXT")
    private String description;
}
