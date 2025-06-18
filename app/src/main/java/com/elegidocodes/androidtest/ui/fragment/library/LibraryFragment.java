package com.elegidocodes.androidtest.ui.fragment.library;

import static com.elegidocodes.androidtest.utility.SharedPreferencesUtil.get;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elegidocodes.androidtest.R;
import com.elegidocodes.androidtest.adapter.LibraryItemAdapter;
import com.elegidocodes.androidtest.databinding.FragmentLibraryBinding;
import com.elegidocodes.androidtest.model.LibraryResponseDatum;
import com.elegidocodes.androidtest.model.Token;
import com.elegidocodes.androidtest.model.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment {

    private static final String TAG = "LIBRARY_FRAGMENT";

    private FragmentLibraryBinding binding;
    private LibraryViewModel viewModel;

    private Context context;

    private User user;
    private Token token;

    private RecyclerView recyclerView;
    private LibraryItemAdapter adapter;

    private NavController navController;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_library, container, false);
        viewModel = new ViewModelProvider(this).get(LibraryViewModel.class);

        context = requireContext();

        recyclerView = binding.recyclerView;

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        user = get(context, "MyPrefs", "user", User.class);
        token = get(context, "MyPrefs", "token", Token.class);

        adapter = new LibraryItemAdapter(context, new ArrayList<>(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

        viewModel.getLibraryResponseData()
                .observe(getViewLifecycleOwner(), serverResponse -> {
                    List<LibraryResponseDatum> data = serverResponse.getData().getData();
                    if (data != null && !data.isEmpty()) {
                        Log.d(TAG, "Size: " + data.size());

                        adapter.refresh(data);
                    }
                });

        if (user == null || token == null) {
            Log.d(TAG, "User or token is null");
            binding.libraryInputEditText.setEnabled(false);
        }

        binding.libraryInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null) {
                    String searchQuery = s.toString();
                    if (!searchQuery.isEmpty()) {
                        viewModel.searchInLibrary(searchQuery, token.getAccessToken());
                    } else {
                        adapter.refresh(new ArrayList<>());
                    }
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void goToLibraryItemFragment(int id){
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);

        navController.navigate(R.id.libraryItemFragment, bundle);
    }

}