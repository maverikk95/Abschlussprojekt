open class Held(val name: String, var hp: Int, val maxHp:Int, var schaden: Int) {

    var beutelGenutzt = false
    fun nutzeBeutel() {
        if (!beutelGenutzt) {
            beutelGenutzt = true
        } else {
            println("$name hat den Beutel bereits genutzt!")
        }
    }

    open fun schadenBekommen(schaden: Int) {
        hp -= schaden
        if (hp <= 0) {
            println("$name wurde besiegt!")
        }
    }

    open fun blockieren(): Boolean = true

    open fun angriff(gegnerListe: MutableList<Gegner>) {
        println("Wähle einen Gegner aus:")
        gegnerListe.forEachIndexed { index, gegner ->
            println("${index + 1}: ${gegner.name} (HP: ${gegner.hp})")
        }
        val input = readLine()?.toIntOrNull()
        if (input != null && input <= gegnerListe.size && input > 0) {
            val ziel = gegnerListe[input - 1]
            val blockiert = ziel.blockieren()
            if (blockiert) {
                println("${ziel.name} hat den Angriff blockiert!")
            } else {
                val schaden = this.schaden
                ziel.hp -= schaden
                println("$name greift ${ziel.name} an und verursacht $schaden Schaden!")
            }
        } else {
            println("Ungültige Eingabe.")
        }
    }


    open fun spezialangriff(gegnerListe: List<Gegner>) {
        println("$name führt den Spezialangriff aus!")
        val trefferZahl = 5
        val ziele = mutableListOf<Gegner>()
        for (i in 1..trefferZahl) {
            print("Wähle das Ziel für den Treffer $i: ")
            val zielName = readLine() ?: ""
            val ziel = gegnerListe.find { it.name == zielName }
            if (ziel != null) {
                ziele.add(ziel)
            }
        }
        if (ziele.isNotEmpty()) {
            val trefferSchaden = schaden / trefferZahl
            for (ziel in ziele) {
                if (ziel.hp > 0) {
                    ziel.schadenBekommen(trefferSchaden)
                    println("${ziel.name} nimmt $trefferSchaden Schaden.")
                } else {
                    println("${ziel.name} ist bereits tot.")
                }
            }
        }
    }
}