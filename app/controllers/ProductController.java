package controllers;

import java.util.List;

import com.google.inject.Inject;

import models.Product;
import module.domain.mapper.ProductMapper;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
public class ProductController extends Controller{
	@Inject
	ProductMapper pmapper;
	public Result show(){
		List<Product> plist=pmapper.getProducts();
		return ok(views.html.productview.productlist.render(plist));
	}
}
