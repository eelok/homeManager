package homeManager.entity;

import javax.persistence.*;

@Entity
@Table(name="Counters")
public class CounterData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="cold_water", nullable = false)
    private double cold;

    @Column(name="hot_water", nullable = false)
    private double hot;

    @Column(name="electricity", nullable = false)
    private double electricity;


    public CounterData() {
    }
}
