package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/***
 * @RequredArgsConstructor : final이 선언된 모든 필드를 인자값으로 하는 생성자를 만든다.
 * -> 롬북에서 지원하는 어노테이션 중 하나
 * @RestController : @Controller에 @ResponseBody가 추가된 것. Json 형태로 객체 데이터를 반환하는 것이 주 목적이다.
 * @PathVariable : URL의 파라미터로 지정
 */
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }
    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)
    {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
