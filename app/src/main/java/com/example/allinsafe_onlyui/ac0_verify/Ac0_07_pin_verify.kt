package com.example.allinsafe_onlyui.ac0_verify

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.allinsafe_onlyui.ac0_patternpin.PatternLockView
import com.example.allinsafe_onlyui.ac0_verify.Ac0_06_pin_setup
import com.example.allinsafe_onlyui.databinding.Ac007PinVerifyBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class Ac0_07_pin_verify : ComponentActivity() {
    private lateinit var binding: Ac007PinVerifyBinding
    private lateinit var patternView: PatternLockView
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    private var currentUserId: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= Ac007PinVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Firebase 초기화
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        currentUserId = auth.currentUser?.uid

        binding.backButton.setOnClickListener {
            finish()
        }
        binding.btnBottomFinish.setOnClickListener {
            verifyPin()
        }
    }

    private fun verifyPin(){
        val inputPin=binding.etInputPin.text.toString().trim()
        currentUserId?.let { userId ->
            lifecycleScope.launch {
                try {
                    val document = firestore.collection("User").document(userId).get().await()
                    val pinArray = document.get("pin") as MutableList<Any?>?
                    val isPinSet = pinArray?.get(0) as? Long
                    val savedPin=pinArray?.get(1)

                    if (pinArray == null || isPinSet == 0L) {
                        Toast.makeText(this@Ac0_07_pin_verify,"현재 pin이 설정되어있지 않습니다", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    withContext(Dispatchers.Main) { //이거는 정확히 언제 실행되는거지?
                        if(inputPin.equals(savedPin)==true){
                            Toast.makeText(this@Ac0_07_pin_verify,"pin 인증 성공", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                        else{
                            Toast.makeText(this@Ac0_07_pin_verify,"pin 인증 실패", Toast.LENGTH_SHORT).show()
                        }
                    }


                } catch (e: Exception) {
                    Toast.makeText(this@Ac0_07_pin_verify, "패턴 검증 실패: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}