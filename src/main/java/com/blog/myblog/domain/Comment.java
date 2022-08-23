package com.blog.myblog.domain;

import com.blog.myblog.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Comment extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long memoId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Comment(CommentRequestDto commentRequestDto){
        this.memoId = commentRequestDto.getMemoId();
        this.username = commentRequestDto.getUsername();
        this.contents = commentRequestDto.getContents();
    }

    public void update(CommentRequestDto commentRequestDto){
        this.memoId = commentRequestDto.getMemoId();
        this.username = commentRequestDto.getUsername();
        this.contents = commentRequestDto.getContents();
    }
}
