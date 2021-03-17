package icu.zhouym.blog.service.impl;

import icu.zhouym.blog.dao.UserRepository;
import icu.zhouym.blog.po.User;
import icu.zhouym.blog.service.UserService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: 周余民
 * @Date: Created in 17:07 2021/3/14
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserRepository userRepository;
    @Override
    public boolean checkUser(User user) {
        User res = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return res != null;
    }
}
