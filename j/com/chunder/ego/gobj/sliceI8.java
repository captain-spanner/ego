package com.chunder.ego.gobj;

import java.util.Arrays;

public final class sliceI8 extends slice {
    final static String _name = "sliceI8";
    public byte[] _base;

    sliceI8() {
	super();
    }

    // new slice
    sliceI8(int len, int cap) throws GError {
	super();
	make(len, cap);
	_base = new byte[cap];
    }

    // slice of slice
    sliceI8(sliceI8 src, int start, int end) throws GError {
	super();
	range(src, start, end);
	_base = src._base;
    }

    // slice contents copy
    sliceI8(sliceI8 src) throws GError {
	super();
	copy(src);
	_base = Arrays.copyOf(src._base, src._base.length);
   }

    // assignment to aliased slice
    public void assign(sliceI8 src) throws GError {
	copy(src);
	_base = src._base;
    }

    public void set(int x, byte v) throws GError {
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	_base[x + _off] = v;
    }

    public byte get(int x) throws GError {
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	return _base[x + _off];
    }
}
