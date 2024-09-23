package com.example.formapp

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a las vistas del formulario
        val etName: EditText = findViewById(R.id.etName)
        val etAge: EditText = findViewById(R.id.etAge)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        // Referencias a las vistas de la pantalla principal
        val tvNameDisplay: TextView = findViewById(R.id.tvNameDisplay)
        val tvAgeDisplay: TextView = findViewById(R.id.tvAgeDisplay)
        val btnBack: Button = findViewById(R.id.btnBack)

        // Layouts para manejar la visibilidad de la app
        val formLayout: View = findViewById(R.id.formLayout)
        val mainScreenLayout: View = findViewById(R.id.mainScreenLayout)

        // Acción al presionar el botón de enviar
        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val age = etAge.text.toString().trim()

            // Validar si todos los campos están completos
            if (name.isNotEmpty() && age.isNotEmpty()) {
                // Mostrar los datos en la pantalla principal
                tvNameDisplay.text = getString(R.string.display_name, name)
                tvAgeDisplay.text = getString(R.string.display_age, age)

                // Transición suave entre layouts
                fadeOut(formLayout)
                fadeIn(mainScreenLayout)
            }
        }

        // Acción al presionar el botón de regresar
        btnBack.setOnClickListener {
            // Transición suave de regreso al formulario
            fadeOut(mainScreenLayout)
            fadeIn(formLayout)
        }
    }

    // aparecer una vista con animación
    private fun fadeIn(view: View) {
        view.visibility = View.VISIBLE
        val fadeIn = AlphaAnimation(0.0f, 1.0f)
        fadeIn.duration = 500
        view.startAnimation(fadeIn)
    }

    // desaparecer la vista con animación
    private fun fadeOut(view: View) {
        val fadeOut = AlphaAnimation(1.0f, 0.0f)
        fadeOut.duration = 500
        view.startAnimation(fadeOut)
        view.visibility = View.GONE
    }
}
