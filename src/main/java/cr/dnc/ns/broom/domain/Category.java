package cr.dnc.ns.broom.domain;

import cr.dnc.ns.broom.util.StringUtil;

public class Category {
	private final String name;
	
	public Category(final String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	/*public void setName(final String name) {
		this.name = name;
	}*/
	
	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof Category)) {
			return false;
		}
		final Category other = (Category) obj;
		return StringUtil.canonize(this.name).equals(StringUtil.canonize(other.name));
	}
	
	@Override
	public int hashCode() {
		return StringUtil.canonize(this.name).hashCode();
	}
}
