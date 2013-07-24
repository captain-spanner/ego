package com.chunder.ego.gobj;

import java.util.Arrays;

public final class sliceC64 extends slice {
    final static String _name = "sliceC64";
    public float[] _base;

    sliceC64() {
	super();
    }

    // new slice
    sliceC64(int len, int cap) throws GError {
	super();
	len *= 2;
	cap *= 2;
	make(len, cap);
	_base = new float[cap];
    }

    // slice of slice
    sliceC64(sliceC64 src, int start, int end) throws GError {
	super();
	start *= 2;
	end *= 2;
	range(src, start, end);
	_base = src._base;
    }

    // slice contents copy
    sliceC64(sliceC64 src) throws GError {
	super();
	copy(src);
	_base = Arrays.copyOf(src._base, src._base.length);
   }

    // assignment to aliased slice
    public void assign(sliceC64 src) throws GError {
	copy(src);
	_base = src._base;
    }

    public void set(int x, float r, float i) throws GError {
	x *= 2;
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	x += _off;
	_base[x] = r;
	_base[x + 1] = i;
    }

    public void get(int x, float[] v) throws GError {
	x *= 2;
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	x += _off;
	v[0] = _base[x];
	v[1] = _base[x + 1];
    }
}
