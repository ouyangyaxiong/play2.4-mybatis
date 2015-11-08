package service.module;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import models.User;

public interface UserMapper {
	
	@Select("select * from user")
	List<User> all();

	User getUserById(Long id);
}
