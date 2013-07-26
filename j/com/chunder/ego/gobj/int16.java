package com.chunder.ego.gobj;

public final class int16 extends GObj {
    final static String _name = "int16";
    public short _v;

    int16() {
	super();
	_v = 0;
    }

    int16(short v) {
	super();
	_v = v;
    }

    public static short shl(short a, short b) {
	if (b >= 0 && b < 16) {
	    return (short) (a << b);
	}
	return 0;
    }

    public static short shr(short a, short b) {
	if (b >= 0 && b < 16) {
	    return (short) (a >> b);
	}
	return (short) (a >> 15);
    }

    public static short div(short a, short b) {
	boolean n;
	if (a < 0) {
	    a = (short) -a;
	    n = true;
	} else {
	    n = false;
	}
	if (b < 0) {
	    b = (short) -b;
	    n = !n;
	}
	if (n) {
		return (short) -uint16.div(a, b);
	} else {
		return (short) uint16.div(a, b);
	}
    }

    public static short rem(short a, short b) {
	boolean n;
	if (a < 0) {
	    a = (short) -a;
	    n = true;
	} else {
	    n = false;
	}
	if (b < 0) {
	    b = (short) -b;
	}
	if (n) {
		return (short) -uint16.rem(a, b);
	} else {
		return (short) uint16.rem(a, b);
	}
    }
}
