package com.miaosha.controller;

import com.miaosha.controller.viewObject.UserVo;
import com.miaosha.error.BusinessException;
import com.miaosha.error.EnuBusinessError;
import com.miaosha.response.commonReturnType;
import com.miaosha.service.Model.UserModel;
import com.miaosha.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.sql.CommonDataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author yaoheng
 * @date 2020/10/11 19:37
 */
@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 用户获取ota短信接口
     * @param phone
     * @return
     */
    @RequestMapping("/getota")
    @ResponseBody
    public commonReturnType getota(@RequestParam(name = "phone") String phone){
        //按照一定的规则生成ota验证码
        Random random = new Random();
        int nextInt = random.nextInt(9999);
        nextInt+=1000; //取1000-9999的随机值
        String otaCode=String.valueOf(nextInt);
        //将ota验证码与手机号关联 这里使用session的方式关联
        request.getSession().setAttribute(phone,otaCode);
        System.out.println("phone="+phone + "& otacode="+otaCode);
        return commonReturnType.create(null);

    }

    /**
     * 通过id查询实体
     */
    @RequestMapping("/get")
    @ResponseBody
    public commonReturnType getById(@RequestParam("id") Integer id) throws BusinessException {
        UserModel userModel = userService.getById(id);
        //将核心领域模型转化为ui可使用的viewObject
        if (userModel == null) {
            //userModel.setEncrptPassword("1222");
            throw new BusinessException(EnuBusinessError.USER_NOT_EXIST);
        }
        UserVo userVo = convertFromUserModel(userModel);

        return commonReturnType.create(userVo);
    }

    public UserVo convertFromUserModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userModel, userVo);
        return userVo;
    }

}
