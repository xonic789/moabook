package tk.react.moabook.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Expenditure {

    public Expenditure(Long id, String mainCategory, String subCategory, LocalDateTime day, String memo, int price, Account account) {
        this.id = id;
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
        this.day = day;
        this.memo = memo;
        this.price = price;
        this.account = account;
    }

    @Id @GeneratedValue
    @Column(name = "expenditure_id")
    private Long id;

    private String mainCategory;
    private String subCategory;
    private LocalDateTime day;
    private String memo;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}
