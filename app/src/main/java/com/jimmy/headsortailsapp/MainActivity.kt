package com.jimmy.headsortailsapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to flip a coin and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flipButton: Button = findViewById(R.id.flip_coin)

        flipButton.setOnClickListener { flipCoin() }
    }
    /**
     * Flip the coin and update the screen with the result.
     */
    fun flipCoin() {
        // Create new HeadsOrTails object, call the getHeadsOrTails method and store result in flipResult variable.
        val headsTailsOne = HeadsOrTails()
        val flipResult = headsTailsOne.getHeadsOrTails()

        val coinImage: ImageView = findViewById(R.id.image_coin)
        // Once the result of flipping the coin is known, the correct resource image is found.
        val drawableResource = when (flipResult) {
            "Heads" -> R.drawable.headdds
            "Tails" -> R.drawable.tails
            else -> R.drawable.tails
        }
        //The correct resource image is then displayed on the screen and content description is set.
        coinImage.setImageResource(drawableResource)
        coinImage.contentDescription = flipResult.toString()
    }
    // This is the class that contains the method which produces the heads or tails result.
    class HeadsOrTails {
        fun getHeadsOrTails(): String {
            val headTails: List<String> = listOf("Heads", "Tails")
            return headTails.random()

        }
    }

}
/**
 * Future updates can include making it clear that when you click once, even if the
 * image doesn't change, it still means that the coin has been clicked.
 */