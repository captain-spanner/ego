package com.chunder.ego.gobj;

public final class uint8 extends GObj {
    final static String _name = "uint8";
    public byte _v;

    uint8() {
	super();
	_v = 0;
    }

    uint8(byte v) {
	super();
	_v = v;
    }

    public byte div(byte a, byte b) {
	return (byte) ((((short) a) & 0xFF) / (((short) b) & 0xFF));
    }

    public byte rem(byte a, byte b) {
	return (byte) ((((short) a) & 0xFF) % (((short) b) & 0xFF));
    }

    public boolean less(byte a, byte b) {
	return (a - Byte.MIN_VALUE) < (b - Byte.MIN_VALUE);
    }
}
