package com.elegidocodes.androidtest.ui.fragment.login;

import static com.elegidocodes.androidtest.utility.SharedPreferencesUtil.get;
import static com.elegidocodes.androidtest.utility.SharedPreferencesUtil.save;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.elegidocodes.androidtest.R;
import com.elegidocodes.androidtest.databinding.FragmentLoginBinding;
import com.elegidocodes.androidtest.model.Token;
import com.elegidocodes.androidtest.model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class LoginFragment extends Fragment {

    private final static String TAG = "LOGIN_FRAGMENT";
    private final Gson gson = new Gson();

    private FragmentLoginBinding binding;
    private LoginViewModel loginViewModel;

    private Context context;

    private NavController navController;

    private TextInputLayout emailInputLayout;
    private TextInputLayout passwordInputLayout;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        context = requireContext();

        emailInputLayout = binding.emailInputLayout;
        passwordInputLayout = binding.passwordInputLayout;
        emailEditText = binding.emailEditText;
        passwordEditText = binding.passwordEditText;

        LinearLayout mainContent = binding.mainContent;
        mainContent.setVisibility(View.VISIBLE);
        mainContent.setAlpha(0f);
        mainContent.animate()
                .alpha(1f)
                .setDuration(600)
                .start();

        binding.buttonLogin.setOnClickListener(v -> login());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        User user = get(context, "MyPrefs", "user", User.class);
        if (user != null) {
            Toast.makeText(requireContext(), "Bienvenido " + user.getName(), Toast.LENGTH_SHORT).show();
        }

        // Initialize NavController
        navController = Navigation.findNavController(view);
    }

    private void login() {

        String email = emailEditText.getText() != null ? emailEditText.getText().toString().trim() : "";
        String password = passwordEditText.getText() != null ? passwordEditText.getText().toString().trim() : "";

        if (email.isEmpty()) {
            emailInputLayout.setError("Por favor ingrese su correo electrónico");
            return;
        }

        if (password.isEmpty()) {
            passwordInputLayout.setError("Por favor ingrese su contraseña");
            return;
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("password", password);

        loginViewModel.login(jsonObject)
                .thenAccept(serverResponse -> {

                    if (serverResponse != null) {

                        requireActivity().runOnUiThread(() -> {

                            if (serverResponse.getCode() == 200 && serverResponse.getData() != null) {
                                User user = serverResponse.getData().getUser();
                                Token token = serverResponse.getData().getToken();

                                Toast.makeText(requireContext(), "Bienvenido " + user.getName(), Toast.LENGTH_SHORT).show();

                                save(requireContext(), "MyPrefs", "user", user);
                                save(requireContext(), "MyPrefs", "token", token);
                                Log.d(TAG, gson.toJson(user));
                                Log.d(TAG, gson.toJson(token));

                                // Navigate to the next fragment
                                navController.navigate(R.id.fragmentHome);

                            } else if (serverResponse.getCode() == 401 && serverResponse.getError() != null) {
                                Toast.makeText(requireContext(), serverResponse.getError().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        });
                    }

                })
                .exceptionally(throwable -> {
                    Log.e(TAG, throwable.getMessage(), throwable);
                    return null;
                });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}