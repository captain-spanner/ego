package com.chunder.ego.gobj;

public final class int32 extends GObj implements ptr32 {
    final static String _name = "int32";
    public int _v;

    int32() {
	super();
	_v = 0;
    }

    int32(int v) {
	super();
	_v = v;
    }

    public static int shl(int a, int b) {
	if (b >= 0 && b < 16) {
	    return a << b;
	}
	return 0;
    }

    public static int shr(int a, int b) {
	if (b >= 0 && b < 32) {
	    return a >> b;
	}
	return a >> 31;
    }

    public static int div(int a, int b) {
	boolean n;
	if (a < 0) {
	    a = (int) -a;
	    n = true;
	} else {
	    n = false;
	}
	if (b < 0) {
	    b = (int) -b;
	    n = !n;
	}
	if (n) {
		return (int) -uint32.div(a, b);
	} else {
		return (int) uint32.div(a, b);
	}
    }

    public static int rem(int a, int b) {
	boolean n;
	if (a < 0) {
	    a = (int) -a;
	    n = true;
	} else {
	    n = false;
	}
	if (b < 0) {
	    b = (int) -b;
	}
	if (n) {
		return (int) -uint32.rem(a, b);
	} else {
		return (int) uint32.rem(a, b);
	}
    }

    public int get() {
	 return _v;
    }

    public void set(int v) {
	 _v = v;
    }
}
