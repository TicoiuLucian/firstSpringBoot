package ro.itschool.util;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ro.itschool.entity.Pancake;
import ro.itschool.repository.PancakeRepository;

@Component
public class PancakeUtil {

    @Autowired
    private PancakeRepository pancakeRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {

        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            Pancake pancake = new Pancake();
            pancake.setName(faker.funnyName().name());
            pancake.setFlavour(faker.food().fruit());
            pancake.setPrice(faker.number().randomDigitNotZero());
            pancake.setWeight(faker.number().numberBetween(50, 150));
            pancakeRepository.save(pancake);
        }
    }
}
