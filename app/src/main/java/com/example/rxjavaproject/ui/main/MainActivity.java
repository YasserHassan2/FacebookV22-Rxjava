package com.example.rxjavaproject.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rxjavaproject.R;
import com.example.rxjavaproject.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostViewModel postViewModel;
    RecyclerView recyclerView;
    PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        postViewModel.getPosts();
        recyclerView = findViewById(R.id.recyclerView);
        postsAdapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postsAdapter);

        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postsAdapter.setList(postModels);
            }
        });





    }
}
