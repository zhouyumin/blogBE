package icu.zhouym.blog.po;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: 周余民
 * @Date: Created in 16:42 2021/3/14
 * @description:
 */
@Entity
@Data
public class User {
    @Id
    private String id;
    @Column
    private String username;
    @Column
    private String password;
}
