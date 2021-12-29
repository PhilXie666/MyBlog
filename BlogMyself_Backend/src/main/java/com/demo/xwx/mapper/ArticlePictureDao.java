package com.demo.xwx.mapper;

import com.demo.xwx.entity.ArticlePicture;
import com.demo.xwx.entity.ArticlePictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticlePictureDao {

    // 查询一篇文章的所有图片
    List<ArticlePicture> selectAnArtPictures(String id);

    long countByExample(ArticlePictureExample example);

    int deleteByExample(ArticlePictureExample example);

    int deleteByPrimaryKey(String id);

    int insert(ArticlePicture record);

    int insertSelective(ArticlePicture record);

    List<ArticlePicture> selectByExample(ArticlePictureExample example);

    ArticlePicture selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ArticlePicture record, @Param("example") ArticlePictureExample example);

    int updateByExample(@Param("record") ArticlePicture record, @Param("example") ArticlePictureExample example);

    int updateByPrimaryKeySelective(ArticlePicture record);

    int updateByPrimaryKey(ArticlePicture record);
}
