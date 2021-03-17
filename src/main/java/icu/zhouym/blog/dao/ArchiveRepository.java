package icu.zhouym.blog.dao;

import icu.zhouym.blog.dto.ArchiveDto;
import icu.zhouym.blog.po.Archive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 周余民
 * @Date: Created in 12:43 2021/3/14
 * @description:
 */
public interface ArchiveRepository extends JpaRepository<Archive, String> {
    @Query("select category, count(category) from Archive group by category order by date desc")
    public ArrayList<Object> getCategories();
    public Page<Archive> findAllByCategoryEquals(String category, Pageable pageable);
    @Query("select count(distinct category) from Archive")
    public Long countCategory();
    @Query("select new icu.zhouym.blog.dto.ArchiveDto(p.id, p.title, p.date) from Archive p order by p" +
            ".date desc")
    public Page<ArchiveDto> getArchiveList(Pageable pageable);

    public List<Archive> findAllByTitleLikeOrAndCategoryLikeOrContentLike(String keyWord1,String keyWord2,
                                                                           String keyword3);
}
