package com.example.allinsafe_onlyui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.allinsafe_onlyui.databinding.Ac301VpnInitMainBinding

class Ac3_01_vpn_init_main : ComponentActivity() {
    private lateinit var binding: Ac301VpnInitMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=Ac301VpnInitMainBinding.inflate(layoutInflater)
        binding.backButton.setOnClickListener {
            finish()
        }
        binding.btnVpnStart.setOnClickListener {
            //vpn시작 함수
            var intent=Intent(this,Ac3_02_vpn_online::class.java)
            startActivity(intent)
        }
    }
}