package sananismayilov.au.noteapp.presentation.splashscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import sananismayilov.au.noteapp.R


@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler().postDelayed(Runnable {
            Navigation.findNavController(requireView()).navigate(R.id.startpage)
        }, 4000)


        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }


}