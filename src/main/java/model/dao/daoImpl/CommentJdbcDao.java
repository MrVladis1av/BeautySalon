package model.dao.daoImpl;

import dto.Comment;
import model.dao.daoInterfaces.Dao;

import java.util.List;

public class CommentJdbcDao implements Dao<Comment, Long> {
    @Override
    public Long add(Comment comment) {
        return null;
    }

    @Override
    public Comment find(Long id) {
        return null;
    }

    @Override
    public void update(Comment comment) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Comment> findAll() {
        return null;
    }
}
