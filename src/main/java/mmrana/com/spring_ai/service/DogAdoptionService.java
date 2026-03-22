package mmrana.com.spring_ai.service;

import mmrana.com.spring_ai.entity.Dog;
import mmrana.com.spring_ai.repository.DogRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogAdoptionService {

    private final DogRepository repository;

    public DogAdoptionService(DogRepository repository) {
        this.repository = repository;
    }

    @McpTool(description = "List all dogs that are currently looking for a home.")
    public List<Dog> getAllAvailableDogs() {
        return repository.findByAdoptedFalse();
    }

    @McpTool(description = "Search for dogs based on their personality or history described in their profile.")
    public List<Dog> searchDogsByDescription(
            @McpToolParam(description = "Keyword to look for, e.g., 'apartment', 'kids', 'active'") String keyword
    ) {
        return repository.findByDescriptionContainingIgnoreCaseAndAdoptedFalse(keyword);
    }

    @McpTool(description = "Mark a dog as adopted once a user completes the process.")
    public String confirmAdoption(Long dogId) {
        Dog dog = repository.findById(dogId).orElseThrow();
        dog.setAdopted(true);
        repository.save(dog);
        return dog.getName() + " has been officially adopted! 🎉";
    }
}
