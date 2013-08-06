package com.chunder.ego.gobj;

public final class sptr<T> extends GObj implements ptr<T> {
    final static String _name = "sptr";
    public T[] _base;
    public int _x;

    sptr(sliceT<T> s, int x) throws GError {
	super();
	_base = s._base;
	if (x < 0 || x >= s._len) {
	    throw new GError(slice.indexError);
	}
	_x = x + s._len;
    }

    public T get() {
	 return _base[_x];
    }

    public void set(T v) {
	 _base[_x] = v;
    }
}
