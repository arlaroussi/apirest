package ldv.apirest.model

import jakarta.persistence.*
import org.hibernate.query.results.Builders.fetch


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="alimentbox")
class AlimentBox(
    @Column(name = "quantite", nullable = false)
    var quantite: Int,

    @ManyToOne()
    val box: Box,

    @ManyToOne()
    val aliment: Aliment
)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}