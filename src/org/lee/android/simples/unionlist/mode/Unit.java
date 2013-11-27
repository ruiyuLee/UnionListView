package org.lee.android.simples.unionlist.mode;

public class Unit {
	public int position;
	public Bean[] Children;

	public Unit(Bean... is) {
		Children = is;
	}

	public int length() {
		return Children == null ? 0 : Children.length;
	}

}