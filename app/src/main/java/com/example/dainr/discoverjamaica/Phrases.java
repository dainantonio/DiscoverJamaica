
/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.dainr.discoverjamaica;

/**
 * {@link Phrases} represents a vocabulary word or phrase that the user wants to learn.
 * It contains resource IDs for the default translation, patois translation, audio file, and
 * optional image file for that word.
 */
public class Phrases {

    /** String resource ID for the english translation of the word */
    private final String mEnglishTranslationId;

    /** String resource ID for the patois translation of the word */
    private final String mPatoisTranslationId;

    /** Audio resource ID for the word */
    private final int mAudioResourceId;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object.
     * @param englishTranslationId is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param patoisTranslationId is the string resource Id for the word in the Miwok language
     * @param audioResourceId is the resource ID for the audio file associated with this word
     */
    Phrases(String englishTranslationId, String patoisTranslationId, int audioResourceId) {
              mEnglishTranslationId = englishTranslationId;
              mPatoisTranslationId = patoisTranslationId;
              mAudioResourceId = audioResourceId;
          }

         /**
     *      * Create a new Phrase object.
     *
     * @param englishTranslationId = is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param patoisTranslationId is the string resource Id for the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     * @param audioResourceId is the resource ID for the audio file associated with this word
     */
    public Phrases(String englishTranslationId, String patoisTranslationId, int imageResourceId,
                int audioResourceId) {
        mEnglishTranslationId = englishTranslationId;
        mPatoisTranslationId = patoisTranslationId;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the string resource ID for the english translation of the word.
     */
    String getEnglishTranslationId() {
        return mEnglishTranslationId;
    }

    /**
     * Get the string resource ID for the patois translation of the word.
     */
    String getPatoisTranslationId() {
        return mPatoisTranslationId;
    }

    /**
     * Return the image resource ID of the word.
     */
    int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the audio resource ID of the word.
     */
    int getAudioResourceId() {
        return mAudioResourceId;
    }
}