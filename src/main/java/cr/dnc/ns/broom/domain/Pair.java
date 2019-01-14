package cr.dnc.ns.broom.domain;

public class Pair {
	private Category category;
	private String subCategory;
	
	public Pair() {}
	
	public Pair(final Category key, final String value) {
		super();
		this.category = key;
		this.subCategory = value;
	}

	public Category getCategory() {
		return this.category;
	}
	
	public String getSubCategory() {
		return this.subCategory;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof Pair)) {
			return false;
		}
		final Pair other = (Pair) obj;
		return this.category.equals(other.category) && this.subCategory.equals(other.subCategory);
	}
	
	@Override
	public int hashCode() {
		return this.category.hashCode();
	}
}
