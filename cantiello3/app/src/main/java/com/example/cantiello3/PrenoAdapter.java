package com.example.cantiello3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PrenoAdapter extends RecyclerView.Adapter<PrenoAdapter.PrenoHolder> {

    private List<Prenotazione> prenotationes = new ArrayList<>();
    private Toccosingolo listener;
    private Toccoprolungato listener2;


    @NonNull
    @Override
    public PrenoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_prenotazione, parent, false);
        return new PrenoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PrenoHolder holder, int position) {
        Prenotazione currentPrenotazione = prenotationes.get(position);
        holder.nome_cliente.setText(currentPrenotazione.getNomecliente());
        holder.data.setText(currentPrenotazione.getDataevento());
        holder.tipo_evento.setText(currentPrenotazione.getTipo_di_festa());
    }

    @Override
    public int getItemCount() {
        return prenotationes.size();
    }

    public void setPrenotationes(List<Prenotazione> prenotationes) {
        this.prenotationes = prenotationes;
        notifyDataSetChanged();
    }

    public Prenotazione getPrenoAt(int position) {
        return prenotationes.get(position);
    }

    class PrenoHolder extends RecyclerView.ViewHolder {
        private TextView nome_cliente;
        private TextView tipo_evento;
        private TextView data;

        public PrenoHolder(View itemView) {
            super(itemView);
            nome_cliente = itemView.findViewById(R.id.text_view_title);
            tipo_evento = itemView.findViewById(R.id.text_view_categoria);
            data = itemView.findViewById(R.id.text_view_priority);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(prenotationes.get(position));
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int posizione = getAdapterPosition();
                    if (listener2 != null && posizione != RecyclerView.NO_POSITION) {
                        listener2.onItemClick(prenotationes.get(posizione));
                    }
                    return false;
                }
            });
        }
    }

    public interface Toccosingolo {
        void onItemClick(Prenotazione prenotazione);
    }
    public interface Toccoprolungato {
        void onItemClick(Prenotazione prenotazione);
    }
    public void setOnItemClickListner(Toccosingolo listener) {
        this.listener = listener;
    }
    public void setOnItemClickListner(Toccoprolungato listener2) {
        this.listener2 = listener2;
    }
}
