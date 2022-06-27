package ro.itschool.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Comparator;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pancake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String flavour;

    private Integer weight;

    private Integer price;

    private String wrapper;
}