package com.example.dainr.discoverjamaica;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link PhraseAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Phrases} objects.
 */
public class PhraseAdapter extends ArrayAdapter<Phrases>  {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link PhraseAdapter} object.
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param phrases is the list of {@link Phrases}s to be displayed.
     */
    PhraseAdapter(Context context, ArrayList <Phrases> phrases) {
        super(context, 0, phrases);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.language_list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Phrases currentPhrase = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView patoisTextView = (TextView) listItemView.findViewById(R.id.patois_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        assert currentPhrase != null;
        patoisTextView.setText(currentPhrase.getPatoisTranslationId());

        // Find the TextView in the language_list_item.xml layout with the ID english_text_view.
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the english TextView.
        englishTextView.setText(currentPhrase.getEnglishTranslationId());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_list_item);
        // Check if an image is provided for this word or not
        if (currentPhrase.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPhrase.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}