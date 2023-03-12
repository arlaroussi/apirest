package ldv.apirest.model

import jakarta.persistence.*
import ldv.apirest.model.Saveur

@Entity
@Table(name = "box")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class Box(
    @Column(name = "nom", nullable = false)
    var nom: String,

    @Column(name = "pieces", nullable = false)
    var pieces: Int,

    @Column(name = "prix", nullable = false)
    var prix: Double,

    @Column(name = "img", nullable = false)
    var image: String,

    @Id @GeneratedValue
    var id: Long? = null
)

{
    @OneToMany(cascade = [CascadeType.MERGE], mappedBy = "box")
    var alimentBoxes = mutableListOf<AlimentBox>()

    @ManyToMany(cascade = [CascadeType.MERGE])
    var saveurs = mutableListOf<Saveur>()
}