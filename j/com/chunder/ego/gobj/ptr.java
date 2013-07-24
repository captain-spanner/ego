package com.chunder.ego.gobj;

public final class ptr<T> extends GObj {
    final static String _name = "ptr";
    public T _p;

    ptr() {
	super();
	_p = null;
    }

    ptr(T p) {
	super();
	_p = p;
    }
}
