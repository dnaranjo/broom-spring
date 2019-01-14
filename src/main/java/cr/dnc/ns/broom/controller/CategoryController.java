package cr.dnc.ns.broom.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cr.dnc.ns.broom.domain.Category;
import cr.dnc.ns.broom.domain.CategoryCatalog;

/**
 * 
 */
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryCatalog categoryRepo;
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public Set<Category> listValidCategories() {
		return CategoryCatalog.getValidCategories();
	}
	
	@RequestMapping(value = "/category/{name}", method = RequestMethod.PUT)
	public boolean addCategory(@PathVariable("name") final String name) {
		return categoryRepo.add(name);
	}
	
	@RequestMapping(value = "/category/{name}", method = RequestMethod.DELETE)
	public boolean deleteCategory(@PathVariable("name") final String name) {
		return categoryRepo.delete(name);
	}
}
