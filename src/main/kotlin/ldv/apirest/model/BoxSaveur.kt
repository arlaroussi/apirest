package ldv.apirest.model

import jakarta.persistence.*

@Entity
@Table(name="boxsaveurs")
class BoxSaveur (

    @Column(name = "idbox", nullable = false)
    val idBox: Long,

    @Column(name = "idSaveur", nullable = false)
    val idSaveur: Long = 0
)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}