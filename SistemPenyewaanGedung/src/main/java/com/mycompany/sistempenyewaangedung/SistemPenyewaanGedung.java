/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistempenyewaangedung;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.Scanner;

public class SistemPenyewaanGedung {
    static ArrayList<String[]> daftarPenyewaan = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static int idCounter = 1;
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistem Penyewaan Gedung Serbaguna Mustika Jaya ===");
            System.out.println("1. Tambah Penyewaan");
            System.out.println("2. Lihat Semua Penyewaan");
            System.out.println("3. Ubah Data Penyewaan");
            System.out.println("4. Hapus Data Penyewaan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            int pilihan = input.nextInt();
            input.nextLine(); 
            
            switch (pilihan) {
                case 1:
                    tambahPenyewaan();
                    break;
                case 2:
                    tampilkanPenyewaan();
                    break;
                case 3:
                    ubahPenyewaan();
                    break;
                case 4:
                    hapusPenyewaan();
                    break;
                case 5:
                    System.out.println("Terima kasih, silahkan datang kembali");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, silahkan coba lagi.");
                   
            }        

        }

    }
    
    public static void tambahPenyewaan() {
        System.out.print("Nama Penyewa: ");
        String nama = input.nextLine();
        System.out.print("Jenis Kegiatan: ");
        String kegiatan = input.nextLine();
        System.out.print("Tanggal Sewa (DD-MM-YYYY): ");
        String tanggal = input.nextLine();
        System.out.print("Lama Sewa (hari): ");
        String lama = input.nextLine();

        String id = String.valueOf(idCounter++);
        String[] data = {id, nama, kegiatan, tanggal, lama};
        daftarPenyewaan.add(data);

        
        System.out.println("Data berhasil ditambahkan.");
        
    }

    public static void tampilkanPenyewaan() {
        if (daftarPenyewaan.isEmpty()) {
            System.out.println("Belum ada data penyewaan.");
            return;
        }

        System.out.println("\n--- Daftar Penyewaan ---");
        for (String[] data : daftarPenyewaan) {
            System.out.println("ID Penyewaan : " + data[0]);
            System.out.println("Nama Penyewa : " + data[1]);
            System.out.println("Jenis Kegiatan : " + data[2]);
            System.out.println("Tanggal Sewa : " + data[3]);        ;
            System.out.println("Lama Sewa    : " + data[4] + " hari");
            System.out.println("----------------------------");
        }
    }

    public static void ubahPenyewaan() {
        System.out.print("Masukkan ID penyewaan yang ingin diubah: ");
        String id = input.nextLine();

        for (int i = 0; i < daftarPenyewaan.size(); i++) {
            String[] data = daftarPenyewaan.get(i);
            if (data[0].equals(id)) {
                System.out.print("Tanggal Sewa Baru (DD-MM-YYYY): ");
                data[3] = input.nextLine();
                System.out.print("Lama Sewa Baru (hari): ");
                data[4] = input.nextLine();
                System.out.println("Data berhasil diubah.");
                return;
            }
        }
        System.out.println("Data dengan ID tersebut tidak ditemukan.");
    }

    public static void hapusPenyewaan() {
        System.out.print("Masukkan ID penyewaan yang ingin dihapus: ");
        String id = input.nextLine();

        for (int i = 0; i < daftarPenyewaan.size(); i++) {
            if (daftarPenyewaan.get(i)[0].equals(id)) {
                daftarPenyewaan.remove(i);
                System.out.println("Data berhasil dihapus.");
                return;
            }
        }
        System.out.println("Data dengan ID tersebut tidak ditemukan.");
    }    
}
    
    
    
    
