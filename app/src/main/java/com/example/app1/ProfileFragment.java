package com.example.app1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView user,account, address,address_field,locality_field,pincode_field;
    Button editbtn;
    LinearLayout user_data,account_data, address_data;
    Dialog dialog;
    Bitmap bitmapImage;
    ImageView upload,profile_image;

    public ProfileFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        user = rootView.findViewById(R.id.user);
        user_data = rootView.findViewById(R.id.user_data);
        account = rootView.findViewById(R.id.account);
        account_data = rootView.findViewById(R.id.account_data);
        address = rootView.findViewById(R.id.Address);
        address_data = rootView.findViewById(R.id.address_data);
        address_field = rootView.findViewById(R.id.address_field);
        locality_field = rootView.findViewById(R.id.locality);
        upload = rootView.findViewById(R.id.upload);
        pincode_field = rootView.findViewById(R.id.pincode);
        editbtn = rootView.findViewById(R.id.editbtn);
        profile_image = rootView.findViewById(R.id.image);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getImage(101);
            }
        });
        editbtn.setOnClickListener(new View.OnClickListener() {
            TextView edit_address,edit_locality,edit_pincode;
            Button save;
            @Override
            public void onClick(View v) {
                dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.edit_dialog);
                dialog.setCancelable(true);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                dialog.getWindow().getAttributes().windowAnimations = R.style.Theme_App1;
                dialog.getWindow().setBackgroundDrawableResource(android.R.drawable.screen_background_light_transparent);
                dialog.show();
                edit_address = dialog.findViewById(R.id.edit_address);
                edit_locality = dialog.findViewById(R.id.edit_locality);
                edit_pincode = dialog.findViewById(R.id.edit_pincode);
                save = dialog.findViewById(R.id.editbtn);

            }
        });
        if (user_data != null) {
            user_data.setVisibility(View.GONE);

            user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (user_data.getVisibility() == View.GONE) {
                        user_data.setVisibility(View.VISIBLE);
                        account_data.setVisibility(View.GONE);
                        address_data.setVisibility(View.GONE);
                    } else {
                        user_data.setVisibility(View.GONE);
                    }
                }
            });
        }
        if (account_data != null) {
            account_data.setVisibility(View.GONE);
            account.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (account_data.getVisibility() == View.GONE) {
                        account_data.setVisibility(View.VISIBLE);
                        user_data.setVisibility(View.GONE);
                        address_data.setVisibility(View.GONE);
                    } else {
                        account_data.setVisibility(View.GONE);
                    }
                }
            });
        }
        if (address_data != null) {
            address_data.setVisibility(View.GONE);

            address.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (address_data.getVisibility() == View.GONE) {
                        address_data.setVisibility(View.VISIBLE);
                        user_data.setVisibility(View.GONE);
                        account_data.setVisibility(View.GONE);
                    } else {
                        address_data.setVisibility(View.GONE);
                    }
                }
            });
        }
        return rootView;
    }
    public void getImage(int code){




//        ImagePicker.Companion.with(this)
//                .crop()	    			//Crop image(Optional), Check Customization for more option
//                .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
//                .start(code);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == Activity.RESULT_OK){
            Uri returnUri = data.getData();


            try {
                bitmapImage = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),returnUri);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            profile_image.setImageBitmap(bitmapImage);
        }


    }
}