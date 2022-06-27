package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.itschool.entity.Pancake;

import java.util.List;
import java.util.Optional;

public interface PancakeRepository extends JpaRepository<Pancake, Integer> {

}
