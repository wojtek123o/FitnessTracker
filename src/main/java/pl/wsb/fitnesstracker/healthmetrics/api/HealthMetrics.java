package pl.wsb.fitnesstracker.healthmetrics.api;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "health_metrics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class HealthMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "height", nullable = false)
    private Double height;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "heart_rate", nullable = false)
    private Integer heartRate;

    public HealthMetrics(@Nullable Long id, Long userId, LocalDate date, Double height, Double weight, Integer heartRate) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.height = height;
        this.weight = weight;
        this.heartRate = heartRate;
    }
}
