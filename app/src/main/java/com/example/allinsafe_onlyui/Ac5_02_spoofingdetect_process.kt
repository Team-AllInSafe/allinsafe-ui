package com.example.allinsafe_onlyui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.example.allinsafe_onlyui.databinding.Ac501SpoofingdetectInitMainBinding
import com.example.allinsafe_onlyui.databinding.Ac502SpoofingdetectProcessBinding

class Ac5_02_spoofingdetect_process : ComponentActivity() {
    private lateinit var binding: Ac502SpoofingdetectProcessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=Ac502SpoofingdetectProcessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            finish()
        }
        tempDetect_for10sec(binding){
            detect_complete(binding)
        }

        binding.textviewProcess.text="검사중..."


    }
    fun detect_complete(binding:Ac502SpoofingdetectProcessBinding){
        //실제 스푸핑 코드와 연동하였을때 사용하기 위한 함수
        Toast.makeText(this.applicationContext,"스푸핑 탐지가 완료되었습니다!",Toast.LENGTH_LONG).show()
        var intent=Intent(this,Ac5_03_spoofoingdetect_completed::class.java)
        startActivity(intent)
    }
}
fun tempDetect_for10sec(binding: Ac502SpoofingdetectProcessBinding,onFinished: () -> Unit): Unit{
    //프로그레스바에 대한 임시 함수로, 10초간 탐지(하는것처럼 보인) 후 다음 화면으로 넘어갑니다.
    var i = 1
    val handler = Handler(Looper.getMainLooper())
    val runnable = object : Runnable {
        override fun run() {
            if (i <= 10) {
                binding.progressbar.setProgress(10)
                binding.textviewProcess.text = "${i}초"
                i += 1
                handler.postDelayed(this, 1000) // 1초 후 다시 실행
            }
            else{
                onFinished()
            }
        }
    }
    handler.post(runnable) // 최초 실행
}

