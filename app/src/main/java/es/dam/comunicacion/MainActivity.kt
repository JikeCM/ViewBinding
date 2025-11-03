package es.dam.comunicacion

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_PERSONA = "persona"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    fun irSegunda(v: View){
        val nombre = findViewById<EditText>(R.id.txtNombre)
        val apellidos = findViewById<EditText>(R.id.txtApellidos)
        val edad = findViewById<EditText>(R.id.txtEdad)
        val persona: Persona = Persona(nombre.text.toString(), apellidos.text.toString(), edad.text.toString().toIntOrNull()?:0);
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_PERSONA, persona)
        startActivity(intent)

    }

}