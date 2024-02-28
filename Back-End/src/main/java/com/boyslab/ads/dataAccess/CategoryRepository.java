package com.boyslab.ads.dataAccess;
import com.boyslab.ads.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    long countByName(String  name);
}
