package module.domain;

import java.util.Date;
import java.util.List;

import module.domain.mapper.ComputerMapper;

import com.google.inject.Inject;

public class Computer implements ComputerDao {
	@Inject
	 private ComputerMapper mapper;

	 private Integer id;

	 private String name;

	 private Date introduced;

	 private Date discontinued;

	 public Integer getId() {

	 return id;

	 }

	 public void setId(Integer id) {

	 this.id = id;

	 }

	 public String getName() {

	 return name;

	 }

	 public void setName(String name) {

	 this.name = name;

	 }

	 public Date getIntroduced() {

	 return introduced;

	 }

	 public void setIntroduced(Date introduced) {

	 this.introduced = introduced;

	 }

	 public Date getDiscontinued() {

	 return discontinued;

	 }

	 public void setDiscontinued(Date discontinued) {

	 this.discontinued = discontinued;

	 }

	 @Override

	 public Computer getById(int id) {

	 return this.mapper.getById(id);

	 }

	 @Override

	 public List<Computer> getAll() {

	 return this.mapper.getAll();

	 }

	 @Override

	 public int save(Computer object) {

	 if (object.id == null || object.id == 0){

	 return this.mapper.append(object);

	 }else{

	 return this.mapper.update(object);

	 }

	 }

	 @Override
	 public int remove(int id) {

	 return this.mapper.remove(id);

	 }


}
