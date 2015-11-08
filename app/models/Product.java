package models;

/**
 * @author ouyaxiong  
 * @ClassName: Product 
 * @Description: TODO
 * @author ouyangyaxiong 
 * @date 2015年10月17日 下午8:46:15  
 */
public class Product{
	
	public Long Id;
	public String name;
	public String ean;
	public String description;

	
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEan() {
		return ean;
	}


	public void setEan(String ean) {
		this.ean = ean;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}
