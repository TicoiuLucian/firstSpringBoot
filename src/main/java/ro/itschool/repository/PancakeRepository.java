package ro.itschool.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Pancake;

import java.util.List;

public interface PancakeRepository extends JpaRepository<Pancake, Integer> {
    Pancake findByName (final String name);
}
