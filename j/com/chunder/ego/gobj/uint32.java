package com.chunder.ego.gobj;

public final class uint32 extends GObj implements ptr32 {
    final static String _name = "uint32";
    public int _v;

    uint32() {
	super();
	_v = 0;
    }

    uint32(int v) {
	super();
	_v = v;
    }

    public static int shl(int a, int b) {
	if (b >= 0 && b < 32) {
	    return (int) (a << b);
	}
	return 0;
    }

    public static int shr(int a, int b) {
	if (b >= 0 && b < 32) {
	    return (int) ((((long) a) & 0xFFFFFFFF) >> b);
	}
	return 0;
    }

    public static int div(int a, int b) {
	return (int) ((((long) a) & 0xFFFFFFFF) / (((long) b) & 0xFFFFFFFF));
    }

    public static int rem(int a, int b) {
	return (int) ((((long) a) & 0xFFFFFFFF) % (((long) b) & 0xFFFFFFFF));
    }

    public static boolean less(int a, int b) {
	return (a - Integer.MIN_VALUE) < (b - Integer.MIN_VALUE);
    }

    public int get() {
	 return _v;
    }

    public void set(int v) {
	 _v = v;
    }
}
