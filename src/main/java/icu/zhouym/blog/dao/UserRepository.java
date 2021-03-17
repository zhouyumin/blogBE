package icu.zhouym.blog.dao;

import icu.zhouym.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 周余民
 * @Date: Created in 17:07 2021/3/14
 * @description:
 */
public interface UserRepository extends JpaRepository<User, String> {
    public User findByUsernameAndPassword(String username, String password);
}
