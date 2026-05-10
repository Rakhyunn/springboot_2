package com.back.article;

import com.back.member.Member;
import com.back.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article extends BaseEntity {
    @Column(length = 200, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @ManyToOne
    private Member author;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
