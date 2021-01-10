package tk.react.moabook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "saving_list")
@Getter
public class SavingList {

    public SavingList(Long id, String title, String subTitle, LocalDateTime startday, Byte deleted, Account account, List<Saving> savings) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.startday = startday;
        this.deleted = deleted;
        this.account = account;
        this.savings = savings;
    }

    @Id @GeneratedValue
    @Column(name = "saving_list_id")
    private Long id;

    private String title;
    private String subTitle;

    private LocalDateTime startday;
    private Byte deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Saving> savings = new ArrayList<>();
}
