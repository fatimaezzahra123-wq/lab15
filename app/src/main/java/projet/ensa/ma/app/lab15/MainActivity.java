package projet.ensa.ma.app.lab15;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import projet.ensa.ma.app.lab15.classes.Etudiant;
import projet.ensa.ma.app.lab15.service.EtudiantService;

public class MainActivity extends AppCompatActivity {

    private EditText nom, prenom, id;
    private Button add, rechercher, supprimer;
    private TextView res;

    void clear() {
        nom.setText("");
        prenom.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtudiantService es = new EtudiantService(this);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        add = findViewById(R.id.bn);

        id = findViewById(R.id.id);
        rechercher = findViewById(R.id.load);
        supprimer = findViewById(R.id.delete);
        res = findViewById(R.id.res);

        // 🔹 AJOUT
        add.setOnClickListener(v -> {
            String n = nom.getText().toString().trim();
            String p = prenom.getText().toString().trim();

            if (n.isEmpty() || p.isEmpty()) {
                Toast.makeText(this, "Remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }

            es.create(new Etudiant(n, p));
            clear();

            Toast.makeText(this, "Étudiant ajouté", Toast.LENGTH_SHORT).show();
        });

        // 🔹 CHERCHER
        rechercher.setOnClickListener(v -> {
            String txt = id.getText().toString().trim();

            if (txt.isEmpty()) {
                Toast.makeText(this, "Saisir un id", Toast.LENGTH_SHORT).show();
                return;
            }

            Etudiant e = es.findById(Integer.parseInt(txt));

            if (e == null) {
                res.setText("");
                Toast.makeText(this, "Introuvable", Toast.LENGTH_SHORT).show();
                return;
            }

            res.setText(e.getNom() + " " + e.getPrenom());
        });

        // 🔹 SUPPRIMER
        supprimer.setOnClickListener(v -> {
            String txt = id.getText().toString().trim();

            if (txt.isEmpty()) {
                Toast.makeText(this, "Saisir un id", Toast.LENGTH_SHORT).show();
                return;
            }

            Etudiant e = es.findById(Integer.parseInt(txt));

            if (e == null) {
                Toast.makeText(this, "Aucun étudiant", Toast.LENGTH_SHORT).show();
                return;
            }

            es.delete(e);
            res.setText("");

            Toast.makeText(this, "Supprimé", Toast.LENGTH_SHORT).show();
        });
    }
}