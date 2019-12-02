package abeltran.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import abeltran.example.recyclerview.Cartas;
import abeltran.example.recyclerview.R;

public class CartasAdapter extends RecyclerView.Adapter<CartasAdapter.CartasViewHolder> {

    private List<Cartas> items;
    private Context context;
    int contador = 0;
    int cartaPrimera = 0;
    int cartaGirada = 0;
    boolean noMeToques = false;
    int aciertos;
    boolean starting = true;
    int time = 30;
    CountDownTimer ct;
    TextView textTimer;

    public CartasAdapter(List<Cartas> items, Context context) {
        this.items = items;
        this.context = context;
    }

    public  class CartasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //        // Campos respectivos de un item
        public ImageView imagen;

        public CartasViewHolder(View v) {
            super(v);
            imagen = v.findViewById(R.id.imagen);
            imagen.setOnClickListener(this);
        }

        @SuppressLint("WrongConstant")
        @Override
        public void onClick(View v) {
            //if(starting){
            //    starting = false;
            //  ct = new CountDownTimer(30000,1000) {
            //      @Override
            //      public void onTick(long millisUntilFinished) {
            //          time--;
            //          textTimer.setText(String.valueOf(time));
            //      }

            //      @Override
            //      public void onFinish() {
            //          Toast.makeText(context, "GAME OVER", Toast.LENGTH_SHORT).show();
            //      }
            //  }.start();
            //}
            if(!noMeToques) {
            if(contador < 2 && items.get(getAdapterPosition()).getEstado() == Cartas.Estat.BACK) {
                cartaGirada = getAdapterPosition();
                items.get(cartaGirada).girar();
                notifyDataSetChanged();
                contador += 1;
            }
            if(contador == 1){
                cartaPrimera = cartaGirada;
            }
            if(contador == 2){
                if(items.get(cartaPrimera).getImagen() == items.get(cartaGirada).getImagen()){
                    contador = 0;
                    aciertos++;
                    if(aciertos == (items.size()) / 2){
                        Toast.makeText(context, "ENHORABUENA HAS GANADO!",Toast.LENGTH_SHORT).show();
                        noMeToques = true;
                        //ct.cancel();
                    }
                }
                else {
                    noMeToques = true;
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.get (cartaPrimera).girar();
                            items.get (cartaGirada).girar();
                            notifyDataSetChanged();
                            contador = 0;
                            noMeToques = false;
                        }
                    }, 2000);
                }
            }
        }}
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public CartasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cartas, viewGroup, false);
        return new CartasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CartasViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
    }
}
