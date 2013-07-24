package com.chunder.ego.gobj;

import java.util.Arrays;

public final class sliceF32 extends slice {
    final static String _name = "sliceF32";
    public float[] _base;

    sliceF32() {
	super();
    }

    // new slice
    sliceF32(int len, int cap) throws GError {
	super();
	make(len, cap);
	_base = new float[cap];
    }

    // slice of slice
    sliceF32(sliceF32 src, int start, int end) throws GError {
	super();
	range(src, start, end);
	_base = src._base;
    }

    // slice contents copy
    sliceF32(sliceF32 src) throws GError {
	super();
	copy(src);
	_base = Arrays.copyOf(src._base, src._base.length);
   }

    // assignment to aliased slice
    public void assign(sliceF32 src) throws GError {
	copy(src);
	_base = src._base;
    }

    public void set(int x, float v) throws GError {
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	_base[x + _off] = v;
    }

    public float get(int x) throws GError {
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	return _base[x + _off];
    }
}
