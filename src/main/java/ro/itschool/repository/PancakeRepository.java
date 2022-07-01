package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.itschool.entity.Pancake;

import java.util.List;

public interface PancakeRepository extends JpaRepository<Pancake, Integer> {
    Pancake findByName (final String name);

    @Query("SELECT p FROM Pancake p WHERE CONCAT(p.id, '') LIKE %?1%"
            + " OR p.name LIKE %?1%"
            + " OR p.flavour LIKE %?1%"
            + " OR CONCAT(p.weight, '') LIKE %?1%"
            + " OR CONCAT(p.price, '') LIKE %?1%")

    List<Pancake> search(String keyword);
}
