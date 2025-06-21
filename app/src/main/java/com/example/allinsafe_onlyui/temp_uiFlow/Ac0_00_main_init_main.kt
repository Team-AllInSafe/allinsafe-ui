package com.example.allinsafe_onlyui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.allinsafe_onlyui.databinding.Ac000MainInitMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding:Ac000MainInitMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=Ac000MainInitMainBinding.inflate(layoutInflater)
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