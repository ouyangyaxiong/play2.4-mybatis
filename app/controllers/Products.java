package controllers;

import models.Product;


import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
public class Products extends Controller{
	public Result newInstance(){
		Form<models.Product> productForm=Form.form(models.Product.class);
		return ok(product.render(productForm,null));
	}
	
	public Result edit(Long id){
//		Form<models.Product> productForm=Form.form(models.Product.class);
//		models.Product myproduct=Ebean.find(models.Product.class,id);
//		productForm=productForm.fill(myproduct);
//		//models.Product product=models.Product.find.where().eq("ean",ean).findUnique();
//		return ok(product.render(productForm,id));
////	Long  i		=Ebean.find(models.Product.class,id).Id;
	return ok();
	}
	
	public Result save(){
		Form<models.Product> form= Form.form(models.Product.class).bindFromRequest();
//		Product pf=form.get();
//		if(pf.Id!=null){
//			pf.update();
//		}
//		else{
//			pf.save();
//		}
		return ok("保存成功");
		
	}
}

