package br.com.fiap.antifraude.utils

fun formatPhone(phone: String): String {
    return phone.replace(Regex("[^0-9]"), "").take(11).let { number ->
        when {
            number.length <= 2 -> number
            number.length <= 6 -> "(${number.substring(0, 2)}) ${number.substring(2)}"
            else -> "(${number.substring(0, 2)}) ${number.substring(2, 6)}-${number.substring(6)}"
        }
    }
}
