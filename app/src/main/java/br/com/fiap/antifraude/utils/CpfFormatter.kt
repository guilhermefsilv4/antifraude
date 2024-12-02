package br.com.fiap.antifraude.utils

fun formatCpf(cpf: String): String {
    return cpf.replace(Regex("[^0-9]"), "").take(11).let { number ->
        when {
            number.length <= 3 -> number
            number.length <= 6 -> "${number.substring(0, 3)}.${number.substring(3)}"
            number.length <= 9 -> "${number.substring(0, 3)}.${
                number.substring(
                    3,
                    6
                )
            }.${number.substring(6)}"

            else -> "${number.substring(0, 3)}.${number.substring(3, 6)}.${
                number.substring(
                    6,
                    9
                )
            }-${number.substring(9)}"
        }
    }
}
