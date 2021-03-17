package icu.zhouym.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * @Author: 周余民
 * @Date: Created in 23:48 2021/3/16
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchiveDto {
    private String id;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;
}
