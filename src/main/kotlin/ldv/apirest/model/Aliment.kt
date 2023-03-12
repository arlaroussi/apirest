package ldv.apirest.model

import jakarta.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="aliment")
class Aliment(
    @Column(name = "nom", nullable = false)
    var nom: String
)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0
}