class Beutel {
    var heiltrankAnzahl = 3
    var vitaminAnzahl = 1

    fun heiltrankAnwenden(ziel: Held) {
        when (ziel) {
            is Krieger -> {
                println("Möchtest du den Heiltrank auf ${ziel.name} anwenden? (Ja/Nein)")
                val input = readLine()
                if (input?.lowercase() == "ja") {
                    if (heiltrankAnzahl > 0) {
                        ziel.hp += ziel.hp / 2
                        println("${ziel.name} wurde um ${ziel.hp / 2} HP geheilt.")
                        heiltrankAnzahl--
                    } else {
                        println("Keine Heiltränke mehr im Beutel.")
                    }
                }
            }

            is Bogenschütze -> {
                println("Möchtest du den Heiltrank auf ${ziel.name} anwenden? (Ja/Nein)")
                val input = readLine()
                if (input?.lowercase() == "ja") {
                    if (heiltrankAnzahl > 0) {
                        ziel.hp += ziel.hp / 2
                        println("${ziel.name} wurde um ${ziel.hp / 2} HP geheilt.")
                        heiltrankAnzahl--
                    } else {
                        println("Keine Heiltränke mehr im Beutel.")
                    }
                }
            }

            is Magier -> {
                println("Möchtest du den Heiltrank auf ${ziel.name} anwenden? (Ja/Nein)")
                val input = readLine()
                if (input?.lowercase() == "ja") {
                    if (heiltrankAnzahl > 0) {
                        ziel.hp += ziel.hp / 2
                        println("${ziel.name} wurde um ${ziel.hp / 2} HP geheilt.")
                        heiltrankAnzahl--
                    } else {
                        println("Keine Heiltränke mehr im Beutel.")
                    }
                }
            }
        }
    }

    fun vitaminAnwenden(ziel: Held) {
        when (ziel) {
            is Krieger -> {
                println("Möchtest du das Vitamin auf ${ziel.name} anwenden? (Ja/Nein)")
                val input = readLine()
                if (input?.lowercase() == "ja") {
                    if (vitaminAnzahl > 0) {
                        ziel.schaden = (ziel.schaden * 1.1).toInt()
                        println("${ziel.name}'s Schaden wurde um 10% erhöht.")
                        vitaminAnzahl--
                    } else {
                        println("Kein Vitamin mehr im Beutel.")
                    }
                }
            }

            is Bogenschütze -> {
                println("Möchtest du das Vitamin auf ${ziel.name} anwenden? (Ja/Nein)")
                val input = readLine()
                if (input?.lowercase() == "ja") {
                    if (vitaminAnzahl > 0) {
                        ziel.schaden = (ziel.schaden * 1.1).toInt()
                        println("${ziel.name}'s Schaden wurde um 10% erhöht.")
                        vitaminAnzahl--
                    } else {
                        println("Kein Vitamin mehr im Beutel.")
                    }
                }
            }

            is Magier -> {
                println("Möchtest du das Vitamin auf ${ziel.name} anwenden? (Ja/Nein)")
                val input = readLine()
                if (input?.lowercase() == "ja") {
                    if (vitaminAnzahl > 0) {
                        ziel.schaden = (ziel.schaden * 1.1).toInt()
                        println("${ziel.name}'s Schaden wurde um 10% erhöht.")
                        vitaminAnzahl--
                    } else {
                        println("Kein Vitamin mehr im Beutel.")
                    }
                }
            }
        }
    }
}