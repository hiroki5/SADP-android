package com.parse.starter.util;

public class LoginUtil {
	private static LoginUtil loginUtil = null;
	
	public static LoginUtil getLoginUtil() {
		if(loginUtil == null) {
			loginUtil = new LoginUtil();
		}
		return loginUtil;
	}

	private boolean isLoggedin = false;
	
	private LoginUtil() {}
	
	public boolean isLoggedIn() {
		return this.isLoggedin;
	}
	
	public boolean login(String loginCode) {
		// loginCodeが正しいか確かめる
		boolean isLoginCodeValid = true;
		if(isLoginCodeValid) {
			this.isLoggedin = true;
			return true;
		} else {
			return false;
		}
	}
}
