package model.dao.daoImpl;

import dto.Comment;
import model.dao.daoImpl.template.JdbcHelper;
import model.dao.daoInterfaces.CommentDao;
import model.dao.daoInterfaces.Dao;
import model.dao.jdbc.ConnectionManager;
import model.dao.mappers.CommentMapper;

import java.util.List;

public class CommentJdbcDao implements CommentDao {
    ConnectionManager cm;
    JdbcHelper helper;

    public CommentJdbcDao() {
        this.cm = ConnectionManager.getInstance();
        helper = new JdbcHelper(cm);
    }

    @Override
    public Long add(Comment comment) {
        return helper.insert("INSERT INTO comment " +
                        "(comment_text," +
                        "user_id," +
                        "master_id)" +
                        "VALUES(?,?,?)",
                comment.getComment(),
                comment.getUser().getUserId(),
                comment.getMaster().getMasterId());
    }

    @Override
    public Comment find(Long id) {
        Comment comment = helper.findObject("SELECT * FROM comment " +
                "WHERE idcomment=?", CommentMapper::map, id);
        return comment;
    }

    @Override
    public void update(Comment comment) {
        helper.update("UPDATE comment " +
                        "SET " +
                        "comment_text=?, " +
                        "user_id=?, " +
                        "master_id=? " +
                        "WHERE idcomment=?",
                comment.getComment(),
                comment.getUser().getUserId(),
                comment.getMaster().getMasterId());
    }

    @Override
    public void delete(Long id) {
        helper.remove("DELETE FROM comment " +
                "WHERE idcomment=?", id);
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = helper.findAll("SELECT * FROM comment", CommentMapper::map);
        return comments;
    }
}
