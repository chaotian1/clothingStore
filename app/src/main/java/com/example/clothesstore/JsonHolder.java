package com.example.clothesstore;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonHolder {
    @GET("products")
    Call<List<RetrofitCore>> getAllProducts();

    @GET("products/productId")
    Call<List<RetrofitCore>> retrieveProduct();

    @FormUrlEncoded
    @POST("cart")
    Call<List<RetrofitCore>> addProductToCart(  @Field("productId")int productId);

    @DELETE("cart/cartId")
    Call<List<RetrofitCore>> removeProductFromCart();

}
