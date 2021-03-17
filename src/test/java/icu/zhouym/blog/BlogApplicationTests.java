package icu.zhouym.blog;

import icu.zhouym.blog.service.ArchiveService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {

    @Resource
    ArchiveService archiveService;
    @Test
    void contextLoads() {
        ArrayList<Object> categories = archiveService.getCategories();
        for(Object v: categories){
            System.out.println(v);
        }
    }

}
