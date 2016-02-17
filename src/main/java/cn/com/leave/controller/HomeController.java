package cn.com.leave.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

import cn.com.leave.dao.UserDao;
import cn.com.leave.entity.User;
import cn.com.leave.exception.CauseException;
import cn.com.leave.util.DataUtil;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import cn.com.leave.dao.CauseDao;
import cn.com.leave.dao.DepartmentDao;
import cn.com.leave.entity.Department;
import cn.com.leave.entity.Staff;
import cn.com.leave.service.StaffService;
import cn.com.leave.util.UUIDGenerator;

/**
 * @author cl
 */
@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Resource
    StaffService staffService;
    @Resource
    DepartmentDao departmentDao;
    @Resource
    CauseDao causeDao;
    @Resource
    UserDao userDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        List<Staff> staffs = staffService.getAll(null);
        List<Department> departments = departmentDao.getAll();
        mav.addObject("staffs", staffs);
        mav.addObject("departments", departments);
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/addCause", method = RequestMethod.POST)
    public @ResponseBody  JSONObject addcause(@RequestParam("staffId") String staffId, @RequestParam("context") String context,
                        @RequestParam("departmentId") String departmentId) {
        try {
            causeDao.add(UUIDGenerator.uuid(), new Staff(staffId, null, departmentId), context, new Date());
        } catch (CauseException e) {
            e.printStackTrace();
            return DataUtil.getError("内容错误");
        } catch (DataAccessException e) {
            e.printStackTrace();
            return DataUtil.getError("数据库错误");
        } catch (Exception e) {
            e.printStackTrace();
            return DataUtil.getError("未知错误");
        }
        return DataUtil.getSuccess();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody JSONObject login(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            User user = userDao.login(username, new Md5Hash(password).toHex());
            if(user==null)
            {
                return DataUtil.getError("用户名或密码错误");
            }
        }catch (DataAccessException e)
        {
            e.printStackTrace();
            return DataUtil.getError("数据库错误");
        }catch (Exception e) {
            e.printStackTrace();
            return DataUtil.getError("未知错误");
        }

        return DataUtil.getSuccess();

    }

    @RequestMapping(value="/getNameList",method = RequestMethod.GET)
    public @ResponseBody JSONObject getNameList(@RequestParam("departmentId") String departmentId)
    {
        List<Staff> staffs = staffService.getAll(departmentId);
        return DataUtil.getData(staffs);
    }


}
