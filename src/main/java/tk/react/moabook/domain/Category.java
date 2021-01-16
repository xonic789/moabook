package tk.react.moabook.domain;


import lombok.Getter;
import tk.react.moabook.domain.enums.Kind;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Kind kind;

    private String main_name;
    private String sub_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "category")
    private List<Income> incomes = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<Expenditure> expenditures = new ArrayList<>();




}
