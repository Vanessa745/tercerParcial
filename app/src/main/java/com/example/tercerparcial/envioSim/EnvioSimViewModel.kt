package com.example.tercerparcial.envioSim

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class EnvioSimViewModel @Inject constructor(
    @ApplicationContext private val context: Context
): ViewModel() {
    private val _ubicacion = MutableStateFlow<LatLng?>(null)
    val ubicacion : StateFlow<LatLng?> = _ubicacion

    fun obtenerLatLong(latLng: LatLng) {
        _ubicacion.value = latLng
    }
}