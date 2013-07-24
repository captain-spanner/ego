package com.chunder.ego.gobj;

public final class float64 extends GObj {
    final static String _name = "float64";
    public double _v;

    float64() {
	super();
	_v = 0;
    }

    float64(double v) {
	super();
	_v = v;
    }
}
