package cr.dnc.ns.broom.domain;

public class Counter implements Comparable {
	private final Category category;
	private final int occurrences;
	
	public Counter(final Category category, final int occurrences) {
		super();
		this.category = category;
		this.occurrences = occurrences;
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	public int getOccurrences() {
		return this.occurrences;
	}

	@Override
	public int compareTo(final Object obj) {
		final Counter other = (Counter) obj;
		return other.occurrences - this.occurrences;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Counter)) {
			return false;
		}
		Counter other = (Counter) obj;
		return this.category.equals(other.category) && this.occurrences == other.occurrences;
	}
	
	@Override
	public int hashCode() {
		return this.category.hashCode();
	}
}
