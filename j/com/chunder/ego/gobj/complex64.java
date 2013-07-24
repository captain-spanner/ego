package com.chunder.ego.gobj;

public final class complex64 extends GObj {
    public static String _name = "complex64";
    public float _r;
    public float _i;

    complex64() {
	super();
	_r = 0.0f;
	_i = 0.0f;
    }

    complex64(float r, float i) {
	super();
	_r = r;
	_i = i;
    }

    public void assign(complex64 src) {
	_r = src._r;
	_i = src._i;
     }
}
