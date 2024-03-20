package me.kimminki.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.kimminki.springbootdeveloper.domain.Article;
import me.kimminki.springbootdeveloper.dto.AddArticleRequest;
import me.kimminki.springbootdeveloper.dto.UpdateArticleRequest;
import me.kimminki.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    // findById() 메서드는 JPA에서 제공하는 findById() 메서드를 사용해 ID를 받아 엔티티를 조회하고 없으면 IllegalArgumentException 예외를 발생
    public Article findById(Long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 이 메서드는 블로그 그르이 ID를 받은뒤 JPA에서 제공하는 deleteById() 메서드를 이용해 데이터베이스에서 데이터를 삭제
    public void delete(long id){
        blogRepository.deleteById(id);
    }


    //리포지토리를 사용해 글을 수정하는 update() 메서드 작성
    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
