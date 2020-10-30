package com.miaosha.service;

import com.miaosha.dataobject.UserDO;
import com.miaosha.service.Model.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yaoheng
 * @date 2020/10/11 19:40
 * @blame Android Team
 */
public interface UserService {
    UserModel getById(@RequestParam("id") Integer id);
}
