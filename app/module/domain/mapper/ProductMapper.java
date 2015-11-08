package module.domain.mapper;
import java.util.List;

import models.Product;

import org.apache.ibatis.annotations.Select;

public interface ProductMapper {
	@Select("select * from product ")
	List<Product> getProducts();
}
