package utils;

import data.Dosen;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    // Method to write a list of Dosen objects to CSV
    public static void writeDosenToCSV(List<Dosen> dosenList, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("NIDN,Prodi,Nama,JenisKelamin,TglLahir,TempatLahir,Alamat,JabatanFungsional,Gol\n");
            for (Dosen d : dosenList) {
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                        d.getNidn(), d.getProdi(), d.getNama(), d.getJenisKelamin(), d.getTglLahir(),
                        d.getTempatLahir(), d.getAlamat(), d.getJabatanFungsional(), d.getGol()));
            }
        }
    }

    // Method to read a list of Dosen objects from CSV
    public static List<Dosen> readDosenFromCSV(String filePath) throws IOException {
        List<Dosen> dosenList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                dosenList.add(new Dosen(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]));
            }
        }
        return dosenList;
    }
}
