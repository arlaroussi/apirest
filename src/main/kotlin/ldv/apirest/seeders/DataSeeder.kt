package ldv.apirest.seeders

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import ldv.apirest.model.*
import ldv.apirest.repository.*
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.data.domain.Example
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.io.FileInputStream
import java.io.InputStreamReader

@Component
class DataSeeder(
    private val boxRepository: BoxRepository,
    private val alimentRepository: AlimentRepository,
    private val saveurRepository: SaveurRepository,
    private val alimentBoxRepository: AlimentBoxRepository
) : ApplicationRunner {

    override fun run(args: ApplicationArguments) {

        val mapper = jacksonObjectMapper()

        var sourceData: String = "G:/projets/spring/apirest/src/main/kotlin/ldv/apirest/assets/boxes1.json"
        val result: JsonNode = mapper.readTree(InputStreamReader(FileInputStream(sourceData)))
        var aBox1: Box
        var aliment: Aliment
        var saveur: Saveur
        var alimentBox: AlimentBox

        for (elem in result) {
            aBox1 = Box(
                elem.get("nom").toString(),
                elem.get("pieces").asInt(),
                elem.get("prix").asDouble(),
                elem.get("image").toString()
            )
            //Ajout d'une Box

            //Ajout des saveurs
            for (j: Int in 0 until elem.get("saveurs").size()) {
                if (saveurRepository.findSaveurByName(elem.get("saveurs")[j].toString()) == 0) {
                    saveur = Saveur(elem.get("saveurs")[j].toString())
                } else {
                    var id: Long
                    id = saveurRepository.findSaveurIdByName(elem.get("saveurs")[j].toString())
                    saveur = saveurRepository.findByIdOrNull(id)!!
                }
                saveurRepository.save(saveur)
                aBox1.saveurs.add(saveur)
            }
            boxRepository.save(aBox1)

            //Ajout des aliments
            for (i: Int in 0 until elem.get("aliments").size()) {
                aliment = Aliment(elem.get("aliments")[i].get("nom").toString())
                if (alimentRepository.findAlimentByName(aliment.nom) == 0)
                    alimentRepository.save(aliment)
                else {
                    var id: Long
                    id = alimentRepository.finAlimentIdByName(elem.get("aliments")[i].get("nom").toString())
                    aliment = alimentRepository.findByIdOrNull(id)!!
                    alimentRepository.save(aliment)
                }
                alimentBox = AlimentBox(
                    elem.get("aliments")[i].get("quantite").asInt(),
                    aBox1,
                    aliment
                )
                alimentBoxRepository.save(alimentBox)
            }

        }
    }
}





