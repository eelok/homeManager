package homeManager.entity;

import javax.persistence.*;

@Entity
@Table(name="counters")
public class CounterData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cold_water", nullable = false)
    private int cold;

    @Column(name="hot_water", nullable = false)
    private int hot;

    @Column(name="electricity", nullable = false)
    private int electricity;


    public CounterData() {
    }
}
