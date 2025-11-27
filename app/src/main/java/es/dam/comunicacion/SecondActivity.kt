package es.dam.comunicacion

import android.os.Build
import android.os.Build.VERSION
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.dam.comunicacion.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializamos el binding / layout
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val persona = if (VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(MainActivity.EXTRA_PERSONA, Persona::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Persona>(MainActivity.EXTRA_PERSONA)
        }
        binding.txtSecNombre.text = persona?.nombre.toString()
        binding.txtSecApellidos.text = persona?.apellidos.toString()
        binding.txtSecEdad.text = persona?.edad.toString()
    }
}