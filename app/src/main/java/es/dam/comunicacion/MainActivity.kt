package es.dam.comunicacion

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import es.dam.comunicacion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_PERSONA = "persona"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializamos el binding / layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    fun irSegunda(v: View){
        val persona: Persona = Persona(binding.txtNombre.text.toString(), binding.txtApellidos.text.toString(), binding.txtEdad.text.toString().toIntOrNull()?:0);
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_PERSONA, persona)
        startActivity(intent)

    }

}