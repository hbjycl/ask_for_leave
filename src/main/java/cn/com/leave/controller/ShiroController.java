package cn.com.leave.controller;

import javax.servlet.http.HttpServletRequest;

import cn.com.leave.entity.User;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShiroController {
	private static final Logger logger = LoggerFactory.getLogger(ShiroController.class);

	@RequestMapping(value = "/getUserName", method = RequestMethod.GET)
	public static @ResponseBody JSONObject getUserName(HttpServletRequest request) {
		logger.info("getUserName");
		Subject subject = SecurityUtils.getSubject();
		Object object = subject.getPrincipal();
		User user = (User) object;
		return JSONObject.fromObject(user);
	}

}
