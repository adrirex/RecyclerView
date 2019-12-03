package abeltran.example.recyclerview;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class Chronometer extends CountDownTimer {

    private TextView textViewChrono;

    public Chronometer(long millisInFuture, long countDownInterval, TextView textView) {
        super(millisInFuture, countDownInterval);
        textViewChrono = textView;
    }

    @Override
    public void onTick(long l) {

        textViewChrono.setText ("Tiempo restante: " + l / 1000);

    }

    @Override
    public void onFinish() {
        textViewChrono.setText ("Game Over!");
    }

}

