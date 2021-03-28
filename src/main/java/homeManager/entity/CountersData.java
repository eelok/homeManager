package homeManager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="counters")
public class CountersData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cold_water", nullable = false)
    private int cold;

    @Column(name="hot_water", nullable = false)
    private int hot;

    @Column(name="electricity", nullable = false)
    private int electricity;

}
