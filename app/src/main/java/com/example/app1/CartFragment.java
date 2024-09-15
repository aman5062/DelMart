package com.example.app1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button remove,order;
    ImageView cart_image,cart_minus,cart_plus;
    LinearLayout box;
    String quantity = "1";
    TextView product_name,cart_price,cart_quantity;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);
        remove = rootView.findViewById(R.id.remove);
        box = rootView.findViewById(R.id.box);
        order = rootView.findViewById(R.id.order);
        cart_image = rootView.findViewById(R.id.cart_image);
        cart_price = rootView.findViewById(R.id.cart_price);
        product_name = rootView.findViewById(R.id.product_name);
        cart_quantity = rootView.findViewById(R.id.cart_quantity);
        cart_minus = rootView.findViewById(R.id.cart_minus);
        cart_plus = rootView.findViewById(R.id.cart_plus);

        cart_quantity.setText(quantity);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                box.setVisibility(View.GONE);
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), Product_Details.class);
//                intent.putExtra("Product_image",cart_image.getDrawable().toString());
//                intent.putExtra("Product_name",product_name.getText());
//                intent.putExtra("price",cart_price.getText());
//                intent.putExtra("discription","");
//                intent.putExtra("rating",String.valueOf(4.5));
//                startActivity(intent);
            }
        });
        cart_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = String.valueOf(Integer.parseInt(quantity)+1);
                cart_quantity.setText(quantity);
            }
        });
        cart_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = String.valueOf(Integer.parseInt(quantity)-1);
                cart_quantity.setText(quantity);
            }
        });

        return rootView;


    }
}