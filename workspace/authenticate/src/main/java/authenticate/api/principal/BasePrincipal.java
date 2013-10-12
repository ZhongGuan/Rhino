package authenticate.api.principal;

import java.security.Principal;

public abstract class BasePrincipal implements Principal, Comparable<BasePrincipal> {

	private String name;

	public BasePrincipal(String name) {
		if (name == null) {
			throw new NullPointerException("Name may not be null.");
		}
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(BasePrincipal obj) {
		BasePrincipal other = (BasePrincipal) obj;
		int classComp = getClass().getName().compareTo(
				other.getClass().getName());
		if (classComp == 0) {
			return getName().compareTo(other.getName());
		} else {
			return classComp;
		}
	}

	@Override
	public int hashCode() {
		return getName().hashCode() * 19 + getClass().hashCode() * 19;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		BasePrincipal other = (BasePrincipal) obj;
		if (!getName().equals(other.getName())) {
			return false;
		}
		return true;
	}

}
