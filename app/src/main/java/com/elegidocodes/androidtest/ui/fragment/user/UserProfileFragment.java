package com.elegidocodes.androidtest.ui.fragment.user;

import static com.elegidocodes.androidtest.utility.SharedPreferencesUtil.get;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.elegidocodes.androidtest.R;
import com.elegidocodes.androidtest.databinding.FragmentUserProfileBinding;
import com.elegidocodes.androidtest.model.Token;
import com.elegidocodes.androidtest.model.User;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UserProfileFragment extends Fragment {

    private FragmentUserProfileBinding binding;
    private UserProfileViewModel viewModel;

    private Context context;


    private TextInputLayout firstNameInputLayout;
    private TextInputLayout lastNameInputLayout;
    private TextInputLayout emailInputLayout;

    private TextInputEditText firstNameEditText;
    private TextInputEditText lastNameEditText;
    private TextInputEditText emailEditText;

    private MaterialButton btnUpdateProfile;

    private User user;
    private Token token;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false);
        viewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);

        context = requireContext();

        bind();

        btnUpdateProfile.setOnClickListener(v -> updateProfile());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        user = get(context, "MyPrefs", "user", User.class);
        token = get(context, "MyPrefs", "token", Token.class);

        if (user != null && token != null) {
            firstNameEditText.setText(user.getName());
            lastNameEditText.setText(user.getLastName());
            emailEditText.setText(user.getEmail());

            Glide.with(context)
                    .load(user.getProfilePicture())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.imageView);

        }

    }

    private void bind() {
        firstNameInputLayout = binding.nameInputLayout;
        lastNameInputLayout = binding.lastNameInputLayout;
        emailInputLayout = binding.emailInputLayout;

        firstNameEditText = binding.nameEditText;
        lastNameEditText = binding.lastNameEditText;
        emailEditText = binding.emailEditText;

        btnUpdateProfile = binding.updateProfile;
    }

    private void updateProfile() {
        String firstName = firstNameEditText.getText() != null ? firstNameEditText.getText().toString() : "";
        String lastName = lastNameEditText.getText() != null ? lastNameEditText.getText().toString() : "";
        String email = emailEditText.getText() != null ? emailEditText.getText().toString() : "";

        if (firstName.isEmpty()) {
            firstNameInputLayout.setError("First name is required");
            return;
        }

        if (lastName.isEmpty()) {
            lastNameInputLayout.setError("Last name is required");
            return;
        }

        if (email.isEmpty()) {
            emailInputLayout.setError("Email is required");
            return;
        }

        viewModel.updateProfile(firstName, lastName, email, token.getAccessToken())
                .thenAccept(serverResponse -> {

                    requireActivity().runOnUiThread(() -> {
                        Toast.makeText(context, serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    });

                })
                .exceptionally(throwable -> {
                    Log.e("UserProfileFragment", "Error updating profile", throwable);
                    return null;
                });

        Toast.makeText(requireContext(), "Updating profile...", Toast.LENGTH_SHORT).show();

    }

}