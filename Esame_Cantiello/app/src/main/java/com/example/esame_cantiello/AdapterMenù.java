package com.example.esame_cantiello;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterMenù extends RecyclerView.Adapter<AdapterMenù.MenuHolder> {
    private List<Menù> lista_menu = new ArrayList<>();
    private AdapterMenù.Toccosingolo listner3;
    private Context context;

    public void setContext(Context context) { this.context = context;}
    @NonNull
    @Override
    public AdapterMenù.MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.riga_scelta_menu, parent, false);
        return new AdapterMenù.MenuHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterMenù.MenuHolder holder, int position) {
        Menù currentMenu = lista_menu.get(position);
        holder.textViewTitle.setText(currentMenu.getNome());
    }


    @Override
    public int getItemCount() {
        return lista_menu.size();
    }


    public void setLista_menu(List<Menù> lista_menu) {
        this.lista_menu = lista_menu;
        notifyDataSetChanged();
    }

    public Menù getMenu(int position) {
        return lista_menu.get(position);
    }



    class MenuHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;

        public MenuHolder(final View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posizione = getAdapterPosition();
                    if (listner3 != null && posizione != RecyclerView.NO_POSITION) {
                        listner3.onItemClick(lista_menu.get(posizione));


                    }


                }


            });




        }
    }
    public interface Toccosingolo {
        void onItemClick(Menù prenotazione);
    }


    public void setOnItemClickListener(AdapterMenù.Toccosingolo listener3) {
        this.listner3 = listener3;
    }
}


