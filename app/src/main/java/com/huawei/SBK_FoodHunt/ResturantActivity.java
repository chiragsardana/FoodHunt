package com.huawei.SBK_FoodHunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;


public class ResturantActivity extends AppCompatActivity {
    
    private static final String TAG = "FarmActivity";
    public static final String FARM_KEY = "farmKey";

    private TextView name, owner, description;
    private ImageView farmImage;
    private Button viewLocationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_farm);
        initViews();

        // set data
        Intent intent = getIntent();
        if (null != intent) {
            int farmId = intent.getIntExtra(FARM_KEY, -1);
            Log.d(TAG, "onCreate: called");
            if (farmId != -1) {
                Resturant selectedResturant = Data.getInstance().getFarmById(farmId);
                if (null != selectedResturant) {
                    setData(selectedResturant);
                    onClickLocationButton(selectedResturant);
                }
            }
        }

    }

    private void onClickLocationButton(Resturant resturant) {
        viewLocationButton.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MapActivity.class);
            intent1.putExtra(FARM_KEY, resturant.getId());
            startActivity(intent1);
        });
    }

    private void initViews() {
        name = findViewById(R.id.name);
        owner = findViewById(R.id.owner);
        description = findViewById(R.id.description);
        farmImage = findViewById(R.id.farmImage);
        viewLocationButton = findViewById(R.id.viewLocation);
    }

    private void setData(Resturant resturant) {
        name.setText(resturant.getName());
        String ownerText = resturant.getOwner();
        owner.setText(ownerText);
        description.setText(resturant.getDescription());
        Glide.with(this).asBitmap().load(resturant.getImageUrl()).into(farmImage);
    }


}