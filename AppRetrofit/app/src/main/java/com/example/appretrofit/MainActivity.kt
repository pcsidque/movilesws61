package com.example.appretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadJoke()
    }

    private fun loadJoke() {
        val tvJoke = findViewById<TextView>(R.id.tvJoke)

        //creare una instancia de retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //creare una instancia de la interface
        val jokeService: JokeService
        jokeService = retrofit.create(JokeService::class.java)

        //creo una variable y le asigno la funcion getJoke
        val request = jokeService.getJoke("json")

        request.enqueue(object : Callback<Joke>{
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if (response.isSuccessful){
                    tvJoke.text = response.body()!!.joke
                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })







    }
}