import kotlin.random.Random
fun main() {
    val bogenschuetze: Bogenschütze = Bogenschütze("Legolas", 250, 250, 30)
    val krieger: Krieger = Krieger("Boromir", 350, 350, 50)
    val magier: Magier = Magier("Gandalf", 150, 150, 25)
    var heldTeam = mutableListOf(bogenschuetze, krieger, magier)

    var unterboss: Unterboss? = null
    val endgegner = Endgegner("Sauron", 1000, 1000, 50)
    var gegnerTeam = mutableListOf(endgegner, unterboss)

    println("Willkommen zum Kampf gegen ${endgegner.name}!")


    var round = 1
    while (heldTeam.any { it.hp > 0 } && gegnerTeam.any { (it?.hp ?: 0) > 0 }) {
        println("----- Runde $round -----")


        println("Wähle eine Aktion für ${bogenschuetze.name}:")
        println("1. Angriff")
        println("2. Blockieren")
        println("3. Zielschuss")
        println("4. Beutel benutzen")

        val bogenschuetzeAktion = readLine()?.toIntOrNull()
        when (bogenschuetzeAktion) {
         //   1 -> bogenschuetze.angriff(gegnerTeam)
            2 -> bogenschuetze.blockieren()
        //    3 -> bogenschuetze.zielschuss()
            4 -> bogenschuetze.nutzeBeutel()
        }

        println("Wähle eine Aktion für ${krieger.name}:")
        println("1. Angriff")
        println("2. Blockieren")
        println("3. SchadenBoost")
        println("4. Beutel benutzen")


        val kriegerAktion = readLine()?.toIntOrNull()
        when (kriegerAktion) {
         //   1 -> krieger.angriff(gegnerTeam)
            2 -> krieger.blockieren()
            3 -> krieger.schadenBoost()
            4 -> krieger.nutzeBeutel()
        }

        println("Wähle eine Aktion für ${magier.name}:")
        println("1. Angriff")
        println("2. Blockieren")
        println("3. Heilung")
        println("4. Beutel benutzen")


        val magierAktion = readLine()?.toIntOrNull()
        when (magierAktion) {
         //   1 -> magier.angriff(gegnerTeam)
            2 -> magier.blockieren()
            3 -> magier.heilung(heldTeam)
            4 -> magier.nutzeBeutel()
        }

        val endgegnerAktion = when (Random.nextInt(5)) {
            0 -> "angriff"
            1 -> "blocken"
            2 -> "feueratem"
            3 -> "fluch"
            4 -> "unterbossBeschwoeren"

            else -> {
                0
            }
        }

        when (endgegnerAktion) {
            "angriff" -> endgegner.angriff(heldTeam)
            "blocken" -> endgegner.blockieren()
            "feueratem" -> endgegner.feueratem(heldTeam)
            "fluch" -> endgegner.fluch(heldTeam)
            "unterbossBeschwoeren" -> {
                val unterboss = Unterboss("Nazgul", 500, 500, 40)
                gegnerTeam.add(unterboss)
                println("Sauron ruft den Unterboss Nazgul zur Hilfe!")
            }
        }
        for (held in heldTeam) {
            println("${held.name}: HP = ${held.hp}")
        }
        for (gegner in gegnerTeam) {
            if (gegner != null) {
                println("${gegner.name}: HP = ${gegner.hp}")
            }
        }

        round++
    }
}