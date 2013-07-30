package com.chunder.ego.gobj;

public final class uint8 extends GObj implements ptr8 {
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

    public static byte shl(byte a, byte b) {
	if (b >= 0 && b < 8) {
	    return (byte) (a << b);
	}
	return 0;
    }

    public static byte shr(byte a, byte b) {
	if (b >= 0 && b < 8) {
	    return (byte) ((((int) a) & 0xFF) >> b);
	}
	return 0;
    }

    public static byte div(byte a, byte b) {
	return (byte) ((((int) a) & 0xFF) / (((int) b) & 0xFF));
    }

    public static byte rem(byte a, byte b) {
	return (byte) ((((int) a) & 0xFF) % (((int) b) & 0xFF));
    }

    public static boolean less(byte a, byte b) {
	return (a - Byte.MIN_VALUE) < (b - Byte.MIN_VALUE);
    }

    public byte get() {
	 return _v;
    }

    public void set(byte v) {
	 _v = v;
    }
}
