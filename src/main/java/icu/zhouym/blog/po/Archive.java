package icu.zhouym.blog.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: 周余民
 * @Date: Created in 12:28 2021/3/14
 * @description: blog实体对象
 */
@Entity
@Data
public class Archive {
    @Id
    private String id;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;
    @Column
    private String title;
    @Column
    private String category;
    @Column
    private String content;
}
