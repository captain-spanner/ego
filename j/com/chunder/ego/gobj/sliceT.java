package com.chunder.ego.gobj;

import java.util.Arrays;

public final class sliceT<T> extends slice {
    final static String _name = "sliceT";
    public T[] _base;

    sliceT() {
	super();
    }

    // new slice
    sliceT(int len, int cap) throws GError {
	super();
	make(len, cap);
	_base = newArray(cap);
    }

    // slice of slice
    sliceT(sliceT<T> src, int start, int end) throws GError {
	super();
	range(src, start, end);
	_base = src._base;
    }

    // slice contents copy
    sliceT(sliceT<T> src) throws GError {
	super();
	copy(src);
	_base = Arrays.copyOf(src._base, src._base.length);
   }

    // the reasoning is deep and forgettable
    static private <E> E[] newArray(int length, E... array)
    {
	return Arrays.copyOf(array, length);
    }

    // assignment to aliased slice
    public void assign(sliceT<T> src) throws GError {
	copy(src);
	_base = src._base;
    }

    public void set(int x, T v) throws GError {
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	_base[x + _off] = v;
    }

    public T get(int x) throws GError {
	if (x < 0 || x >= _len) {
	    throw new GError(indexError);
	}
	return _base[x + _off];
    }
}
