package com.example.basicstatecodelab.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

// Definición de la pantalla principal WellnessScreen
@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        // Componente con estado para contar
        StatefulCounter()

        // Creamos la lista usando getWellnessTasks() y la convertimos en un MutableStateList
        val list = remember { getWellnessTasks().toMutableStateList() }

        // Mostramos la lista de tareas y permitimos eliminar tareas al cerrar
        WellnessTasksList(list = list, onCloseTask = { task -> list.remove(task) })
    }
}

// Función privada para generar una lista de WellnessTask
private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
