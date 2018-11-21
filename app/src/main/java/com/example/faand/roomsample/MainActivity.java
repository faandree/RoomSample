package com.example.faand.roomsample;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.faand.roomsample.DB.MyDB;
import com.example.faand.roomsample.Entities.Contact;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button bt;

    int counter;

    private MyDB myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tv = (TextView) findViewById(R.id.textview1);
        this.bt = (Button) findViewById(R.id.button1);

        this.counter = 0;

        this.myDatabase = Room.databaseBuilder(getApplicationContext(), MyDB.class, "sampleDatabase").build();

        this.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact c = new Contact();
                c.name = "custom"+counter;
                c.number = counter + "";

                InsertDBAsyncTask background = new InsertDBAsyncTask();
                background.execute(c);
            }
        });

        //AsyncTask<Void,Void,Void>.execute();
    }

    public class InsertDBAsyncTask extends AsyncTask<Contact,Integer,Contact[]>{

        @Override
        protected Contact[] doInBackground(Contact... contacts) {


            myDatabase.daoAcess().insertContact(contacts);
            return myDatabase.daoAcess().loadAllContacts();

        }

        @Override
        public void onPostExecute(Contact[] c){
            String resp = new String();
            for(Contact temp : c){
                resp += temp.name + ":" + temp.number+"\n";
            }
            tv.setText(resp);
        }
    }


}
