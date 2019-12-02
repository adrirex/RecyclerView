package abeltran.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar Animes
        List<Cartas> items = new ArrayList<>();

        items.add(new Cartas(R.drawable.c0, R.drawable.back));
        items.add(new Cartas(R.drawable.c1, R.drawable.back));
        items.add(new Cartas(R.drawable.c2, R.drawable.back));
        items.add(new Cartas(R.drawable.c3, R.drawable.back));
        items.add(new Cartas(R.drawable.c4, R.drawable.back));
        items.add(new Cartas(R.drawable.c5, R.drawable.back));
        items.add(new Cartas(R.drawable.c0, R.drawable.back));
        items.add(new Cartas(R.drawable.c1, R.drawable.back));
        items.add(new Cartas(R.drawable.c2, R.drawable.back));
        items.add(new Cartas(R.drawable.c3, R.drawable.back));
        items.add(new Cartas(R.drawable.c4, R.drawable.back));
        items.add(new Cartas(R.drawable.c5, R.drawable.back));

        Collections.shuffle(items);

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new GridLayoutManager(this, 3);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new CartasAdapter(items, this);
        recycler.setAdapter(adapter);

    }
}
