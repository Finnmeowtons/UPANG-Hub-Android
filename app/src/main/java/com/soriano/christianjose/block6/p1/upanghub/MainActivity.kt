package com.soriano.christianjose.block6.p1.upanghub

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.soriano.christianjose.block6.p1.upanghub.databinding.ActivityMainBinding
import com.soriano.christianjose.block6.p1.upanghub.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var sharedViewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]
        sharedViewModel.appbarTitle.observe(this) { newTitle ->
            binding.topAppBar.title = newTitle
        }

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.home ->{
                    binding.topAppBar.title = "Home"
                    navController.popBackStack()
                }
                R.id.map -> {
                    binding.topAppBar.title = "Map"
                    navController.navigate(R.id.action_map)
                }
                R.id.schedule -> {
                    binding.topAppBar.title = "Schedule"
                }
                R.id.bank -> {
                    binding.topAppBar.title = "Bank"
                }
                R.id.registrar -> {
                    binding.topAppBar.title = "Registrar"
                }
            }
            binding.main.closeDrawers()
            true
        }
        onBackPressedDispatcher.addCallback(this){
            if (navController.currentDestination?.id == R.id.homeFragment) { // Check if nasa home
                if (onBackPressedDispatcher.hasEnabledCallbacks()) {
                    Toast.makeText(this@MainActivity, "Press back again to exit", Toast.LENGTH_SHORT).show()
                    isEnabled = false
                    Handler(Looper.getMainLooper()).postDelayed({ isEnabled = true }, 2000) // Re-enable after 2 seconds
                } else {
                    finish()
                }
            } else {
                when (navController.currentDestination?.id){
                    R.id.mapFragment -> {
                        navController.popBackStack()
                    }

                }
            }
        }
    }
}