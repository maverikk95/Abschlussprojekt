class Unterboss(name: String, hp: Int, maxHp: Int, schaden: Int): Gegner(name, hp,maxHp, schaden, ){

    override fun schadenBekommen(schaden: Int) {
        super.schadenBekommen(schaden)
    }


    override fun angriff(heldenListe: List<Held>) {
        super.angriff(heldenListe)
    }

    fun heilen(endgegner: Endgegner) {
        val heilWert = endgegner.maxHp * 0.05
        endgegner.hp = kotlin.math.min(endgegner.hp + heilWert.toInt(), endgegner.maxHp)
        println("$name heilt $endgegner um $heilWert HP!")
    }
}