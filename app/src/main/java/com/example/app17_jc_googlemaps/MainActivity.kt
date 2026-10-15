package com.example.app17_jc_googlemaps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.app17_jc_googlemaps.ui.theme.App17_jc_googlemapsTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App17_jc_googlemapsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val huancayo = LatLng(-12.0475111, -75.1990635)
                    val cameraPositionState = rememberCameraPositionState {
                        position = CameraPosition.fromLatLngZoom(huancayo, 14f)
                    }
                    GoogleMap(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        cameraPositionState = cameraPositionState
                    ) {
                        Marker(
                            state = rememberMarkerState(position = huancayo),
                            title = "Huancayo",
                            snippet = "Plaza Constitución"
                        )
                    }
                }
            }
        }
    }
}