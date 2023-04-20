import java.util.Comparator;

public class StudentasImpl implements Studentas , Comparable<StudentasImpl>{
    private int pazimejimoNr;
    private String pavardeVardas;
    private String gimimoData;
    private String grupe;
    private double vidurkis;

    public StudentasImpl() {

    }

    public StudentasImpl(int pazimejimoNr, String pavardeVardas, String gimimoData, String grupe, double vidurkis) {
        this.pazimejimoNr = pazimejimoNr;
        this.pavardeVardas = pavardeVardas;
        this.gimimoData = gimimoData;
        this.grupe = grupe;
        this.vidurkis = vidurkis;
    }


    @Override
    public String toString() {
        return
                "Pazimejimo Nr. " + pazimejimoNr  +
                ", Pavarde Vardas: " + pavardeVardas  +
                ", Gimimo Data: " + gimimoData +
                ", Grupe_" + grupe +
                ", Vidurkis " + vidurkis ;
    }

    /**
     * @return
     */
    @Override
    public int getpazimejimoNr() {
        return pazimejimoNr;
    }

    /**
     * @param pazimejimoNr
     */
    @Override
    public void setpazimejimoNr(int pazimejimoNr) {
        this.pazimejimoNr = pazimejimoNr;

    }

    /**
     * @return
     */
    @Override
    public String getpavardeVardas() {
        return pavardeVardas;
    }

    /**
     * @param pavardeVardas
     */
    @Override
    public void setpavardeVardas(String pavardeVardas) {
        this.pavardeVardas=pavardeVardas;

    }

    /**
     * @return
     */
    @Override
    public String getgimimoData() {
        return gimimoData;
    }

    /**
     * @return
     */
    @Override
    public String getgrupe() {
        return grupe;
    }

    /**
     * @param grupe
     */
    @Override
    public void setgrupe(String grupe) {
        this.grupe=grupe;

    }

    /**
     * @return
     */
    @Override
    public double getvidurkis() {
        return vidurkis;
    }

    @Override
    public void setvidurkis(double vidurkis) {

    }

    /**
     * @param studentai the object to be compared.
     * @return
     */
    @Override
    public int compareTo(StudentasImpl studentai) {
        return Comparator
                .comparing(StudentasImpl :: getvidurkis)
                .reversed()
                .compare(this,studentai);
    }

    //@Override // padaryti Integer vidurki
    ///public int compare(StudentasImpl e1, StudentasImpl e2) {
    ///    return e1.getvidurkis().compareTo(e2.getvidurkis());
   // }
}
//todo
//0. Naujas projektas (!)
//1. Kiekvienas fakultete esantis studentas turi:
//    pažymėjimo nr.;
//    pavardė vardas (vienas laukelis);
//    gimimo data;
//    grupė;
//    vidurkis.
//2. Fakultete studijuoja 10 studentų iš skirtingų grupių ir su skirtingais vidurkiais.
//3. Atspausdinti visus fakulteto studentus vartotojui į ekraną.
//4. Suteikti galimybę vartotojui rasti konkrečios grupės studentų skaičių, panaudojant funkciją 'int gautiFakultetoStudentus(String grupe, ArrayList studentai)'.
//5. Surikiuoti ir atspausdinti pagal pažangumą moksleivius nuo geriausiai iki prasčiausiai besimokančio.
//6. Pašalinti iš sąrašo tuos moksleivius, kurių vidurkis neigiamas (mažiau už 4). Atspausdinti pakeistą sąrašą.
//7. Sukeisti vidurkius geriausiai ir prasčiausiai besimokančių studentų.
//8. Sukurti galimybę vartotojui atlikti studentų paiešką pagal pavardę arba gimimo datą. Vartotojas turi įvesti kriterijus į terminalą (Scanner).

