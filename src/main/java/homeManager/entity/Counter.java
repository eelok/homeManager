package homeManager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import homeManager.constant.TypeCounter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "type", "value", "timestamp"})
@Table(name="counter")
    public class Counter {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("type")
    @Column(name = "type", nullable = false)
    private TypeCounter typeCounter;

    @NotNull
    @JsonProperty("value")
    @Column(name = "value")
    private double value;

    @JsonProperty("timestamp")
    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;

}
