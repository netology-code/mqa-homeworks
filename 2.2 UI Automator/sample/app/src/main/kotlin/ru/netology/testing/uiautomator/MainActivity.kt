package ru.netology.testing.uiautomator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.testing.uiautomator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonChange.setOnClickListener {
                val text = binding.userInput.text
                if (text.isNotBlank()) {
                    textToBeChanged.text = text
                }
            }
            buttonActivity.setOnClickListener {
                val intent = ShowTextActivity.newStartIntent(
                    this@MainActivity,
                    binding.userInput.text.toString()
                )
                startActivity(intent)
            }
        }
    }
}