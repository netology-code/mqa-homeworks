package ru.netology.testing.uiautomator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.testing.uiautomator.databinding.ActivityShowTextBinding

class ShowTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityShowTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.text.text = intent.getStringExtra(KEY_EXTRA_MESSAGE) ?: ""
    }

    companion object {

        const val KEY_EXTRA_MESSAGE = "testing_message"

        fun newStartIntent(context: Context, message: String): Intent {
            val newIntent = Intent(context, ShowTextActivity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }
}