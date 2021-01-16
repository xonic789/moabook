package tk.react.moabook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Saving {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saving_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saving_list_id")
    private SavingList savingList;

    private LocalDateTime day;

    private int price;

    public Saving(SavingList savingList, LocalDateTime day, int price) {
        this.savingList = savingList;
        this.day = day;
        this.price = price;
    }
}
