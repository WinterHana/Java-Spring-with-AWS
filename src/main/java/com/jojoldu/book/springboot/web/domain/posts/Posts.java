package com.jojoldu.book.springboot.web.domain.posts;

import com.jojoldu.book.springboot.web.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/***
 * @@Entity : JPA의 어노테이션, 테이블과 링크될 클래스. 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 매칭
 * ex) SalesManager.java -> sales_manager table
 * ※ Entity 클래스에는 Setter 메서드를 만들지 않는다. 해당 필드의 변경이 필요하다면, 명확히 그 목적과 의도를 나타낼 수 있어야 한다.
 * @Post 클래스 : 실제 db의 테이블과 매칭될 클래스로, 이 클래스의 수정을 통해 db 데이터에 작업한다.
 * @@Getter : 롬복의 어노테이션, 클래스 내 모든 필드이 getter 메소드를 자동 생성
 * @@NoArgsConstructor :기본 생성자 자동 생성 (= public Posts() {})
 * @@Builder : 빌더 패턴 클래스 생성. 생성자 상단에 선언 시, 생성자에 포함된 필드만 빌더에 포함한다.
 *
 * @빌더패턴 : 생성 패턴 중 하나. 복잡한 객체를 생성하는 방법을 정의하는 클래스와 표현하는 방법을 정의하는 클래스를 별도로 분리하여,
 * 서로 다른 표현이라도 이를 생성할 수 있는 동일한 절차를 제공하는 패턴.
 * 별도의 Builder 클래스를 만들어 필수 값에 대해서는 생성자를 통해,
 * 선택적인 값들에 대해서는 메소드를 통해 step-by-step으로 값을 입력받은 후에
 * build() 메소드를 통해 최종적으로 하나의 인스턴스를 리턴하는 방식
 *
 * @@BaseTimeEntity : 생성, 수정 시간을 업데이트함.
 */
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id     // id : pk 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /***
     * Long 타입의 Auto_increment를 선언한 이유
     * - MySQL 기준으로 bigint 타입이 된다.
     * - 조건 변경시 pk를 전부 수정해야하는 등 불편한 요소가 존재함
     */
    @Column(length = 500, nullable = false)     // column : 필드는 전부 자동으로 column이 되지만, 기타 설정을 위해 지정한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
