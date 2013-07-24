package com.chunder.ego.gobj;

import java.util.Arrays;

public final class sliceI16 extends slice {
    final static String _name = "sliceI16";
    public short[] _base;

    sliceI16() {
	super();
    }

    // new slice
    sliceI16(int len, int cap) throws GError {
	super();
	make(len, cap);
	_base = new short[cap];
    }

    // slice of slice
    sliceI16(sliceI16 src, int start, int end) throws GError {
	super();
	range(src, start, end);
	_base = src._base;
    }

    // slice contents copy
    sliceI16(sliceI16 src) throws GError {
	super();
	copy(src);
	_base = Arrays.copyOf(src._base, src._base.length);
   }

    // assignment to aliased slice
    public void assign(sliceI16 src) throws GError {
	copy(src);
	_base = src._base;
    }

    public void set(int x, short v) throws GError {
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	_base[x + _off] = v;
    }

    public short get(int x) throws GError {
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	return _base[x + _off];
    }
}
