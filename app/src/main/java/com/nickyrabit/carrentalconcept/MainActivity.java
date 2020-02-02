package com.nickyrabit.carrentalconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import com.shawnlin.numberpicker.NumberPicker;

public class MainActivity extends AppCompatActivity {
     ImageSwitcher imageSwitcher;
     boolean firstImage;
Button button;
    NumberPicker numberPicker;

    private Handler imageSwitchHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher = findViewById(R.id.imageSwitcherView);

        numberPicker = (NumberPicker) findViewById(R.id.horizontal_number_picker);

        // Set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
// TODO Auto-generated method stub

// Create a new ImageView and set it's properties
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });

        firstImage = true;

        button = findViewById(R.id.button);
        Animation imgAnimationIn =  AnimationUtils.
                loadAnimation(this,   R.anim.in_animation);
        imageSwitcher.setInAnimation(imgAnimationIn);

        Animation imgAnimationOut =  AnimationUtils.
                loadAnimation(this,   R.anim.out_animation);
        imageSwitcher.setOutAnimation(imgAnimationOut);






        // Using string values
// IMPORTANT! setMinValue to 1 and call setDisplayedValues after setMinValue and setMaxValue
        String[] data = {"4 Seater", "5 Seater", "7 Seater", "8 Seater"};
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(data.length);
        numberPicker.setDisplayedValues(data);
        numberPicker.setValue(2);





button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        imageSwitcher.setImageDrawable(getResources().getDrawable(R.drawable.audi_a8));

    }
});


   }


}
