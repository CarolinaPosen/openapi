package by.mikhalevich.architecture.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "aircraft")
@Schema(description = "Aircraft entity")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY,
            description = "GenerationType.IDENTITY")
    private Long id;
    private String model;
    @Min(1000)
    private Integer range;

    @JsonIgnore
    @OneToMany(mappedBy = "aircraft")
    private Set<Flight> flights = new LinkedHashSet<>();

}
