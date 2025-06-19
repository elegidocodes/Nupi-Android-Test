package com.elegidocodes.androidtest.ui.fragment.splash;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.airbnb.lottie.LottieAnimationView;
import com.elegidocodes.androidtest.R;
import com.elegidocodes.androidtest.databinding.FragmentSplashBinding;

public class SplashFragment extends Fragment {

    private FragmentSplashBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        LottieAnimationView animationView = binding.animationView;

        animationView.setAnimation("splash.json");
        animationView.setRepeatCount(0);

        animationView.addLottieOnCompositionLoadedListener(composition -> {
            animationView.playAnimation();

            animationView.addAnimatorListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    animationView.animate()
                            .alpha(0f)
                            .setDuration(600)
                            .withEndAction(() -> {
                                animationView.setVisibility(View.GONE);
                                NavOptions navOptions = new NavOptions.Builder()
                                        .setPopUpTo(R.id.splashFragment, true)
                                        .build();

                                navController.navigate(R.id.loginFragment, null, navOptions);
                            })
                            .start();
                }
            });
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}