package com.example.everythingapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.everythingapplication.RestAPI.MyRetrofit;
import com.example.everythingapplication.RestAPI.MyRetrofit_Interface;
import com.example.everythingapplication.RestAPI.RestAPI_MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Products_Fragment extends Fragment {

    MyRetrofit_Interface myRetrofit_interface;
    MyRetrofit myRetrofit = new MyRetrofit();
    RecyclerView recyclerView;
    List<ProductsModel> lst;
    ProductsAdapter productsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products_, container, false);
        productsAdapter=new ProductsAdapter(lst,getContext());
        recyclerView=new RecyclerView(view.getContext());
        recyclerView.findViewById(R.id.products_fragment_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(productsAdapter);
        getProductList();
        return view;
    }
    private void getProductList()
    {
        myRetrofit_interface = myRetrofit.getRetrofit().create(MyRetrofit_Interface.class);
        Call<List<ProductsModel>> list = myRetrofit_interface.getProductList();
        list.enqueue(new Callback<List<ProductsModel>>() {
            @Override
            public void onResponse(Call<List<ProductsModel>> call, Response<List<ProductsModel>> response) {
                Log.d("tfgfrdsrh", "onCreate: ");
                lst=response.body();
                if(response.body().size()>0)
                {
                    Log.d("123456", "andr hon: ");
                    List<ProductsModel> list = response.body();
                    //productsAdapter.setProductsModelList(list);
                    productsAdapter.notifyDataSetChanged();
                    Log.d("123456", "andr hon: ");
                    Toast.makeText(getContext(), "Data received Succesfully.", Toast.LENGTH_SHORT).show();
                    for(ProductsModel productsModel : list)
                    {
                        Log.d("Response", "Title: "
                                +productsModel.getTitle()
                                +"Image : " +productsModel.getImage()
                                +"Price : " +productsModel.getPrice()
                                +"Description : " +productsModel.getDescription()
                                +"URL : " +productsModel.getImage()
                        );
                    }
                }

            }
            @Override
            public void onFailure(Call<List<ProductsModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }

}