package ro.itschool.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pancake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String wrapper;

    private String name;

    private String flavour;

    private Integer weight;

    private Integer price;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pancake_topping",
    joinColumns = @JoinColumn (name = "id"),
    inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Topping> toppings = new HashSet<>();

    public void addToppingToPancake(Topping topping) {
        toppings.add(topping);
        topping.addPancakeToTopping(this);
    }


}
