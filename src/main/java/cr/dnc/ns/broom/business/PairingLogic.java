package cr.dnc.ns.broom.business;

import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import cr.dnc.ns.broom.domain.CategoryCatalog;
import cr.dnc.ns.broom.domain.Category;
import cr.dnc.ns.broom.domain.Pair;

@Service
public class PairingLogic {
	public Set<Pair> process(final List<Pair> pairs) {
		/**
		 * Choosing LinkedHashSet for the result variable because we need:
		 * a) No duplicates (Set)
		 * b) To keep items ordered (not to be confused with sorted)
		 * 
		 * No other general purpose Set implementation provides these features.
		 */
		final Set<Pair> result = new LinkedHashSet<>();
		final Set<Category> validCategories = CategoryCatalog.getValidCategories();
		
		for (final Pair pair : pairs) {
			if (validCategories.contains(pair.getCategory())) {
				result.add(pair);
			}
		}
		
		return result;
	}
}
