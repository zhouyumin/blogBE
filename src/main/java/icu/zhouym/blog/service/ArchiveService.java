package icu.zhouym.blog.service;

import icu.zhouym.blog.dto.ArchiveDto;
import icu.zhouym.blog.po.Archive;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 周余民
 * @Date: Created in 12:44 2021/3/14
 * @description:
 */
public interface ArchiveService {
    public Object getList(int page, int size);

    public void addArchive(Archive archive);

    public Archive getArchive(String id);

    public void deleteArchive(String id);

    public ArrayList<Object> getCategories();

    public Object getListByCategory(int page, int size, String category);

    public ArrayList<Long> getCount();
    public List<Object> getArchiveList(int page ,int size);
    public List<Object> searchAll(int page, int size, String keyword);
}
