package controllers;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import models.Product;
import module.domain.Computer;
import module.domain.ComputerDao;
import module.domain.mapper.ComputerMapper;
import play.mvc.Controller;
import play.mvc.Result;
import service.module.UserMapper;
import views.html.*;


public class Application extends Controller {
	@Inject
	ComputerDao cpd;
    public Result index() {
//    	Product product=new Product();
//    	product.name="coffe";
//    	product.ean="23123123123";
//    	product.description="nice sweat ";
//    	product.save();
    	
        return ok(views.html.index.render("Your new application is ready."));
    }
    
//    public Result show(){
//    	Set<Product> products= Ebean.find(Product.class).findSet();
//    	return ok(show.render(products));
//    }
    
    public Result test(){
    	List<Computer> cplist=cpd.getAll();
    	System.out.println("cplist=="+cplist);
    	return ok("dsd");
    	
    }
    
    private UserMapper userService;

    @Inject
    public Application(UserMapper userMapper) {
        this.userService = userMapper;
    }

    public Result listUsers() {
        return ok(test.render(userService.all()));
    }

//    public Result showUser(Long id) {
//        return ok(profile.render(userService.getUserById(id)));
//    }

   
}
