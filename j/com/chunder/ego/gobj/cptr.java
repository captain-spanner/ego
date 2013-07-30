package com.chunder.ego.gobj;

public final class cptr<T> extends GObj implements ptr<T> {
    final static String _name = "cptr";
    public T _p;

    cptr() {
	super();
	_p = null;
    }

    cptr(T p) {
	super();
	_p = p;
    }

    public T get() {
	 return _p;
    }

    public void set(T v) {
	 _p = v;
    }
}
