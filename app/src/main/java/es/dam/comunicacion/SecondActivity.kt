package es.dam.comunicacion

import android.os.Build
import android.os.Build.VERSION
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        val persona = if (VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(MainActivity.EXTRA_PERSONA, Persona::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Persona>(MainActivity.EXTRA_PERSONA)
        }
        findViewById<TextView>(R.id.txtSecNombre).text = persona?.nombre.toString()
        findViewById<TextView>(R.id.txtSecApellidos).text = persona?.apellidos.toString()
        findViewById<TextView>(R.id.txtSecEdad).text = persona?.edad.toString()
    }
}