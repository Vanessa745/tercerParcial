package com.example.tercerparcial.planes

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.CardInfo
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanesViewModel @Inject constructor(
    @ApplicationContext private val context: Context
): ViewModel() {

    private val _cards = listOf(
        CardInfo("Plan FLEX 5", "$270", "$199", "5GB"),
        CardInfo("Plan FLEX 8", "$370", "$299", "8GB"),
        CardInfo("Plan FLEX 10", "$470", "$399", "10GB")
    )

    private val _indiceActual = MutableStateFlow<Int>(0)
    val indiceActual: StateFlow<Int> = _indiceActual

    val cardActual: StateFlow<CardInfo> = _indiceActual
        .map { _cards[it] }
        .stateIn(viewModelScope, SharingStarted.Eagerly, _cards[0])

    fun onNext() {
        if (_indiceActual.value < _cards.lastIndex) {
            _indiceActual.value++
        }
    }

    fun onPrevious() {
        if (_indiceActual.value > 0) {
            _indiceActual.value--
        }
    }

    fun enviarWhatsApp(context: Context) {
        val numero = "59173799262"
        val mensaje = "Hola, UCB mobile, preciso su ayuda"
        val url = "https://wa.me/$numero?text=${Uri.encode(mensaje)}"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "No se encontró una app para abrir el enlace", Toast.LENGTH_SHORT).show()
        }
    }
}