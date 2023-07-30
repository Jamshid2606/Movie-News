package jama.apps.movienews.presentation

import android.os.CountDownTimer
import dagger.hilt.android.AndroidEntryPoint
import jama.apps.movienews.R
import jama.apps.movienews.databinding.FragmentSplashBinding
import jama.apps.movienews.presentation.BaseFragment

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun onViewCreate() {
        object : CountDownTimer(2000, 100) {
            override fun onFinish() {
                navController.navigate(R.id.action_splashFragment_to_navigation_home)
            }

            override fun onTick(value: Long) {

            }
        }.start()
    }
}