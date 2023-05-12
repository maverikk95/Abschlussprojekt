class Magier(name: String, hp: Int, maxHp: Int, schaden: Int) : Held(name, hp, maxHp , schaden) {

    override fun schadenBekommen(schaden: Int) {
        super.schadenBekommen(schaden)
    }


    override fun angriff(gegnerListe: MutableList<Gegner>) {
        super.angriff(gegnerListe)
    }


    fun heilung(heldenListe: List<Held>) {
        println("Wen möchtest du heilen? 1 für ${heldenListe[0].name}, 2 für ${heldenListe[1].name} und 3 für ${heldenListe[2].name}")
        val eingabe = readLine()
        when(eingabe) {
            "1" -> {
                heldenListe[0].hp += heldenListe[0].maxHp / 2
                println("$name heilt ${heldenListe[0].name} um ${heldenListe[0].maxHp / 2} HP!")
            }
            "2" -> {
                heldenListe[1].hp += heldenListe[1].maxHp / 2
                println("$name heilt ${heldenListe[1].name} um ${heldenListe[1].maxHp / 2} HP!")
            }
            "3" -> {
                heldenListe[2].hp += heldenListe[2].maxHp / 2
                println("$name heilt ${heldenListe[2].name} um ${heldenListe[2].maxHp / 2} HP!")
            }
        }
    }
}