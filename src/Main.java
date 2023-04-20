import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("******** Ekonomikos Fakultetas ********");
        StudentasImpl st1 = new StudentasImpl(753684,"Barkauskas Viktoras","1985.04.20","1A",5.2);
        StudentasImpl st2 = new StudentasImpl(856932,"Jonauskas Jonas","1986.02.12","2A",8.6);
        StudentasImpl st3 = new StudentasImpl(425698,"Grybauskas Tadas","1985.02.02","1B",7.2);
        StudentasImpl st4 = new StudentasImpl(235689,"Bite Marija","1985.03.13","2A",9.8);
        StudentasImpl st5 = new StudentasImpl(854796,"Kavaliauskaite Vika","1987.02.15","2B",9.9);
        StudentasImpl st6 = new StudentasImpl(258745,"Fabrikaite Kristina","1984.10.07","2A",6.2);
        StudentasImpl st7 = new StudentasImpl(256389,"Dolerauskas Linas","1985.09.02","1B",8.4);
        StudentasImpl st8 = new StudentasImpl(589642,"Zaliuzauskas Tomas","1987.10.20","2A",7.3);
        StudentasImpl st9 = new StudentasImpl(856932,"Prudauskas Ignas","1987.04.16","2B",9.2);
        StudentasImpl st10 = new StudentasImpl(254781,"Zuokas Arte","1986.06.01","1A",4.2);


        ArrayList <StudentasImpl> ktu = new ArrayList<>();

        ktu.addAll(Arrays.asList(st1,st2,st3,st4,st5,st6,st7,st8,st9,st10));

        System.out.println("________Pradinis Studentu sarasas___________\n");
        spausdintiStudentus(ktu);
        System.out.println("________Surusiuotas KTU sarasas geriausiu studentu___________\n");
        Collections.sort(ktu);
        spausdintiStudentus(ktu);
        System.out.println("________Salinami Studentai kurių vidurkis neigiamas ___________\n");
        salintiStudenta_PagalVidurki(ktu,5);
        spausdintiStudentus(ktu);
        gautiFakultetoStudentus("2B",ktu);

       List<StudentasImpl>fakultetas = Arrays.asList(st1,st2,st3,st4,st5,st6,st7,st8,st9,st10);
       StudentasImpl minVidurkis = fakultetas
               .stream()
               .min(Comparator.comparing(StudentasImpl ::getvidurkis))
               .orElseThrow(NoSuchElementException::new);
        System.out.println(" Blogiausias Studentas "+minVidurkis+"\n");

        StudentasImpl maxVidurkis = fakultetas
                .stream()
                .max(Comparator.comparing(StudentasImpl ::getvidurkis))
                .orElseThrow(NoSuchElementException::new);
       System.out.println(" Geriausias Studentas "+maxVidurkis+"\n");

      // spausdintiStudentus(ktu);







        pakeistiVidurkius_MinSuMax(ktu,minVidurkioIndeksas(ktu),maxVidurkioIndeksas(ktu));
        spausdintiStudentus(ktu);

        sukeistiStudentuVidurki(ktu);
        spausdintiStudentus(ktu);







    }
    public static void spausdintiStudentus(ArrayList<StudentasImpl> ktu){
        for (StudentasImpl studentas : ktu) {
            System.out.println(studentas);

        }
    }
    public static void salintiStudenta_PagalVidurki (ArrayList<StudentasImpl>ktu, double vidurkis){
        Iterator<StudentasImpl> i = ktu.iterator();
        while (i.hasNext()){
            StudentasImpl studentas= i.next();
            if(studentas.getvidurkis() < vidurkis){
                i.remove();
            }
        }
    }
    //grupės studentų skaičių, panaudojant funkciją 'int gautiFakultetoStudentus(String grupe, ArrayList <>)'.


    public static void gautiFakultetoStudentus(String grupe, ArrayList<StudentasImpl> ktu){
        int indeksas=0;
        for (StudentasImpl studentas : ktu){
            if(studentas.getgrupe() == grupe){
                indeksas++;
            }
        }
        System.out.println("\n"+".......... Grupeje '" + grupe + "' mokinasi " + indeksas+ " studentai.........\n" );
    }
    public static double maxVidurkis(ArrayList<StudentasImpl> ktu){
        Map<Integer,Double>map = ktu.stream().collect(Collectors.toMap(StudentasImpl::getpazimejimoNr,StudentasImpl::getvidurkis));
        double max = Collections.max(map.values());
        return max;
    }
    public static double minVidurkis(ArrayList<StudentasImpl> ktu){
        Map<Integer,Double>map = ktu.stream().collect(Collectors.toMap(StudentasImpl::getpazimejimoNr,StudentasImpl::getvidurkis));
        double min = Collections.min(map.values());
        return min;

    }

    public static int maxVidurkioIndeksas(ArrayList<StudentasImpl>sarasas){
        Iterator<StudentasImpl> stx = sarasas.iterator();
        double min = 1000;
        int index = 0;
        int i = 0;
        for (sarasas.iterator();stx.hasNext(); index++){
            StudentasImpl studentai = stx.next();
            if (studentai.getvidurkis()<min){
                min=studentai.getvidurkis();
                i= index;
            }
        }
        return i;
    }
    public static int minVidurkioIndeksas(ArrayList<StudentasImpl>sarasas){
        Iterator<StudentasImpl> stx = sarasas.iterator();
        double max = -1000;
        int index = 0;
        int i = 0;
        for (sarasas.iterator();stx.hasNext(); index++){
            StudentasImpl studentai = stx.next();
            if (studentai.getvidurkis()>max){
                max=studentai.getvidurkis();
                i= index;
            }
        }
        return i;
    }


    public static void pakeistiVidurkius_MinSuMax (ArrayList<StudentasImpl>ktu,int min, int max){
        Collections.swap(ktu,min,max);



    }
    static void sukeistiStudentuVidurki(ArrayList<StudentasImpl> ktu){
        double max = Collections.min(ktu).getvidurkis();
        double min = Collections.max(ktu).getvidurkis();

        for (StudentasImpl studentas : ktu){
            if (studentas.getvidurkis() == min){
                studentas.setvidurkis(max);
            }
            else if (studentas.getvidurkis() == max){
                studentas.setvidurkis(min);
            }
        }
        System.out.println("*************** Sukeisti studentu vidurkiai max su min ***************\n");

    }
    public static void rastiDiziausiaVidurki(ArrayList<StudentasImpl>ktu) {
        double max = -9999;
        int n = ktu.size();
        for (StudentasImpl vidurkis : ktu) {
            if (vidurkis instanceof StudentasImpl) {

                StudentasImpl studentas = (StudentasImpl) vidurkis;

                studentas.getvidurkis();



                    System.out.println("vidurkis max "  );


            }


        }




    }




}