package tk.react.moabook.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String email;
    private String password;

    private String kakao;
    private String naver;
    private String google;

    private String nickName;
    private LocalDate birthday;
    private String gender;
    private String image;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    public Member(String name, String email, String password, String kakao, String naver, String google, String nickName, LocalDate birthday, String gender, String image) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.kakao = kakao;
        this.naver = naver;
        this.google = google;
        this.nickName = nickName;
        this.birthday = birthday;
        this.gender = gender;
        this.image = image;
    }

    public void editProfile(Member member){
        if(member.getNickName()!=null) this.nickName = member.getNickName();
        if(member.getPassword()!=null) this.password = member.getPassword();
    }
}
