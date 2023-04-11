package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.web.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/***
 * Request와 Response용 Dto는 View를 위한 클래스이기 때문에 자주 변경할 필요가 있다.
 * 그렇기 때문에 View Layer와 DB Layer의 역할 분리를 철저하기 하는 것이 좋다.
 * 즉, Entity 클래스와 Controller에서 쓸 Dto는 분리해서 사용해야한다.
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
