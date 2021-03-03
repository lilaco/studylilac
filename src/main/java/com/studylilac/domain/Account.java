package com.studylilac.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") // EqaualsAndHashCode에서 id만 사용하는 이유?
/*
연과관계가 복잡해질때,
EqualsAndHashCode 에서 서로 다른 연과관계를 계속해서 순환참조 하느라 무한 루프가 발생하고
결국에는 Stack over flow 가 발생할 수 있다. 때문에 id만 사용한다.
 */
@Builder @AllArgsConstructor @NoArgsConstructor
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    private String password;

    private boolean emailVerified;

    private String emailCheckToken;

    private LocalDateTime joinedAt;

    private String bio;

    private String url;

    private String occupation;

    private String location;

    @Lob @Basic(fetch = FetchType.EAGER)
    private String profileImage;
    //기본적으로 String 은 DB 에서 varchar(255)로 mapping 됨.
    //profileImage 의 경우 데이터의 크기가 초과할 수 있기 때문에 위와 같이 정의한다.
    //Lob 은 Text type 의 mapping 이 된다. 그리고 FetchType 을 명시.

    private boolean studyCreatedByEmail;

    private boolean studyCreatedByWeb;

    private boolean studyEnrollmentResultByEmail;

    private boolean studyEnrollmentResultByWeb;

    private boolean studyUpdatedByEmail;

    private boolean studyUpdatedByWeb;
    //studyCreatedByEmail ~ studyUpdatedByWeb 은 스터디 생성, 참가결과, 갱신 이벤트가 발생할 때마다
    // Web 이나 Email 에서 알림을 받을 것인지에 관한 데이터터
}
