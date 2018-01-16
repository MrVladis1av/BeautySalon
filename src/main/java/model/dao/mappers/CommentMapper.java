package model.dao.mappers;

import dto.Comment;
import dto.Image;
import dto.Master;
import dto.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper {
    private static final Logger LOGGER = LogManager.getLogger(CommentMapper.class);

    public static Comment map(ResultSet resultSet) {
        Comment comment = new Comment();
        try {
            comment.setCommentId(resultSet.getLong("idcomment"));
            Master master = new Master();
            master.setMasterId(resultSet.getLong("master_id"));
            comment.setMaster(master);
            User user = new User();
            user.setUserId(resultSet.getLong("user_id"));
            comment.setUser(user);
            comment.setComment(resultSet.getString("comment_text"));

        } catch (SQLException e) {
            LOGGER.error("can't map object", e);
        }
        return comment;
    }
}
