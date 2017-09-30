package anis.tuggas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /// BUAT 2 VARIABEL STRING SEBAGAI KUNCI UNTUK MENGIRIM DATA

    public static String KEY_Nama = "Nama";
    public static String KEY_prody = "prody";
    public static String KEY_fak = "fak";
    public static String KEY_Alamat = "Alamat";
    public static String KEY_Nope = "Nope";
    public static String KEY_Npm = "Npm";

    /// BUAT VARIABEL 2 EDITTEXT & 1 BUTTON

    EditText Nama;
    EditText prody;
    EditText fak;
    EditText Alamat;
    EditText Nope;
    EditText Npm;

    Button kirimData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// MELAKUKAN INISIALISASI EDITTEXT & BUTTON DENGAN ID YANG KITA TELAH TAMBAH DI XML

        Nama = (EditText) findViewById(R.id.inputNama);
        Alamat = (EditText) findViewById(R.id.inputAlamat);
        prody = (EditText) findViewById(R.id.inputProdi);
        fak = (EditText) findViewById(R.id.inputFak);
        Nope = (EditText) findViewById(R.id.inputHp);
        Npm = (EditText) findViewById(R.id.inputNpm);

        kirimData = (Button) findViewById(R.id.kirimData);

        /// MENAMBAHKAN LISTENER PADA BUTTON AGAR MENANGKAP EVENT SAAT DI KLIK

        kirimData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /// MENGAMBIL INPUTAN DARI EDITTEXT YANG AKAN DI KIRIM
                String strNama = Nama.getText().toString();
                String strnpm = Npm.getText().toString();
                String strfak = fak.getText().toString();
                String strprody = prody.getText().toString();
                String strAlamat = Alamat.getText().toString();
                String strNope = Nope.getText().toString();

                /// MEMBUAT KONDISI JIKA EDITTEXT KOSONG
                if (strNama.isEmpty() || strnpm.isEmpty() || strAlamat.isEmpty() || strfak.isEmpty() || strprody.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Di Isi dulu Gan Edittext nya :D", Toast.LENGTH_SHORT).show();
                } else {

                    /// UNTUK MENGIRIM DATA KITA MENGUNAKAN INTENT DENGAN FUNGSI PUTEXTRA
                    Intent activityPenerima = new Intent(MainActivity.this, tampil.class);
                    activityPenerima.putExtra(KEY_Nama, strNama);
                    activityPenerima.putExtra(KEY_Npm, strnpm);
                    activityPenerima.putExtra(KEY_fak, strfak);
                    activityPenerima.putExtra(KEY_prody, strprody);
                    activityPenerima.putExtra(KEY_Alamat, strAlamat);
                    activityPenerima.putExtra(KEY_Nope, strNope);
                    startActivity(activityPenerima);
                }

            }
        });

    }
}
