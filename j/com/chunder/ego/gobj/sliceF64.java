package com.chunder.ego.gobj;

import java.util.Arrays;

public final class sliceF64 extends slice {
    final static String _name = "sliceF64";
    public double[] _base;

    sliceF64() {
	super();
    }

    // new slice
    sliceF64(int len, int cap) throws GError {
	super();
	make(len, cap);
	_base = new double[cap];
    }

    // slice of slice
    sliceF64(sliceF64 src, int start, int end) throws GError {
	super();
	range(src, start, end);
	_base = src._base;
    }

    // slice contents copy
    sliceF64(sliceF64 src) throws GError {
	super();
	copy(src);
	_base = Arrays.copyOf(src._base, src._base.length);
   }

    // assignment to aliased slice
    public void assign(sliceF64 src) throws GError {
	copy(src);
	_base = src._base;
    }

    public void set(int x, double v) throws GError {
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	_base[x + _off] = v;
    }

    public double get(int x) throws GError {
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	return _base[x + _off];
    }
}
