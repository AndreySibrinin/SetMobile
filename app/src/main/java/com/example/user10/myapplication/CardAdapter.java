package com.example.user10.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.NumberViewHolder> {


    private int CardItems;
    private ArrayList<Card> cards;
    private Context parent;
 //   private HashMap<Integer, Card> listE = new HashMap<>();
    private boolean[] selects;

//    public HashMap<Integer, Card> getListE() {
//        return listE;
//    }

    public CardAdapter(ArrayList<Card> cards, Context ContextParent){
        this.CardItems = cards.size();
        this.cards = cards;
        this.parent = ContextParent;
        this.selects = new boolean[CardItems];
    }





    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.cards_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem,viewGroup,false);
        NumberViewHolder viewHolder = new NumberViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int i) {
        numberViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return this.CardItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder{
        TextView listItemNumberView;



        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemNumberView = itemView.findViewById(R.id.card_item);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();

                        Toast toast = Toast.makeText(parent,"Element" + position + "was clicked",Toast.LENGTH_SHORT);
                        toast.show();
                        if(selects[position]) {
                            selects[position] = false;
                         //   listE.remove(position);

                                                }
                        else {
                            selects[position] = true;
                            // listE.put(position,cards.get(position));
                        }
                        if(selects[position])
                            listItemNumberView.setBackgroundColor(Color.LTGRAY);
                        else
                            listItemNumberView.setBackgroundColor(Color.TRANSPARENT);
                    }
                });
        }
        void bind(int listIndex){
            listItemNumberView.setText("Count: " + String.valueOf(cards.get(listIndex).getCount())+"\n"
                    + "Color: " + String.valueOf(cards.get(listIndex).getColor()) +"\n"
                    + "Shape: "+ String.valueOf(cards.get(listIndex).getShape())+ "\n"
                    + "Fill: "+String.valueOf(cards.get(listIndex).getFill()));



        }
    }
}
