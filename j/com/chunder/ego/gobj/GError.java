package com.chunder.ego.gobj;

public class GError extends Exception {
    static final long serialVersionUID = 90125;
    public String _reason = "GOK";

    GError(String reason) {
	super();
	_reason = reason;
    }
}
