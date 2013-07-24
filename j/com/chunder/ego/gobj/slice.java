package com.chunder.ego.gobj;

public abstract class slice extends GObj {
    final static String indexError = "index out of bounds";
    final static String sliceError = "slice range error";
    public int _off;
    public int _len;
    public int _cap;

    void make(int len, int cap) throws GError {
	if (len < 0 || cap < len) {
	    throw new GError(sliceError);
	}
	_off = 0;
	_len = len;
	_cap = cap;
    }

    void range(slice base, int start, int end) throws GError {
	int len = base._len;
	if (start < 0 || end < start || end > len) {
	    throw new GError(sliceError);
	}
	_off = base._off + start;
	_len = end - start;
	_cap = base._cap - start;
    }

    void copy(slice base) throws GError {
	_off = base._off;
	_len = base._len;
	_cap = base._cap;
    }
}
