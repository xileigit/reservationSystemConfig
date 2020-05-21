package com.leilei.client.feign;

import com.leilei.common.ResultMap;
import com.leilei.entity.Comment;
import com.leilei.entity.CommentVo;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentListByMid(Integer mid);

    ResultMap<List<CommentVo>> getCommentListUi(String page, String limit);

    List<CommentVo> findCommentlist(Integer rows);

    int count();
}
