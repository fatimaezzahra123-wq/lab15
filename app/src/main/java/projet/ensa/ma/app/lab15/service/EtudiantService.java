package projet.ensa.ma.app.lab15.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import projet.ensa.ma.app.lab15.classes.Etudiant;
import projet.ensa.ma.app.lab15.util.MySQLiteHelper;

public class EtudiantService {

    private MySQLiteHelper helper;

    public EtudiantService(Context context) {
        helper = new MySQLiteHelper(context);
    }

    // 🔹 CREATE
    public void create(Etudiant e) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nom", e.getNom());
        values.put("prenom", e.getPrenom());

        long result = db.insert("etudiant", null, values);

        Log.d("INSERT", "Result=" + result + " Nom=" + e.getNom());

        db.close();
    }

    // 🔹 READ ALL
    public List<Etudiant> findAll() {
        List<Etudiant> list = new ArrayList<>();

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM etudiant", null);

        Log.d("DEBUG", "Rows=" + c.getCount());

        if (c.moveToFirst()) {
            do {
                Etudiant e = new Etudiant();
                e.setId(c.getInt(0));
                e.setNom(c.getString(1));
                e.setPrenom(c.getString(2));
                list.add(e);
            } while (c.moveToNext());
        }

        c.close();
        db.close();

        return list;
    }

    // 🔹 FIND BY ID
    public Etudiant findById(int id) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Etudiant e = null;

        Cursor c = db.rawQuery("SELECT * FROM etudiant WHERE id=?",
                new String[]{String.valueOf(id)});

        if (c.moveToFirst()) {
            e = new Etudiant();
            e.setId(c.getInt(0));
            e.setNom(c.getString(1));
            e.setPrenom(c.getString(2));
        }

        c.close();
        db.close();

        return e;
    }

    // 🔹 DELETE
    public void delete(Etudiant e) {
        SQLiteDatabase db = helper.getWritableDatabase();

        db.delete("etudiant", "id=?", new String[]{String.valueOf(e.getId())});

        Log.d("DELETE", "Deleted id=" + e.getId());

        db.close();
    }
}