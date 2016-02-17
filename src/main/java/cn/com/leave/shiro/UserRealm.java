package cn.com.leave.shiro;

import java.util.Date;

import javax.annotation.Resource;

import cn.com.leave.dao.UserDao;
import cn.com.leave.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    private boolean isDebug = true;

    @Resource
    private UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	//	//加载用户权限
	User user = (User) principals.fromRealm(getName()).iterator().next();
		User dbUser = userDao.getByUsername(user.getUsername());
	if (dbUser != null) {
	    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	    isDebug = false;
	    if (isDebug) {
		info.addStringPermission("*");
	    }
	    return info;
	}
	return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
	//身份验证
	UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
	User user = userDao.login(token.getUsername(), new String(token.getPassword()));
	if (user != null) {
	    logger.info("TokenUser:{}", user.getUsername());
	    return new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), getName());
	} 
	else {
	    throw new AuthenticationException();
	}
    }

}
