package com.chunder.ego.gobj;

public final class uint16 extends GObj {
    final static String _name = "uint16";
    public short _v;

    uint16() {
	super();
	_v = 0;
    }

    uint16(short v) {
	super();
	_v = v;
    }

    public static short shl(short a, short b) {
	if (b >= 0 && b < 8) {
	    return (short) (a << b);
	}
	return 0;
    }

    public static short shr(short a, short b) {
	if (b >= 0 && b < 16) {
	    return (short) ((((int) a) & 0xFFFF) >> b);
	}
	return 0;
    }

    public static short div(short a, short b) {
	return (short) ((((int) a) & 0xFFFF) / (((int) b) & 0xFFFF));
    }

    public static short rem(short a, short b) {
	return (short) ((((int) a) & 0xFFFF) % (((int) b) & 0xFFFF));
    }

    public static boolean less(short a, short b) {
	return (a - Short.MIN_VALUE) < (b - Short.MIN_VALUE);
    }
}
