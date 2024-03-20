package me.kimminki.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
// 블로그 글 수정 요청을 받을 DTO 작성
public class UpdateArticleRequest {
    private String title;
    private String content;
}
