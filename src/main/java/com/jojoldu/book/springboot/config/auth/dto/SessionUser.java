package com.jojoldu.book.springboot.config.auth.dto;

import com.jojoldu.book.springboot.web.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/***
 * 인증된 사용자 정보만 필요하기 때문에, name, email, picture만 필드로 선언한다.
 * 왜 User 클래스를 사용하면 안됨?
 * - User 클래스가 엔티티이기 떼문. 엔티티 클래스에는 언제 다른 엔티티와 관계가 형성될 지 모른다.
 * - 따라서 직렬화 가능을 가진 섹션 Dto를 하나 추가하는게 더 유지보수 측면에서 더 낫다고 본다.
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
