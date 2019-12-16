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

public class AdapterPrenotazione extends RecyclerView.Adapter<AdapterPrenotazione.PrenobHolder> {
    private List<Prenotazione> lista_prenotazioni = new ArrayList<>();
    private Context context;
    private Toccosingolo listner3;

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PrenobHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.riga_layout, parent, false);
        return new PrenobHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull PrenobHolder holder, int position) {
        Prenotazione currentPrenotazione = lista_prenotazioni.get(position);
        holder.textViewTitle.setText(currentPrenotazione.getNome());
        holder.textViewCategoria.setText((currentPrenotazione.getTipo_menu()));
        holder.textViewData.setText((currentPrenotazione.getData()));
    }


    @Override
    public int getItemCount() {
        return lista_prenotazioni.size();
    }


    public void setLista_prenotazioni(List<Prenotazione> lista_prenotazioni) {
        this.lista_prenotazioni = lista_prenotazioni;
        notifyDataSetChanged();
    }

    public  Prenotazione getPreno(int position) {
        return lista_prenotazioni.get(position);
    }

    class PrenobHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewCategoria;
        private TextView textViewData;


        public PrenobHolder(final View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewData = itemView.findViewById(R.id.text_view_priority);
            textViewCategoria = itemView.findViewById(R.id.text_view_categoria);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posizione = getAdapterPosition();
                    if (listner3 != null && posizione != RecyclerView.NO_POSITION) {
                        listner3.onItemClick(lista_prenotazioni.get(posizione));


                    }


                }


            });




        }
    }


    public interface Toccosingolo {
        void onItemClick(Prenotazione prenotazione);
    }


    public void setOnItemClickListener(Toccosingolo listener3) {
        this.listner3 = listener3;
    }
}


