package com.iesmurgi.u7_proyecto1_cuadrosdedialogo

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.iesmurgi.u7_proyecto1_cuadrosdedialogo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }

    fun dialogoAlerta(view : View){
        val cochesCaros = arrayOf("Lamborghini Veneno", "Bugatti Chiron", "Koenigsegg CCXR Trevita", "Pagani Huayra BC", "Rolls Royce Sweptail")
        val adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, cochesCaros)

        val constructor = AlertDialog.Builder(this)
        constructor.setTitle("Coches mas caros")
        constructor.setAdapter(adapter){ dialog, which ->
            val selectedModel = cochesCaros[which]
            Toast.makeText(this, "Modelo seleccionado: $selectedModel", Toast.LENGTH_SHORT).show()
        }
        val dialog: AlertDialog = constructor.create()
        dialog.show()

    }

    fun alertaSiNo(view: View){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Rate us!")
        builder.setMessage("¿Te gusta la aplicacion?")
        builder.setPositiveButton("Sí") { dialog, which ->
            Toast.makeText(this, "Has presionado Si, muchas gracias, sus valoraciones nos hacen mejorar", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { dialog, which ->
            Toast.makeText(this, "Has presionado No, intentare mejorar", Toast.LENGTH_SHORT).show()
        }
        val dialog = builder.create()
        dialog.show()
        dialog.setCancelable(false)
    }



}