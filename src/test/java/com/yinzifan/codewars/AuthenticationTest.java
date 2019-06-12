package com.yinzifan.codewars;

import static org.junit.Assert.*;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

import com.yinzifan.realm.CustomRealm;

public class AuthenticationTest {
	
	SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
	
	@Before
	public void addUser() {
		simpleAccountRealm.addAccount("username", "password");
	}
	

	@Test
	public void testLogin() throws Exception {
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(simpleAccountRealm);
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("username", "password");
		subject.login(token);
		System.out.println(subject.isAuthenticated());
	}
	
	@Test
	public void testCustomRealm() throws Exception {
		CustomRealm realm = new CustomRealm();
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(realm);
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();
		subject.login(new UsernamePasswordToken("username", "passwor1d"));
		System.out.println(subject.isAuthenticated());
	}
}
