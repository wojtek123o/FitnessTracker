package pl.wsb.fitnesstracker.training.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.wsb.fitnesstracker.training.api.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    @Query(
            value = "SELECT SUM(t.distance) " +
                    "FROM trainings t" +
                    "JOIN users u on t.user_id = u.user_id" +
                    "WHERE user_id = :userId" +
                    "GROUP BY t.user_id"
            ,
            nativeQuery = true
    )
    long sumDistance(@Param("userId") Long id);
}
