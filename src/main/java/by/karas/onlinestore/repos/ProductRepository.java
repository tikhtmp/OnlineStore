package by.karas.onlinestore.repos;

import by.karas.onlinestore.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
//    @Query("SELECT product FROM  Product product order by product.name")
//    //@Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
//    @Transactional(readOnly = true)
//    List<Product> findProducts();
//    List<Product> findAllByName(String name);
}
