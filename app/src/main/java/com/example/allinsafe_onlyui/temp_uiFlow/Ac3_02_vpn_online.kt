package com.example.allinsafe_onlyui

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.allinsafe_onlyui.databinding.Ac302VpnOnlineBinding

class Ac3_02_vpn_online : ComponentActivity() {
    private lateinit var binding: Ac302VpnOnlineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=Ac302VpnOnlineBinding.inflate(layoutInflater)
        binding.backButton.setOnClickListener {
            finish()
        }
        binding.btnVpnStop.setOnClickListener {
            //vpn 끝내는 함수
            finish()
        }
    }

}