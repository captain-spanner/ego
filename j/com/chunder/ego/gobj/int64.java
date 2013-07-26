package com.chunder.ego.gobj;

public final class int64 extends GObj {
    final static String _name = "int64";
    public long _v;

    int64() {
	super();
	_v = 0;
    }

    int64(long v) {
	super();
	_v = v;
    }

    public static long div(long a, long b) {
	boolean n;
	if (a < 0) {
	    a = (long) -a;
	    n = true;
	} else {
	    n = false;
	}
	if (b < 0) {
	    b = (long) -b;
	    n = !n;
	}
	if (n) {
		return (long) -uint64.div(a, b);
	} else {
		return (long) uint64.div(a, b);
	}
    }

    public static long rem(long a, long b) {
	boolean n;
	if (a < 0) {
	    a = (long) -a;
	    n = true;
	} else {
	    n = false;
	}
	if (b < 0) {
	    b = (long) -b;
	}
	if (n) {
		return (long) -uint64.rem(a, b);
	} else {
		return (long) uint64.rem(a, b);
	}
    }
}
