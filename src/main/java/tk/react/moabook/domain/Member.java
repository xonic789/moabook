package tk.react.moabook.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String email;

    private String kakao;
    private String naver;
    private String google;

    private String nickName;
    private LocalDateTime birthday;
    private String gender;
    private String image;

    @OneToMany(mappedBy = "member")
    private List<Account> accounts = new ArrayList<>();

    public Member(Long id, String name, String email, String kakao, String naver, String google, String nickName, LocalDateTime birthday, String gender, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.kakao = kakao;
        this.naver = naver;
        this.google = google;
        this.nickName = nickName;
        this.birthday = birthday;
        this.gender = gender;
        this.image = image;
    }
}
