package tk.react.moabook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Account {

    public Account(LocalDateTime createDay, String name, String kinds, String members, Byte deleted, Member member, List<Income> incomes, List<Expenditure> expenditures, List<SavingList> savingList, List<Category> categories) {
        this.createDay = createDay;
        this.name = name;
        this.kinds = kinds;
        this.members = members;
        this.deleted = deleted;
        this.member = member;
        this.incomes = incomes;
        this.expenditures = expenditures;
        this.savingList = savingList;
        this.categories = categories;
    }

    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    private LocalDateTime createDay;


    private String name;
    private String kinds;
    private String members;
    private Byte deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Income> incomes = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Expenditure> expenditures = new ArrayList<>();

//    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
//    private List<Saving> savings = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<SavingList> savingList = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();

}
