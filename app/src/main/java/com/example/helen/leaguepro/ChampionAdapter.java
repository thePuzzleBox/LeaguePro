package com.example.helen.leaguepro;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ChampionAdapter extends BaseAdapter {

    private final Context mContext;
    public final Champion[] champions;
    MediaPlayer mp;

    // 1
    public ChampionAdapter(Context context, Champion[] champions) {
        this.mContext = context;
        this.champions = champions;
    }

    // 2
    @Override
    public int getCount() {
        return champions.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Champion champ = champions[position];


        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_champion, null);
        }

        final ImageView imageView = convertView.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = convertView.findViewById(R.id.textview_champ_name);
        final ImageView imageViewFavorite = convertView.findViewById(R.id.imageview_favorite);

        imageView.setImageResource(champ.getImageResource());   //  Sets the ImageView to Champion Icon
        nameTextView.setText(champ.getName());                  // Sets TextView to Champion Name




        // Separate onClickListener for Favorite function within grid cell.

        imageViewFavorite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                champ.toggleFavorite();     // Sets the image to the opposite of current state on click

                imageViewFavorite.setImageResource(champ.getIsFavorite() ? R.drawable.star_enabled : R.drawable.star_disabled);



                if(champ.getIsFavorite() == true){          //  Plays UI sound
                    mp = MediaPlayer.create(mContext, R.raw.ping);
                    mp.start();
                    Toast.makeText(mContext,"Champion Favorited!", Toast.LENGTH_SHORT).show();
                }

                else{
                    MediaPlayer undo = MediaPlayer.create(mContext, R.raw.g);
                    undo.start();
                }

            }
        });

        return convertView;
    }
}

