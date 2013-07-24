package com.chunder.ego.gobj;

public final class uint32 extends GObj {
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

    public int div(int a, int b) {
	return (int) ((((long) a) & 0xFFFFFFFF) / (((long) b) & 0xFFFFFFFF));
    }

    public int rem(int a, int b) {
	return (int) ((((long) a) & 0xFFFFFFFF) % (((long) b) & 0xFFFFFFFF));
    }

    public boolean less(int a, int b) {
	return (a - Integer.MIN_VALUE) < (b - Integer.MIN_VALUE);
    }
}
