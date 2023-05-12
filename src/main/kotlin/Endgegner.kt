class Endgegner(name: String, hp: Int, maxHp: Int, schaden: Int) : Gegner(name, hp, maxHp , schaden) {

    override fun schadenBekommen(schaden: Int) {
        super.schadenBekommen(schaden)
    }



    override fun angriff(heldenListe: List<Held>) {
        super.angriff(heldenListe)
    }

    fun feueratem(heldenListe: List<Held>) {
        if (heldenListe.all { it.blockieren() }) {
            println("Alle Helden haben den Angriff geblockt!")
            return
        }

        val heldenOhneBlock = heldenListe.filterNot { it.blockieren() }
        val zufaelligerIndex = (0 until heldenOhneBlock.size).random()
        val ziel = heldenOhneBlock[zufaelligerIndex]

        val anzahlHelden = heldenListe.size
        val schadenProHeld = schaden / anzahlHelden

        for (held in heldenListe) {
            if (held == ziel) {
                println("$name greift ${held.name} mit Feueratem an, aber ${held.name} hat den Angriff blockiert!")
                continue
            }

            held.hp -= schadenProHeld
            println("$name greift ${held.name} mit Feueratem an und verursacht $schadenProHeld Schaden!")
        }
    }

    var unterbossBeschworen = false

    fun unterbossBeschwoeren(): Unterboss? {
        return if (!unterbossBeschworen) {
            unterbossBeschworen = true
            println("$name beschwört den Unterboss!")
            Unterboss("Unterboss", 100, 100, 20)
        } else {
            println("Der Unterboss wurde bereits beschworen!")
            null
        }
    }


    var verflucht = false

    fun fluch(helden: List<Held>) {
        if (verflucht) {
            println("$name hat bereits einen Helden verflucht!")
            return
        }
        val randomHero = helden.random()
        println("$name verflucht ${randomHero.name}!")
        verflucht = true
        var cursedHp = randomHero.hp * 0.1
        while (randomHero.hp > randomHero.hp * 0.2) {
            randomHero.hp -= cursedHp.toInt()
            println("${randomHero.name} verliert $cursedHp HP durch den Fluch!")
            cursedHp *= 1.1
        }
    }
}