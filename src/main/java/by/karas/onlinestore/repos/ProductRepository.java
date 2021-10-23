package by.karas.onlinestore.repos;

import by.karas.onlinestore.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
