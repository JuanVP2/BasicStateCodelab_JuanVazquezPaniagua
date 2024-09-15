package com.example.basicstatecodelab.ui.theme
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue  // Asegúrate de importar estos dos

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)  // Esto asegura que el texto ocupe todo el espacio disponible
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange  // Llama cuando el estado de la casilla cambia
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")  // Botón de cerrar
        }
    }
}

// Esta es la función con estado, que maneja el estado de la casilla de verificación
@Composable
fun WellnessTaskItem(taskName: String, modifier: Modifier = Modifier) {
    var checkedState by rememberSaveable { mutableStateOf(false) }  // Definimos el estado de la casilla

    WellnessTaskItem(
        taskName = taskName,
        checked = checkedState,  // Pasamos el estado a la función sin estado
        onCheckedChange = { newValue -> checkedState = newValue },  // Actualizamos el estado cuando cambie
        onClose = {},  // Por ahora dejamos esta función vacía
        modifier = modifier
    )
}