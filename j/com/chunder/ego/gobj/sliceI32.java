package com.chunder.ego.gobj;

import java.util.Arrays;

public final class sliceI32 extends slice {
    final static String _name = "sliceI32";
    public int[] _base;

    sliceI32() {
	super();
    }

    // new slice
    sliceI32(int len, int cap) throws GError {
	super();
	make(len, cap);
	_base = new int[cap];
    }

    // slice of slice
    sliceI32(sliceI32 src, int start, int end) throws GError {
	super();
	range(src, start, end);
	_base = src._base;
    }

    // slice contents copy
    sliceI32(sliceI32 src) throws GError {
	super();
	copy(src);
	_base = Arrays.copyOf(src._base, src._base.length);
   }

    // assignment to aliased slice
    public void assign(sliceI32 src) throws GError {
	copy(src);
	_base = src._base;
    }

    public void set(int x, int v) throws GError {
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	_base[x + _off] = v;
    }

    public int get(int x) throws GError {
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	return _base[x + _off];
    }
}
