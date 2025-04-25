package com.example.allinsafe_onlyui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.allinsafe_onlyui.databinding.Ac001MainInitMainBinding
import com.example.allinsafe_onlyui.ui.theme.AllinSafe_onlyUITheme

class MainActivity : ComponentActivity() {
    private lateinit var binding:Ac001MainInitMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=Ac001MainInitMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.spoofingDetectButton.setOnClickListener {
            val intent= Intent(this,Ac5_01_spoofingdetect_init_main::class.java)
            startActivity(intent)
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AllinSafe_onlyUITheme {
        Greeting("Android")
    }
}