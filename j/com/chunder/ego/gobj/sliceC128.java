package com.chunder.ego.gobj;

import java.util.Arrays;

public final class sliceC128 extends slice {
    final static String _name = "sliceC128";
    public double[] _base;

    sliceC128() {
	super();
    }

    // new slice
    sliceC128(int len, int cap) throws GError {
	super();
	len *= 2;
	cap *= 2;
	make(len, cap);
	_base = new double[cap];
    }

    // slice of slice
    sliceC128(sliceC128 src, int start, int end) throws GError {
	super();
	start *= 2;
	end *= 2;
	range(src, start, end);
	_base = src._base;
    }

    // slice contents copy
    sliceC128(sliceC128 src) throws GError {
	super();
	copy(src);
	_base = Arrays.copyOf(src._base, src._base.length);
   }

    // assignment to aliased slice
    public void assign(sliceC128 src) throws GError {
	copy(src);
	_base = src._base;
    }

    public void set(int x, double r, double i) throws GError {
	x *= 2;
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	x += _off;
	_base[x] = r;
	_base[x + 1] = i;
    }

    public void get(int x, double[] v) throws GError {
	x *= 2;
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	x += _off;
	v[0] = _base[x];
	v[1] = _base[x + 1];
    }
}
