package com.westland.tyler.randomkindness

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

// Our content xmls, importing them allows us to access the views (pieces) as variables
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // This function describes what should happen when this activity starts
        // It is important (required) to call the super version of this function
        super.onCreate(savedInstanceState)
        // Loads the XML file that describes how the application looks
        setContentView(R.layout.activity_main)
        // Loads up the mostly unused tool bar on the top of the activity
        setSupportActionBar(toolbar)

        // Tells our activity what to do when the button is pushed
        fab.setOnClickListener { view ->
            showRandomKindPhrase()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_random_kind_phrase -> {
                showRandomKindPhrase()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun randomKindPhrase(): String {
        // Get the array of kind phrases
        val youArePieces = resources.getStringArray(R.array.you_are_pieces)
        // Pick a random index within the array
        val pieceIndex = (Math.random() * youArePieces.size).toInt()
        // Get the string that the phrase will be inserted into
        // English: "You are\n%1$s"
        // %1$s is the part that is replace according to String.format()'s rules.
        val youArePhrase = resources.getString(R.string.you_are_phrase)

        return String.format(youArePhrase, youArePieces[pieceIndex])
    }

    private fun showRandomKindPhrase() {
        // kind_phrase is a TextView object inside of content_main.xml
        // We imported it at the top of the file, so we can just access it.
    }
}
