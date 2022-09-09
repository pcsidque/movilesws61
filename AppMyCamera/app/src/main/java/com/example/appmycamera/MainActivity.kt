package com.example.appmycamera

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCamara = findViewById<Button>(R.id.btCamara)

        btCamara.setOnClickListener {
            checkCameraPermission()
        }
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED)
        {
            //no tengo permiso
            Toast.makeText(this, "No tienes permiso...", Toast.LENGTH_LONG).show()
            requestCameraPermission()
        }
        else{
            //si tengo permiso
            Toast.makeText(this, "Ya cuenta con permiso de la camara", Toast.LENGTH_LONG).show()
        }
    }

    private fun requestCameraPermission() {
        //1er caso: ya pedimos permiso. Debo activar el permiso manualmente
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
            Toast.makeText(this, "Rechazo el permiso ANTES. Debe activar el permiso manualmente", Toast.LENGTH_LONG).show()
        }
        //2do caso: nunca pedi permiso. Solicito el permiso
        else{
            //Aqui realmente solicitamos el permiso con requestPermissions
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permiso otorgado", Toast.LENGTH_LONG).show()
                    //aqui se pone las funcionalidades
                }
                else{
                    Toast.makeText(this, "Permiso NEGADO!!!", Toast.LENGTH_LONG).show()
                }
                return
            }
        }
    }
}