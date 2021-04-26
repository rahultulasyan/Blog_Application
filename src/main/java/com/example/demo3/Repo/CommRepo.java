package com.example.demo3.Repo;

import com.example.demo3.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommRepo extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM COMMENT WHERE USER_USER_id=?1", nativeQuery = true)
    public List<Comment> getCommentsUser(Long userId);

    @Query(value = "SELECT * FROM COMMENT WHERE BLOG_BLOG_id=?1", nativeQuery = true)
    public List<Comment> getCommentsBlog(Long blogId);
}
