package com.elegidocodes.androidtest.ui.fragment.library;

import static com.elegidocodes.androidtest.utility.SharedPreferencesUtil.get;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.elegidocodes.androidtest.R;
import com.elegidocodes.androidtest.databinding.FragmentLibrayItemBinding;
import com.elegidocodes.androidtest.model.LibraryItemResponseData;
import com.elegidocodes.androidtest.model.Token;
import com.elegidocodes.androidtest.model.User;


public class LibraryItemFragment extends Fragment {

    private FragmentLibrayItemBinding binding;
    private LibraryItemViewModel viewModel;

    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_libray_item, container, false);
        viewModel = new ViewModelProvider(this).get(LibraryItemViewModel.class);

        context = requireContext();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getLibraryItemResponseData()
                .observe(getViewLifecycleOwner(), serverResponse -> {
                    LibraryItemResponseData data = serverResponse.getData().get(0);
                    if (data != null) {
                        binding.setItemLibraryInfo(data);
                    }
                });

        Bundle bundle = getArguments();
        if (bundle != null) {
            int id = bundle.getInt("id");

            User user = get(context, "MyPrefs", "user", User.class);
            Token token = get(context, "MyPrefs", "token", Token.class);

            if(user == null || token == null) {
                Toast.makeText(context, "User or token is null", Toast.LENGTH_SHORT).show();
            }else{
                viewModel.getLibraryInfo(id, token.getAccessToken());
            }

        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}