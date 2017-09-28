package com.example.mwidlok.realmsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mwidlok.realmsample.model.Person;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class RealmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Realm intialisieren
        Realm.init(this);

        // Instanz von Realm erhalten (mit default Konfiguration)
        // Name von Realm mit default Konfiguration: default.realm in Context.getFilesDir()
        Realm realm = Realm.getDefaultInstance();

        //Alternativ: Instanziiere Realm mit custom Konfiguration (synchron)

        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myRealmDb.realm")
                .schemaVersion(42)
                .build();

        Realm myRealm = Realm.getInstance(config);

        // mehrere Konfigurationen möglich..

        // den Pfad der Realm Datenbank erhalten
        Log.i("Realm-Info","Path of db is " + realm.getPath());

        // Transaktion beginnen
        realm.beginTransaction();

        // Datensatz anlegen
        Person p1 = new Person(1,"John","Doe",42);
        Person p2 = new Person(2,"Jane","Doe",34);

        // Daten an Realm senden
        realm.copyToRealm(p1);
        realm.copyToRealm(p2);

        // Datenbank-Read

        RealmResults<Person> realmResult = realm.where(Person.class).lessThan("Age",43).findAll();

        for (Person p : realmResult)
        {
            Log.i("Realm-Info","Current person is " + p.getFristname() + " " + p.getLastName());
        }

        realm.close();
    }
}
