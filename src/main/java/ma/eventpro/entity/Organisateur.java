package ma.eventpro.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "organisateurs")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Organisateur extends User {
}
