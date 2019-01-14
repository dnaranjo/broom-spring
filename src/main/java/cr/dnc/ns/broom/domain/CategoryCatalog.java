package cr.dnc.ns.broom.domain;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class CategoryCatalog {
	/**
	 * Choosing CopyOnWriteArraySet for the list of categories because we need:
	 * a) No duplicates (Set).
	 * b) Support for concurrency (CopyOnWriteArraySet is a concurrent collection)
	 * c) A collection designed to be "rarely modified but frequently iterated".
	 */
	private static final Set<Category> validCategories = new CopyOnWriteArraySet<>();
	
	@PostConstruct
	public void init() {
		CategoryCatalog.validCategories.clear();
		add("PERSON", "PLACE", "ANIMAL", "COMPUTER", "OTHER");
	}
	
	public void add(final String... names) {
		for (final String name : names) {
			add(name);
		}
	}
	
	public boolean add(final String name) {
		final Category category = new Category(name);
		return validCategories.add(category);
	}
	
	public boolean delete(final String name) {
		return validCategories.remove(new Category(name));
	}
	
	public static Set<Category> getValidCategories() {
		return new CopyOnWriteArraySet<>(validCategories);
	}
}
