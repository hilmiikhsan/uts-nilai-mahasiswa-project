import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mahasiswa22552012003 {
	private String npm;
	private int ip;
	
	public Mahasiswa22552012003(String npm, int ip) {
		this.npm = npm;
		this.ip = ip;
	}
	
	public String getNPM() {
		return npm;
	}
	
	public int getIP() {
		return ip;
	}
	
	public String getNilaiMahasiswa() {
		if (ip >= 90) {
			return "A";
		} else if (ip >= 80 && ip < 90) {
            return "B";
        } else if (ip >= 60 && ip < 80) {
            return "C";
        } else if (ip >= 40 && ip < 60) {
            return "D";
        } else {
            return "E";
        }
	}
	
	public String getDetailNilaiMahasiswa() {
		String nilai = getNilaiMahasiswa();
		switch (nilai) {
        case "A":
        case "B":
        case "C":
            return "Lulus";
        case "D":
            return "Perlu Diperbaiki";
        default:
            return "Tidak Lulus";
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		try {
		    File file = new File("src/nilai-mahasiswa.txt");
		    Scanner scanner = new Scanner(file);
		    while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] data = line.split(",");
				String npm = data[0];
				int ip = Integer.parseInt(data[1]);
				Mahasiswa22552012003 mahasiswa = new Mahasiswa22552012003(npm, ip);
	            System.out.println("NPM: " + mahasiswa.getNPM());
	            System.out.println("IP: " + mahasiswa.getIP());
	            System.out.println("Nilai: " + mahasiswa.getNilaiMahasiswa());
	            System.out.println("Keterangan: " + mahasiswa.getDetailNilaiMahasiswa());
	            while (!mahasiswa.getDetailNilaiMahasiswa().equals("Lulus")) {
	                ip += 10;
	                mahasiswa = new Mahasiswa22552012003(npm, ip);
	                System.out.println("Mencoba IP baru: " + ip);
	                System.out.println("Nilai: " + mahasiswa.getNilaiMahasiswa());
	                System.out.println("Keterangan: " + mahasiswa.getDetailNilaiMahasiswa());
	            }
	            System.out.println();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
		    System.out.println("File tidak ditemukan atau tidak dapat dibuka");
		}
	}
}
