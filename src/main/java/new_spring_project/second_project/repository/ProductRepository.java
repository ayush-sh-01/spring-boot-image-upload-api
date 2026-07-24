package new_spring_project.second_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import new_spring_project.second_project.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
}