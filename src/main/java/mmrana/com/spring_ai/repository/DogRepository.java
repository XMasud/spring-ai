package mmrana.com.spring_ai.repository;

import mmrana.com.spring_ai.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {
    List<Dog> findByAdoptedFalse();

    List<Dog> findByDescriptionContainingIgnoreCaseAndAdoptedFalse(String keyword);
}
