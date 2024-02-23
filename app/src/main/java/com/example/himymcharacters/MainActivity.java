package com.example.himymcharacters;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CharactersAdapter adapter;
    private List<HIMYMCharacter> characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.characterRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        characterList = new ArrayList<>();
        characterList.add(new HIMYMCharacter("Ted Mosby", "Architect and professor, searching for true love.", R.drawable.ted));
        characterList.add(new HIMYMCharacter("Barney Stinson", "A serial womanizer, famous for his catchphrase 'Suit up!'.", R.drawable.barney));
        characterList.add(new HIMYMCharacter("Robin Scherbatsky", "Canadian journalist and love interest of Ted.", R.drawable.robin));
        characterList.add(new HIMYMCharacter("Marshall Eriksen", "Lawyer with a big heart and Ted's college friend.", R.drawable.marshall));
        characterList.add(new HIMYMCharacter("Lily Aldrin", "Kindergarten teacher and Marshall's wife, known for her quirky personality.", R.drawable.lily));
        characterList.add(new HIMYMCharacter("Tracy McConnell", "The Mother, whose story is a mystery for much of the series.", R.drawable.tracy));
        characterList.add(new HIMYMCharacter("Ranjit", "The gang's favorite taxi/limo driver from Bangladesh.", R.drawable.ranjit));
        characterList.add(new HIMYMCharacter("Patrice", "Robin's coworker who is overly enthusiastic about everything.", R.drawable.patrice));
        characterList.add(new HIMYMCharacter("Victoria", "One of Ted's girlfriends known for her baking skills.", R.drawable.victoria));
        characterList.add(new HIMYMCharacter("The Captain", "Zoey's ex-husband, a boisterous and eccentric man.", R.drawable.captain));
        characterList.add(new HIMYMCharacter("Zoey Pierson", "An activist and Ted's ex-girlfriend.", R.drawable.zoey));


        adapter = new CharactersAdapter(this, characterList, new CharactersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(HIMYMCharacter character) {
                showCharacterDetailsPopup(character);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void showCharacterDetailsPopup(HIMYMCharacter character) {

        LayoutInflater inflater = LayoutInflater.from(this);
        View popupView = inflater.inflate(R.layout.character_item, null);

        ImageView imageView = popupView.findViewById(R.id.characterImage);
        imageView.setImageResource(character.getImageResourceId());
        TextView nameView = popupView.findViewById(R.id.characterName);
        nameView.setText(character.getName());
        TextView descriptionView = popupView.findViewById(R.id.characterDescription);
        descriptionView.setText(character.getDescription());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(popupView);
        builder.setPositiveButton("Close", (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}