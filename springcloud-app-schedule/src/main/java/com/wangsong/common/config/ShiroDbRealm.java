package com.wangsong.common.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wangsong.system.api.SystemClient;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.wangsong.system.model.Resources;
import com.wangsong.system.model.User;

public class ShiroDbRealm extends AuthorizingRealm {
	
	@Autowired
    private SystemClient client;
	

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = client.getUser(new User(null,token.getUsername(),null));
		// 认证缓存信息
		return new SimpleAuthenticationInfo(user.getId(), user.getPassword().toCharArray(), getName());
	}

	/**
	 * 
	 * Shiro权限认证
	 * 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String shiroUser =(String) principals.getPrimaryPrincipal();
		List<Resources> roleList = client.getResources(new Resources(shiroUser,null,null,null,"2",null));
		Set<String> urlSet = new HashSet<String>();
		for (Resources roleId : roleList) {
			urlSet.add(roleId.getUrl());
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(urlSet);
		return info;
	}

}
