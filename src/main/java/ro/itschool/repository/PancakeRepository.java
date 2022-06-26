package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Pancake;

public interface PancakeRepository extends JpaRepository<Pancake, Integer> {
    Pancake findByName (final String name);
}
