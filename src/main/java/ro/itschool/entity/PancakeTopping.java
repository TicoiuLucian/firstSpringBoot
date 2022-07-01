package ro.itschool.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PancakeTopping implements Serializable {

    @Column(name = "id")
    Integer pancakeId;

    @Column(name = "id")
    Integer toppingId;
}
