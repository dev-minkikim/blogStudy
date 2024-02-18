package me.kimminki.springbootdeveloper.dto;

import lombok.Getter;
import me.kimminki.springbootdeveloper.domain.Article;

@Getter
public class ArticleResponse {
    private final String title;
    private final String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
