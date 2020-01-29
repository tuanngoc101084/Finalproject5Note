package com.example.finalpro.viewmodel;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;
import java.util.UUID;

public class GetLanguageForText2Speech {
    TextToSpeech textToSpeech;
    Context context;
    Boolean Ready=false;
    public GetLanguageForText2Speech(Context contextInput)
    {
        context= contextInput;
        textToSpeech = new TextToSpeech(contextInput, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
               Set_Language();
            }
        });
        textToSpeech.setSpeechRate(1);
    }
    public void SpeakOut(String inputtext) {
        if(!Ready)
        {
            Toast.makeText(context,"Text to speech not ready",Toast.LENGTH_LONG).show();
            return;
        }
        textToSpeech.speak(inputtext,TextToSpeech.QUEUE_FLUSH,null,UUID.randomUUID().toString());
    }

    public  void SetspeechRate( float speechRate)
    {
        textToSpeech.setSpeechRate(speechRate);
    }
    private void Set_Language()
    {

        int result = textToSpeech.setLanguage(Locale.ENGLISH);
        if (result==TextToSpeech.LANG_MISSING_DATA)
        {
            this.Ready=false;
            Toast.makeText(context,"LANG_MISSING_DATA",Toast.LENGTH_LONG).show();
            return;
        }
        else  if(result==TextToSpeech.LANG_NOT_SUPPORTED)
        {
            this.Ready=false;
            Toast.makeText(context,"LANG_NOT_SUPPORTED",Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            this.Ready=true;
            Locale currentLanguage= textToSpeech.getVoice().getLocale();
            Toast.makeText(context,"Language "+ currentLanguage,Toast.LENGTH_LONG).show();
        }

    }
}
