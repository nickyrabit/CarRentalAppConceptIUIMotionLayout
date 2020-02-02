package com.nickyrabit.carrentalconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;
import com.shawnlin.numberpicker.NumberPicker;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
     ImageSwitcher imageSwitcher;
     boolean firstImage;
Button button;
    NumberPicker numberPicker;
    TextView carNameTextView;
TickerView numberEurosTextView;
    private Handler imageSwitchHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher = findViewById(R.id.imageSwitcherView);

        numberPicker = (NumberPicker) findViewById(R.id.horizontal_number_picker);
        numberEurosTextView = findViewById(R.id.numberEurosTextView);
        numberEurosTextView.setCharacterLists(TickerUtils.provideNumberList());
        carNameTextView = findViewById(R.id.carNameTextView);

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

        //button = findViewById(R.id.button);
        Animation imgAnimationIn =  AnimationUtils.
                loadAnimation(this,   R.anim.in_animation);
        imageSwitcher.setInAnimation(imgAnimationIn);

        Animation imgAnimationOut =  AnimationUtils.
                loadAnimation(this,   R.anim.out_animation);
        imageSwitcher.setOutAnimation(imgAnimationOut);

        numberEurosTextView.setAnimationDuration(500);
        numberEurosTextView.setAnimationInterpolator(new OvershootInterpolator());
        numberEurosTextView.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);




        // Using string values
// IMPORTANT! setMinValue to 1 and call setDisplayedValues after setMinValue and setMaxValue
        final String[] data = {"4 Seater", "5 Seater", "7 Seater", "8 Seater"};
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(data.length);
        numberPicker.setDisplayedValues(data);
        numberPicker.setValue(2);

        // OnValueChangeListener
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.d("TAGG", String.format(Locale.US, "oldVal: %d, newVal: %d", oldVal, newVal));
                Log.d("TAGG", String.format(Locale.US, "GET VALUE : "+ picker.getValue()));
                int selected =picker.getValue();
                if(selected==1){
                    numberEurosTextView.setText("200");
                    imageSwitcher.setImageDrawable(getResources().getDrawable(R.drawable.audi_a8));
                    carNameTextView.setText("Audi A8");
                }else if(selected==2){
                    numberEurosTextView.setText("310");
                    imageSwitcher.setImageDrawable(getResources().getDrawable(R.drawable.bmw_black_design));
                    carNameTextView.setText("BMW Black Design");
                }else if(selected==3)
                {
                    numberEurosTextView.setText("180");
                    imageSwitcher.setImageDrawable(getResources().getDrawable(R.drawable.mercedes_s_class));
                    carNameTextView.setText("Mercedes S Class");
                }else if(selected==4){

                    numberEurosTextView.setText("310");
                    imageSwitcher.setImageDrawable(getResources().getDrawable(R.drawable.bmw_black_design));
                    carNameTextView.setText("BMW Black Design");

                }

            }
        });



        //set default
        numberEurosTextView.setText("200");
        carNameTextView.setText("Audi A8");
        imageSwitcher.setImageDrawable(getResources().getDrawable(R.drawable.audi_a8));




   }


}
