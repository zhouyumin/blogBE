package icu.zhouym.blog.service.impl;

import icu.zhouym.blog.dao.ArchiveRepository;
import icu.zhouym.blog.dto.ArchiveDto;
import icu.zhouym.blog.po.Archive;
import icu.zhouym.blog.service.ArchiveService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: 周余民
 * @Date: Created in 12:44 2021/3/14
 * @description:
 */
@Service
public class ArchiveServiceImpl implements ArchiveService {
    @Resource
    ArchiveRepository archiveRepository;

    @Override
    public Object getList(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "date");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Archive> all = archiveRepository.findAll(pageable);
        List<Object> res = new ArrayList<>();
        res.add(all.getTotalElements());
        res.add(all.getContent());
        return res;
    }

    @Override
    public void addArchive(Archive archive) {
        archiveRepository.save(archive);
    }

    @Override
    public Archive getArchive(String id) {
        Optional<Archive> one = archiveRepository.findById(id);
        return one.orElse(null);
    }

    @Override
    public void deleteArchive(String id) {
        archiveRepository.deleteById(id);
    }

    @Override
    public ArrayList<Object> getCategories() {
        return archiveRepository.getCategories();
    }

    @Override
    public Object getListByCategory(int page, int size, String category) {
        Sort sort = Sort.by(Sort.Direction.DESC, "date");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Archive> all = archiveRepository.findAllByCategoryEquals(category, pageable);
        List<Object> res = new ArrayList<>();
        res.add(all.getTotalElements());
        res.add(all.getContent());
        return res;
    }

    @Override
    public ArrayList<Long> getCount() {
        ArrayList<Long> list = new ArrayList<>();
        long archive = archiveRepository.count();
        long category = archiveRepository.countCategory();
        list.add(archive);
        list.add(category);
        return list;
    }

    @Override
    public List<Object> getArchiveList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ArchiveDto> all = archiveRepository.getArchiveList(pageable);
        List<Object> res = new ArrayList<>();
        res.add(all.getTotalElements());
        res.add(all.getContent());
        return res;
    }

    @Override
    public List<Object> searchAll(int page, int size, String keyword) {
        keyword = "%" + keyword + "%";
        List<Object> res = new ArrayList<>();
        List<Archive> all = archiveRepository.findAllByTitleLikeOrAndCategoryLikeOrContentLike(keyword, keyword, keyword);
        res.add(all.size());
        res.add(all);
        return  res;
    }
}
