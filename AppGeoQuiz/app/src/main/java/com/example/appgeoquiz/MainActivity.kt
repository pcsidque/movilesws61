package com.example.appgeoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var pos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        var question = Question("Es Lima capital de Peru?", true)
        questions.add(question)

        questions.add(Question("Es Lima capital de Chile?", false))
        questions.add(Question("Es Piura capital de Chile?", false))
        questions.add(Question("Es Brasil capital de Chile?", false))
        questions.add(Question("Es Bogota capital de Colombia?", true))
        questions.add(Question("Es Bs As capital de Chile?", false))
        questions.add(Question("Es Bs As capital de Argentina?", true))
    }

    private fun setupViews() {
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val textView = findViewById<TextView>(R.id.tvQuestion)
        val btNext = findViewById<Button>(R.id.btNext)

        textView.text = questions[pos].sentence


        btYes.setOnClickListener {
            if (questions[pos].answer) {
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }
        }

        btNo.setOnClickListener {
            if (questions[pos].answer) {
                Toast.makeText(this, "InCorrecto", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            }
        }

        btNext.setOnClickListener {
            pos++
            textView.text = questions[pos].sentence
        }
    }
}