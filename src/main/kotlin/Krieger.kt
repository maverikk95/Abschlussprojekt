class Krieger(name: String, hp: Int, maxHp: Int, schaden: Int) : Held(name, hp, maxHp , schaden) {

    override fun schadenBekommen(schaden: Int) {
        super.schadenBekommen(schaden)
    }





    var schadenBoostRunden = 0

    fun schadenBoost() {
        schadenBoostRunden = 2
        println("$name erhöht seinen Schaden für die nächsten 2 Runden!")
    }

    override fun angriff(gegnerListe: MutableList<Gegner>) {
        println("Welchen Gegner möchtest du angreifen?")
        for (i in 0 until gegnerListe.size) {
            println("${i + 1}: ${gegnerListe[i].name}")
        }
        val eingabe = readLine()
        val index = eingabe?.toIntOrNull()?.minus(1) ?: return
        if (index in 0 until gegnerListe.size) {
            val ziel = gegnerListe[index]
            if (schadenBoostRunden > 0) {
                ziel.hp -= schaden * 2
                schadenBoostRunden--
                println("$name greift ${ziel.name} an und verursacht ${schaden * 2} Schaden!")
            } else {
                super.angriff(gegnerListe)
            }
        }
    }
}