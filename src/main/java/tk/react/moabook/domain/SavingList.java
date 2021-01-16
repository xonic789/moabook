package tk.react.moabook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import tk.react.moabook.domain.enums.DeletedStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "saving_list")
@NoArgsConstructor
@Getter
public class SavingList {

    public SavingList(String title, String subTitle, LocalDateTime startDay, DeletedStatus deleted, Account account, List<Saving> savings) {
        this.title = title;
        this.subTitle = subTitle;
        this.startDay = startDay;
        this.deleted = deleted;
        this.account = account;
        this.savings = savings;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saving_list_id")
    private Long id;

    private String title;
    private String subTitle;

    private LocalDateTime startDay;

    @Enumerated(EnumType.STRING)
    private DeletedStatus deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "savingList",cascade = CascadeType.ALL)
    private List<Saving> savings = new ArrayList<>();
}
