package com.example.himymcharacters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder> {
    private Context context;
    private List<HIMYMCharacter> characters;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;

    public CharactersAdapter(Context context, List<HIMYMCharacter> characters, OnItemClickListener listener) {
        this.context = context;
        this.characters = characters;
        this.inflater = LayoutInflater.from(context);
        this.onItemClickListener = listener;
    }



    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.character_item, parent, false);
        return new CharacterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        HIMYMCharacter currentCharacter = characters.get(position);
        holder.characterName.setText(currentCharacter.getName());
        holder.characterDescription.setText(currentCharacter.getDescription());
        holder.characterImage.setImageResource(currentCharacter.getImageResourceId());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(currentCharacter);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
    public static class CharacterViewHolder extends RecyclerView.ViewHolder {
        public ImageView characterImage;
        public TextView characterName, characterDescription;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            characterImage = itemView.findViewById(R.id.characterImage);
            characterName = itemView.findViewById(R.id.characterName);
            characterDescription = itemView.findViewById(R.id.characterDescription);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(HIMYMCharacter character);
    }
}