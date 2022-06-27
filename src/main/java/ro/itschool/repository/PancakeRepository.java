package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.itschool.entity.Pancake;

import java.util.Optional;

public interface PancakeRepository extends JpaRepository<Pancake, Integer> {

    @Query(value = "SELECT min(price) FROM Pancake")
    public Optional<Pancake> findByLowerPrice (Integer Price);

}
