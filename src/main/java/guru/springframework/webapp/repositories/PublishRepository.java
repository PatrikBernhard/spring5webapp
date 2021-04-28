package guru.springframework.webapp.repositories;

import guru.springframework.webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublishRepository extends CrudRepository<Publisher, Long> {
}
