package id.sch.smktelkom_mlg.tugas01.xiirpl3015.basicregistrationform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout lhasil;
    EditText nama, perwakilan;
    Spinner kelas;
    RadioGroup STJ;
    RadioButton STJ_ya, STJ_tidak;
    CheckBox futsal, karung, basket, tariktambang, voli, english, agree;
    Button regis, proses;
    TextView hasil_nama, hasil_kelas, hasil_lomba, hasil_wakil, sukses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText) findViewById(R.id.editTextNama);
        kelas = (Spinner) findViewById(R.id.spinnerKelas);
        futsal = (CheckBox) findViewById(R.id.checkBoxFutsal);
        karung = (CheckBox) findViewById(R.id.checkBoxKarung);
        basket = (CheckBox) findViewById(R.id.checkBoxBasket);
        tariktambang = (CheckBox) findViewById(R.id.checkBoxTarik);
        voli = (CheckBox) findViewById(R.id.checkBoxVoli);
        english = (CheckBox) findViewById(R.id.checkBoxEng);
        perwakilan = (EditText) findViewById(R.id.editTextPerwakilan);
        STJ = (RadioGroup) findViewById(R.id.RadioGroup1);
        regis = (Button) findViewById(R.id.buttonRegis);
        lhasil = (LinearLayout) findViewById(R.id.LinearLayoutm);
        hasil_nama = (TextView) findViewById(R.id.tvNama);
        hasil_kelas = (TextView) findViewById(R.id.tvKelas);
        hasil_lomba = (TextView) findViewById(R.id.tvLomba);
        hasil_wakil = (TextView) findViewById(R.id.tvPerwakilan);
        agree = (CheckBox) findViewById(R.id.CheckBoxAgree);
        proses = (Button) findViewById(R.id.ButtonProses);
        sukses = (TextView) findViewById(R.id.textViewSukses);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nama.getText().toString().equals("")
                        || perwakilan.getText().toString().equals("")
                        || STJ.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Masih Ada Field Yang Belum Terisikan", Toast.LENGTH_SHORT).show();
                } else if (!basket.isChecked()
                        && !tariktambang.isChecked()
                        && !voli.isChecked()
                        && !english.isChecked()
                        && !futsal.isChecked()
                        && !karung.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Anda Belum Memilih Perlombaan", Toast.LENGTH_SHORT).show();
                } else {
                    lhasil.setVisibility(View.VISIBLE);
                    lhasil.setFocusableInTouchMode(true);
                    lhasil.requestFocus();
                    hasil_nama.setText(nama.getText().toString());
                    hasil_kelas.setText(kelas.getSelectedItem().toString());
                    hasil_lomba.setText(setLomba());
                }
            }
        });
        proses.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!agree.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Anda Belum Mencentang Persetujuan", Toast.LENGTH_LONG).show();
                } else {
                    lhasil.setVisibility(View.GONE);
                    sukses.setVisibility(View.VISIBLE);
                    sukses.setFocusableInTouchMode(true);
                    sukses.requestFocus();
                    clearField();
                }
            }
        });
    }

    private void clearField() {
        nama.setText("");
        kelas.setSelection(0);
        perwakilan.setText("");
        STJ.clearCheck();
        futsal.setChecked(false);
        karung.setChecked(false);
        basket.setChecked(false);
        tariktambang.setChecked(false);
        voli.setChecked(false);
        english.setChecked(false);
    }

    private String setLomba() {
        String lomba = "";
        if (futsal.isChecked()) {
            lomba += "Futsal, ";
        }
        if (karung.isChecked()) {
            lomba += "Balap Karung, ";
        }
        if (basket.isChecked()) {
            lomba += "Bola Basket, ";
        }
        if (tariktambang.isChecked()) {
            lomba += "Tarik Tambang, ";
        }
        if (voli.isChecked()) {
            lomba += "Bola Voli, ";
        }
        if (english.isChecked()) {
            lomba += "English Debate. ";
        }

        return lomba;
    }
}
