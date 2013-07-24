package com.chunder.ego.gobj;

public final class complex128 extends GObj {
    public static String _name = "complex128";
    public double _r;
    public double _i;

    complex128() {
	super();
	_r = 0.0;
	_i = 0.0;
    }

    complex128(double r, double i) {
	super();
	_r = r;
	_i = i;
    }

    public void assign(complex128 src) {
	_r = src._r;
	_i = src._i;
     }
}
