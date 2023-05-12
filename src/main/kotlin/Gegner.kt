import kotlin.random.Random
open class Gegner(val name: String, var hp: Int, val maxHp:Int, var schaden: Int) {

    open fun blockieren(): Boolean = true

    open fun angriff(heldenListe: List<Held>) {
        val zielIndex = Random.nextInt(heldenListe.size)
        val ziel = heldenListe[zielIndex]
        val blockiert = ziel.blockieren()
        if (blockiert) {
            println("${ziel.name} hat den Angriff blockiert!")
        } else {
            val schaden = this.schaden
            ziel.hp -= schaden
            println("$name greift ${ziel.name} an und verursacht $schaden Schaden!")
        }
    }


    open fun schadenBekommen(schaden: Int) {
        hp -= schaden
        if (hp <= 0) {
            println("$name wurde besiegt!")
        }
    }
}