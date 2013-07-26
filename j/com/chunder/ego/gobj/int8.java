package com.chunder.ego.gobj;

public final class int8 extends GObj {
    final static String _name = "int8";
    public byte _v;

    int8() {
	super();
	_v = 0;
    }

    int8(byte v) {
	super();
	_v = v;
    }

    public byte div(byte a, byte b) {
	boolean n;
	if (a < 0) {
	    a = (byte) -a;
	    n = true;
	} else {
	    n = false;
	}
	if (b < 0) {
	    b = (byte) -b;
	    n = !n;
	}
	if (n) {
		return (byte) -uint8.div(a, b);
	} else {
		return (byte) uint8.div(a, b);
	}
    }

    public byte rem(byte a, byte b) {
	boolean n;
	if (a < 0) {
	    a = (byte) -a;
	    n = true;
	} else {
	    n = false;
	}
	if (b < 0) {
	    b = (byte) -b;
	}
	if (n) {
		return (byte) -uint8.rem(a, b);
	} else {
		return (byte) uint8.rem(a, b);
	}
    }
}
