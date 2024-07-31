package main;

import data.Dosen;
import utils.CSVUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Contoh data dosen
        List<Dosen> dosenList = new ArrayList<>();
        dosenList.add(new Dosen("123456789", "Informatika", "Dr. John Doe", "Laki-laki", "01-01-1970", "Jakarta", "Jl. Raya No. 10", "Professor", "A"));
        dosenList.add(new Dosen("987654321", "Sistem Informasi", "Dr. Jane Smith", "Perempuan", "02-02-1980", "Bandung", "Jl. Merdeka No. 20", "Lecturer", "B"));

        // File path untuk menyimpan data dosen
        String filePath = "Dosen.csv";

        // Menulis data ke file CSV
        try {
            CSVUtil.writeDosenToCSV(dosenList, filePath);
            System.out.println("Data dosen berhasil disimpan ke " + filePath);
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menyimpan data dosen: " + e.getMessage());
        }

        // Membaca data dari file CSV
        try {
            List<Dosen> readDosenList = CSVUtil.readDosenFromCSV(filePath);
            System.out.println("Data dosen yang dibaca dari CSV:");
            for (Dosen d : readDosenList) {
                System.out.println(String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s",
                        d.getNidn(), d.getProdi(), d.getNama(), d.getJenisKelamin(), d.getTglLahir(),
                        d.getTempatLahir(), d.getAlamat(), d.getJabatanFungsional(), d.getGol()));
            }
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat membaca data dosen: " + e.getMessage());
        }
    }
}
