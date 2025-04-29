package com.example.allinsafe_onlyui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.allinsafe_onlyui.databinding.Ac501SpoofingdetectInitMainBinding
import com.example.allinsafe_onlyui.ui.theme.AllinSafe_onlyUITheme

//class Ac5_01_spoofingdetect_init_main : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//}

class Ac5_01_spoofingdetect_init_main : ComponentActivity() {
    private lateinit var binding:Ac501SpoofingdetectInitMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=Ac501SpoofingdetectInitMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            finish()
        }
        binding.btnDetectStart.setOnClickListener {
            var intent=Intent(this,Ac5_02_spoofingdetect_process::class.java)
            startActivity(intent)
        }
        binding.btnShowDetectHistory.setOnClickListener {
            var intent = Intent(this,Ac5_04_spoofingdetect_detect_history::class.java)
            startActivity(intent)
        }
    }
}