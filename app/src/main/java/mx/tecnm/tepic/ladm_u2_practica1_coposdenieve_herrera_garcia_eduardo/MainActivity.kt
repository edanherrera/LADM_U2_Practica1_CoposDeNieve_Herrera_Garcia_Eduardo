package mx.tecnm.tepic.ladm_u2_practica1_coposdenieve_herrera_garcia_eduardo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))
    }
}