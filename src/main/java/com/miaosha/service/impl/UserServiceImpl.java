package com.miaosha.service.impl;

import com.miaosha.dao.UserDOMapper;
import com.miaosha.dao.UserPwdDOMapper;
import com.miaosha.dataobject.UserDO;
import com.miaosha.dataobject.UserPwdDO;
import com.miaosha.service.Model.UserModel;
import com.miaosha.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yaoheng
 * @date 2020/10/11 19:41
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private UserPwdDOMapper userPwdDOMapper;

    @Override
    public UserModel getById(Integer id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        //通过用户id获取对应的用户加密信息
        if (userDO == null) {
            return null;
        }
        UserPwdDO userPwdDO = userPwdDOMapper.selectByUserId(userDO.getId());
        return convertFromDataObject(userDO, userPwdDO);
    }

    public UserModel convertFromDataObject(UserDO userDO, UserPwdDO userPwdDO) {
        if (userDO == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);
        if (userPwdDO.getEncrptPassword() != null) {
            userModel.setEncrptPassword(userPwdDO.getEncrptPassword());
        }
        return userModel;
    }
}
