/*
* Nombre: Javier Sebastián Valle Balsells
* Carnet: 20159
* Sección: 10
* Taller de CRUD.
* */
package com.prueba.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var btnAgregar: Button //Variable para buscar el botón de agregar.

    private val adaptador = Adaptador({
        clickListener -> Delete(clickListener)
    })


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val items : MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")*/

        //val  adaptador = Adaptador(items)

        btnAgregar = findViewById(R.id.btnAgregar) //Buscando el botón para agregar elementos

        val items : MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")

        //Agregando elemento a la lista.
        btnAgregar.setOnClickListener{
            items.add("Hola")

            adaptador.setItems(items)


            lista.layoutManager = LinearLayoutManager(this)
            lista.adapter = adaptador
        }

        adaptador.setItems(items)


        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador
    }

    //Eliminando elementos de la lista.
    fun Delete(position: Int){
        var items: MutableList<String> = adaptador.getList()
        items.removeAt(position)
        adaptador.setItems(items)
        lista.layoutManager=LinearLayoutManager(this)
        lista.adapter=adaptador
    }

    /*
    fun showItemClick(position:Int){
        val item = adaptador.getItem(position)
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
       // adaptador.delete(position)
        println(adaptador.getList())
    }*/
}