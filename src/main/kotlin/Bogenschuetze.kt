class Bogenschütze(name: String, hp: Int, maxHp: Int, schaden: Int) : Held(name, hp, maxHp , schaden) {

    override fun schadenBekommen(schaden: Int) {
        super.schadenBekommen(schaden)
    }

    fun zielschuss(ziel1: Gegner, ziel2: Unterboss) {
        println("Welches Ziel möchtest du angreifen? 1 für ${ziel1.name} und 2 für ${ziel2.name}")
        val eingabe = readLine()
        when(eingabe) {
            "1" -> {
                val chance = (1..100).random()
                if (chance < 50) {
                    val schadenMitBonus = (schaden * 1.5).toInt()
                    ziel1.hp -= schadenMitBonus
                    println("$name greift ${ziel1.name} mit einem Zielschuss an und verursacht $schadenMitBonus Schaden!")
                } else {
                    ziel1.hp -= schaden
                    println("$name greift ${ziel1.name} an und verursacht $schaden Schaden!")
                }
            }
            "2" -> {
                val chance = (1..100).random()
                if (chance < 50) {
                    val schadenMitBonus = (schaden * 1.5).toInt()
                    ziel2.hp -= schadenMitBonus
                    println("$name greift ${ziel2.name} mit einem Zielschuss an und verursacht $schadenMitBonus Schaden!")
                } else {
                    ziel2.hp -= schaden
                    println("$name greift ${ziel2.name} an und verursacht $schaden Schaden!")
                }
            }
        }
    }
}