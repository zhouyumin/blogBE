package icu.zhouym.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: 周余民
 * @Date: Created in 16:21 2021/3/14
 * @description:
 */
@Data
public class ArchiveBody {
    private String id;
    private String content;
    private String title;
    private String category;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;
    private String username;
    private String password;
}
