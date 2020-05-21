package com.leilei.client.feign;

import com.leilei.client.dao.CommentMapper;
import com.leilei.common.ResultMap;
import com.leilei.entity.Comment;
import com.leilei.entity.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentMapper commentMapper;
    @Override
    public List<Comment> getCommentListByMid(Integer mid) {
        return commentMapper.getCommentListByMid(mid);
    }

    @Override
    public ResultMap<List<CommentVo>> getCommentListUi(String page, String limit) {
        return null;
    }

    @Override
    public List<CommentVo> findCommentlist(Integer rows) {
        return commentMapper.findCommentlist(rows);
    }

    @Override
    public int count() {
        return commentMapper.count();
    }
}
