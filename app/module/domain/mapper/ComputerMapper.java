package module.domain.mapper;

import java.util.List;

import module.domain.Computer;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//import org.mybatis.caches.ehcache.EhcacheCache;

//@CacheNamespace(implementation=EhcacheCache.class)

//启用上面这样代码可以为应用带来缓存的效果，可以提升性能，但在开发阶段，修改了页面模板后刷新浏览器会出现异常。建议在开发阶段禁用缓存，仅在正式上线后开启。

public interface ComputerMapper {

	@Select("select * from computer where id=#{id}")
	@Options(flushCache = false, fetchSize = 1)
	@Results(value = {

	@Result(property = "id", column = "id"),

	@Result(property = "name", column = "name"),

	@Result(property = "introduced", column = "introduced"),

	@Result(property = "discontinuted", column = "discontinuted")

	})
	public Computer getById(@Param("id") final int id);

	@Select("select * from computer order by name asc")
	@Options(flushCache = false)
	@Results(value = {

	@Result(property = "id", column = "id"),

	@Result(property = "name", column = "name"),

	@Result(property = "introduced", column = "introduced"),

	@Result(property = "discontinuted", column = "discontinuted")

	})
	public List<Computer> getAll();

	@Insert("insert into computer(id, name, introduced, discontinued) values(#{id}, #{name}, #{introduced}, #{discontinued})")
	@Options(useGeneratedKeys = true, keyProperty = "id", flushCache = true)
	public int append(final Computer object);

	@Update("update computer set name=#{name}, introduced=#{introduced}, discontinued=#{discontinued} where id=#{id}")
	@Options(flushCache = true)
	public int update(final Computer object);

	@Delete("delete from computer where id=#{id}")
	@Options(flushCache = true)
	public int remove(@Param("id") final int id);
}
