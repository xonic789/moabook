package tk.react.moabook.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tk.react.moabook.domain.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String email;
    private String password;

    @Embedded
    private LoginAPI api;

    private String nickName;
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String image;

    @OneToMany(mappedBy = "member")
    private List<Account> accounts = new ArrayList<>();

    public Member(String name, String email, String password, LoginAPI api, String nickName, LocalDate birthday, Gender gender, String image) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.api = api;
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
