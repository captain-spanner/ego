package com.chunder.ego.gobj;

public final class uint64 extends GObj {
    final static String _name = "uint64";
    public long _v;

    uint64() {
	super();
	_v = 0;
    }

    uint64(long v) {
	super();
	_v = v;
    }

    public static long shl(long a, long b) {
	if (b >= 0 && b < 64) {
	    return a << b;
	}
	return 0;
    }

    public static long shr(long a, long b) {
	if (b >= 0 && b < 64) {
	    return (a >> b) & ~(1L << (64 - b));
	}
	return 0;
    }

    private static long shr1(long l) {
	return (l >> 1) & ~(1L << 63);
    }

    // ((n u>> 1) / d) * 2 within +1
    public static long div(long n, long d) {
	if (d < 0) {
	    if (less(n, d)) {
		return 1;
	    } else {
		return 0;
	    }
	}
	long q = (shr1(n) / d) * 2;
	long r = n - q * d;
	if (!less(r, d)) {
		return q + 1;
	}
	return q;
    }

    // same method as div
    public static long rem(long n, long d) {
	if (d < 0) {
	    if (less(n, d)) {
		return n;
	    } else {
		return n - d;
	    }
	}
	long q = (shr1(n) / d) * 2;
	long r = n - q * d;
	if (!less(r, d)) {
		return r - d;
	}
	return r;
    }

    public static boolean less(long a, long b) {
	return (a - Long.MIN_VALUE) < (b - Long.MIN_VALUE);
    }
}
