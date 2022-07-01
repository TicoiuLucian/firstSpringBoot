package ro.itschool.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String flavour;

    private Integer price;

    @ManyToMany(mappedBy = "toppings", fetch = FetchType.EAGER)
    private Set<Pancake> pancakes = new HashSet<>();


    public Topping(String toppingName) {
        this.name = toppingName;
        this.pancakes = pancakes;
    }

    public void addPancakeToTopping(Pancake pancake) {
        pancakes.add(pancake);
    }

}


