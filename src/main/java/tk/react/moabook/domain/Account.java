package tk.react.moabook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import tk.react.moabook.domain.enums.DeletedStatus;
import tk.react.moabook.domain.enums.Kind;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Account {



    public Account(LocalDateTime createDay, String name, Kind kinds, Members members, DeletedStatus deleted, Member member, List<Income> incomes, List<Expenditure> expenditures, List<SavingList> savingList, List<Category> categories) {
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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    private LocalDateTime createDay;


    private String name;

    @Enumerated(EnumType.STRING)
    private Kind kinds;

    @Embedded
    private Members members;

    @Enumerated(EnumType.STRING)
    private DeletedStatus deleted;

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
