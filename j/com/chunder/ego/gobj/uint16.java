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

    public short div(short a, short b) {
	return (short) ((((int) a) & 0xFFFF) / (((int) b) & 0xFFFF));
    }

    public short rem(short a, short b) {
	return (short) ((((int) a) & 0xFFFF) % (((int) b) & 0xFFFF));
    }

    public boolean less(short a, short b) {
	return (a - Short.MIN_VALUE) < (b - Short.MIN_VALUE);
    }
}
