package com.leilei.client.dao;
import com.leilei.entity.Comment;
import com.leilei.entity.CommentVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Comment record);
    Comment selectByPrimaryKey(Integer id);
    List<Comment> selectAll();
    int updateByPrimaryKey(Comment record);
    List<Comment> getCommentListByMid(Integer mid);

    List<CommentVo> findCommentlist(Integer rows);

    int count();
}