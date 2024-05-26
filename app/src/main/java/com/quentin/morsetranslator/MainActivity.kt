package com.quentin.morsetranslator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var inputText : TextView
    private lateinit var translatedText : TextView
    private lateinit var buttontranslate : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputText = findViewById(R.id.inputText)
        translatedText = findViewById(R.id.translatedText)
        buttontranslate = findViewById(R.id.buttontranslate)

        buttontranslate.setOnClickListener {
            val morseCode = MorseCode()
            val text = inputText.text.toString()
            val translated = morseCode.toMorseCode(text)
            translatedText.text = translated
        }
    }

    class MorseCode {
        private val morseCodeMap = mapOf(
            'A' to ".-",
            'B' to "-...",
            'C' to "-.-.",
            'D' to "-..",
            'E' to ".",
            'F' to "..-.",
            'G' to "--.",
            'H' to "....",
            'I' to "..",
            'J' to ".---",
            'K' to "-.-",
            'L' to ".-..",
            'M' to "--",
            'N' to "-.",
            'O' to "---",
            'P' to ".--.",
            'Q' to "--.-",
            'R' to ".-.",
            'S' to "...",
            'T' to "-",
            'U' to "..-",
            'V' to "...-",
            'W' to ".--",
            'X' to "-..-",
            'Y' to "-.--",
            'Z' to "--..",
            '0' to "-----",
            '1' to ".----",
            '2' to "..---",
            '3' to "...--",
            '4' to "....-",
            '5' to ".....",
            '6' to "-....",
            '7' to "--...",
            '8' to "---..",
            '9' to "----.",
            '.' to ".-.-.-",
            ',' to "--..--",
            '?' to "..--..",
            '\'' to ".----.",
            '!' to "-.-.--",
            '/' to "-..-.",
            '(' to "-.--.",
            ')' to "-.--.-",
            '&' to ".-...",
            ':' to "---...",
            ';' to "-.-.-.",
            '=' to "-...-",
            '+' to ".-.-.",
            '-' to "-....-",
            '_' to "..--.-",
            '"' to ".-..-.",
            '$' to "...-..-",
            '@' to ".--.-.",
            ' ' to " "
        )

        fun toMorseCode(text: String): String {
            val upperCaseText = text.uppercase(Locale.getDefault())
            val morseCode = StringBuilder()
            for (char in upperCaseText) {
                morseCode.append(morseCodeMap[char])
                morseCode.append(" ")
            }
            return morseCode.toString()
        }



    }
}