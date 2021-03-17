package icu.zhouym.blog.controller;

import icu.zhouym.blog.dto.ArchiveBody;
import icu.zhouym.blog.po.Archive;
import icu.zhouym.blog.po.User;
import icu.zhouym.blog.service.ArchiveService;
import icu.zhouym.blog.service.UserService;
import icu.zhouym.blog.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: 周余民
 * @Date: Created in 12:39 2021/3/14
 * @description:
 */
@RestController
public class ArchiveController {
    @Resource
    ArchiveService archiveService;
    @Resource
    UserService userService;

    @GetMapping("/list")
    public Result getList(@RequestParam("page")int page,
                          @RequestParam("size") int size,
                          @RequestParam("category") String category,
                          @RequestParam("keyword")String keyword){
        if(category.equals("") && keyword.equals("")){
            return Result.succ(archiveService.getList(page-1,size));
        }else if(!category.equals("")) {
            return Result.succ(archiveService.getListByCategory(page-1,size,category));
        }else {
            return Result.succ(archiveService.searchAll(page-1,size, keyword));
        }

    }
    @GetMapping("/getArchive")
    public Result getArchive(@RequestParam("id")String id){
        return Result.succ(archiveService.getArchive(id));
    }
    @PostMapping("/addArchive")
    public Result addArchive(@RequestBody ArchiveBody body){
        Archive archive = new Archive();
        BeanUtils.copyProperties(body, archive);
        User user = new User();
        BeanUtils.copyProperties(body, user);
        if(!userService.checkUser(user)){
            return Result.fail("用户名或密码错误");
        }
        if(archive.getId().equals("")|| archive.getId()==null){
            //生成uuid
            String id = UUID.randomUUID().toString().replace("-", "");
            archive.setId(id);
        }


        if(archive.getDate()==null){
            archive.setDate(new Date());
        }

        archiveService.addArchive(archive);
        return Result.succ("提交成功",archive.getId());
    }
    @DeleteMapping("/deleteArchive")
    public Result deleteArchive(@RequestBody ArchiveBody body){
        User user = new User();
        BeanUtils.copyProperties(body, user);
        if(!userService.checkUser(user)){
            return Result.fail("用户名或密码错误");
        }
        Archive archive = archiveService.getArchive(body.getId());
        if(archive ==null){
            return  Result.fail("删除异常");
        }
        archiveService.deleteArchive(archive.getId());
        return Result.succ("删除成功");
    }

    @GetMapping("/getCategories")
    public Result getCategories(){
        return Result.succ(archiveService.getCategories());
    }

    @GetMapping("/count")
    public Result getCount(){
        return Result.succ(archiveService.getCount());
    }

    @GetMapping("/archiveList")
    public Result getArchiveList(@RequestParam("page")int page,
                                 @RequestParam("size") int size){
        return Result.succ(archiveService.getArchiveList(page-1, size));
    }
}
